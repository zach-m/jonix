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

package com.tectonica.jonix.codegen;

import java.util.Iterator;
import java.util.List;

public class ListDiff
{
	public static interface CompareListener<T>
	{
		void onDiff(T itemL, T itemR);
	}

	/**
	 * compares two <strong>sorted</strong> lists
	 */
	public static <T extends Comparable<? super T>> void compare(List<T> listL, List<T> listR, CompareListener<T> listener)
	{
		final Iterator<T> iterL = (listL == null) ? null : listL.iterator();
		final Iterator<T> iterR = (listR == null) ? null : listR.iterator();
		T itemL = null, itemR = null;
		boolean iterLbehind = (listL != null), iterRbehind = (listR != null);
		while (true)
		{
			if (iterLbehind)
				itemL = iterL.hasNext() ? iterL.next() : null;
			if (iterRbehind)
				itemR = iterR.hasNext() ? iterR.next() : null;

			if (itemL == null && itemR == null)
				break;

			iterLbehind = (itemL != null) && (itemR == null || (itemL.compareTo(itemR) <= 0));
			iterRbehind = (itemR != null) && (itemL == null || (itemR.compareTo(itemL) <= 0));

			if (iterLbehind && iterRbehind)
				listener.onDiff(itemL, itemR);
			else if (iterLbehind)
				listener.onDiff(itemL, null);
			else if (iterRbehind)
				listener.onDiff(null, itemR);
		}
	}
}
