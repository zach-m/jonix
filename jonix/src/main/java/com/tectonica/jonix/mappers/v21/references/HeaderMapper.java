package com.tectonica.jonix.mappers.v21.references;

import org.editeur.onix.v21.references.FromCompany;
import org.editeur.onix.v21.references.FromEmail;
import org.editeur.onix.v21.references.FromPerson;
import org.editeur.onix.v21.references.Header;
import org.editeur.onix.v21.references.SentDate;
import org.editeur.onix.v21.references.ToCompany;
import com.tectonica.jonix.JonixHeader;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.JonixUtils.OnixObjectHandler;
import com.tectonica.jonix.mappers.IHeaderMapper;

public class HeaderMapper implements IHeaderMapper
{
	private HeaderHandler handler = new HeaderHandler();
	private JonixHeader header;

	public JonixHeader execute(Object o)
	{
		header = new JonixHeader();
		JonixUtils.forEach(o, null, true, 0, handler);
		return header;
	}

	private class HeaderHandler implements OnixObjectHandler
	{
		@Override
		public boolean handleOnixObject(Object o, Object parent, Object grandParent, int depth)
		{
			if (parent instanceof Header && grandParent == null)
			{
				if (o instanceof FromCompany)
					header.fromCompany = ((FromCompany) o).getValue();
				if (o instanceof FromPerson)
					header.fromPerson = ((FromPerson) o).getValue();
				if (o instanceof FromEmail)
					header.fromEmail = ((FromEmail) o).getValue();
				if (o instanceof ToCompany)
					header.toCompany = ((ToCompany) o).getValue();
				if (o instanceof SentDate)
					header.sentDate = ((SentDate) o).getValue();
			}
			return false; // we are currently not processing header composites, so no need to drill down
		}
	}
}
