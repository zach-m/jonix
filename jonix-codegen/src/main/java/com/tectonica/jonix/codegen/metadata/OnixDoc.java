package com.tectonica.jonix.codegen.metadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tectonica.jonix.codegen.util.XML;

@JsonPropertyOrder({ "tags", "title", "descriptionHtml", "details" })
public class OnixDoc
{
	public enum DetailType
	{
		format("Format"), //
		codelist("Codelist"), //
		referencename("Reference name"), //
		shorttag("Short tag"), //
		example("Example"), //
		cardinality("Cardinality"), // onix3 only
		attributes("Attributes"), // onix3 only
		notes("Notes"), // onix3 only
		unknown(""); //

		public final String label;

		private DetailType(String label)
		{
			this.label = label;
		}
	}

	@JsonPropertyOrder({ "detailType", "lines" })
	public static class Detail
	{
		public DetailType detailType;
		public List<String> lines;

		public Detail()
		{}

		public Detail(String detailName)
		{
			try
			{
				detailType = DetailType.valueOf(detailName);
			}
			catch (IllegalArgumentException e)
			{
				detailType = DetailType.unknown;
			}
			lines = new ArrayList<>();
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////

	// ONIX2: [new211, new212, deprecated, element, new210, new213, new214, composite]
	// ONIX3: [deprecated, element, new302, composite, new301]
	public Set<String> tags;

	public String title;

	public String descriptionHtml;

	public List<OnixDoc.Detail> details;

	public String toHtmlTable()
	{
		StringBuilder sb = new StringBuilder("<table><tbody>");
		sb.append("<h1>").append(XML.escape(title)).append("</h1>\n");
		sb.append("<h2>").append(tags.toString()).append("</h2>\n");
		sb.append(descriptionHtml).append("\n");
		for (OnixDoc.Detail detail : details)
		{
			if (detail.lines.size() == 0)
				continue;

			boolean first = true;
			for (String line : detail.lines)
			{
				sb.append("<tr>");

				// first column
				sb.append("<td>");
				if (first)
				{
					sb.append(detail.detailType.label);
					first = false;
				}
				sb.append("</td>");

				// second column
				sb.append("<td>");
				sb.append(XML.escape(line));
				sb.append("</td>");

				sb.append("</tr>");
			}
		}
		sb.append("</tbody></table>");
		return sb.toString();
	}
}