package com.tectonica.jonix.composites;

@SuppressWarnings("serial")
public class Serieses extends JonixComposite<Serieses.Series>
{
	public Serieses()
	{
		super(Series.class);
	}
	
	public static class Series
	{
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
}
