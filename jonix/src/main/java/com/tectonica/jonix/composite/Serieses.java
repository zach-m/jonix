package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class Serieses extends JonixComposite<Serieses.Series>
{
	private static final long serialVersionUID = 2257682756445574223L;

	public static class Series implements Serializable
	{
		private static final long serialVersionUID = -6094006852157355406L;
		
		public String titleOfSeries;
		public String seriesISSN;
		public SeriesIdentifiers seriesIdentifiers = new SeriesIdentifiers();
		public Titles titles = new Titles();
		public Contributors contributors = new Contributors();

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			for (SeriesIdentifiers.SeriesIdentifier seriesIdentifier : seriesIdentifiers)
				sb.append("\n    ").append(seriesIdentifier.toString());
			for (Titles.Title title : titles)
				sb.append("\n    ").append(title.toString());
			for (Contributors.Contributor contributor : contributors)
				sb.append("\n    ").append(contributor.toString());
			return String.format("Series: %s (%s) %s", titleOfSeries, seriesISSN, sb.toString());
		}
	}
	private transient Series activeItem;

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.Series)
		{
			add(activeItem = new Series());
			return this;
		}
		
		if (resolver.onixTypeOf(parent) == ONIX.Series)
		{
			switch (resolver.onixTypeOf(o))
			{
				case TitleOfSeries:
					activeItem.titleOfSeries = JonixUtils.getValueAsStr(o);
					break;
					
				case SeriesISSN:
					activeItem.seriesISSN = JonixUtils.getValueAsStr(o);
					break;
					
				case SeriesIdentifier:
					return activeItem.seriesIdentifiers.consume(o, parent, grandParent, resolver);
					
				case Title:
					return activeItem.titles.consume(o, parent, grandParent, resolver);
					
				case Contributor:
					return activeItem.contributors.consume(o, parent, grandParent, resolver);
					
				default:
					break;
			}
		}
		
		return null;
	}
}
