/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.extract;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ListIterator;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.JonixTabulator;
import com.tectonica.jonix.JonixUnifier;
import com.tectonica.jonix.JonixUtil;
import com.tectonica.jonix.stream.JonixStreamer;

/**
 * This extractor accumulates (in memory) the products it receives during streaming. When {@link #getUniqueProducts()}
 * is called, it filters the accumulated products so as to leave only one per product-ID. The chosen one is the first in
 * the sort order, which can be customized by the caller. Also, the very definition of what constitutes the product's ID
 * is also determined by the caller.
 * <p>
 * NOTE: sources that are read as {@link InputStream}s via {@link JonixStreamer#read(java.io.InputStream, String)} will
 * not enter the list. It is only intended for files (whose name and modification-time are crucial for the filtering)
 * 
 * @author Zach Melamed
 */
public class JonixUniqueExtractor<H, P> extends JonixUnifiedExtractor<H, P>
{
	protected final JonixColumn<P> idColumn;

	public JonixUniqueExtractor(JonixUnifier<H, P> unifier, JonixColumn<P> idColumn)
	{
		super(unifier);
		if (idColumn == null)
			throw new RuntimeException("ID column is required to define uniqueness");
		this.idColumn = idColumn;
	}

	public JonixColumn<P> getIdColumn()
	{
		return idColumn;
	}

	/**
	 * a wrapper for Product with some extra information needed for sorting and filtering
	 */
	protected static class ProductInfo<H, P>
	{
		public final String[] id;
		public final Calendar timestamp;
		public final P product;

		public ProductInfo(String[] id, Calendar timestamp, P product)
		{
			this.id = id;
			this.timestamp = timestamp;
			this.product = product;
		}
	}

	protected List<ProductInfo<H, P>> uniqueProducts = new ArrayList<>();
	protected boolean changed = false;

	private Calendar lastFileTimestamp;

	@Override
	protected boolean onBeforeFile(String fileName, JonixStreamer streamer)
	{
		lastFileTimestamp = JonixUtil.extractTimstampFromFileName(fileName);

		// if we couldn't extract the timestamp from the file's name, we fall back to its modification date
		if (lastFileTimestamp == null)
		{
			lastFileTimestamp = new GregorianCalendar();
			lastFileTimestamp.setTimeInMillis((new File(fileName)).lastModified());
		}

		return super.onBeforeFile(fileName, streamer);
	}

	@Override
	protected void onProduct(P product, JonixStreamer streamer)
	{
		String[] idData = JonixTabulator.newColumnBuffer(idColumn);

		if (idColumn.extractFrom(product, idData))
		{
			uniqueProducts.add(new ProductInfo<H, P>(idData, lastFileTimestamp, product));
			changed = true;
		}
	}

	// ////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns a filtered list of products, that includes - for each product-ID - only the one with the latest
	 * time-stamp (as extracted from its file name or modification-time)
	 */
	public List<ProductInfo<H, P>> getUniqueProducts()
	{
		return getUniqueProducts(new Comparator<ProductInfo<H, P>>()
		{
			/**
			 * sorts by descending order of timestamp. This will leave only the latest timestamp (per each product-id)
			 * when the products are filtered
			 */
			@Override
			public int compare(ProductInfo<H, P> p1, ProductInfo<H, P> p2)
			{
				return -p1.timestamp.compareTo(p2.timestamp);
			}
		});
	}

	/**
	 * Returns a filtered list of products, where each product-ID appears once
	 * 
	 * @param comparator
	 *            a custom {@link Comparator} for ordering products with identical IDs. Among all such products, the one
	 *            that compares to be the 'smallest' will be picked when the list is filtered
	 * @return
	 */
	public List<ProductInfo<H, P>> getUniqueProducts(final Comparator<ProductInfo<H, P>> comparator)
	{
		if (changed)
		{
			log("Sorting " + uniqueProducts.size() + " products..");
			Collections.sort(uniqueProducts, new Comparator<ProductInfo<H, P>>()
			{
				@Override
				public int compare(ProductInfo<H, P> p1, ProductInfo<H, P> p2)
				{
					int result = JonixUtil.compareArray(p1.id, p2.id);
					if (result == 0) // with the same id, we leave it for the caller to decide
						return comparator.compare(p1, p2);
					return result;
				}
			});

			log("Compacting..");
			String[] lastId = null;
			ListIterator<ProductInfo<H, P>> iter = uniqueProducts.listIterator();
			while (iter.hasNext())
			{
				ProductInfo<H, P> pi = iter.next();
				if (pi.id.equals(lastId))
					iter.remove();
				else
					lastId = pi.id;
			}
			changed = false;
		}
		return uniqueProducts;
	}
}
