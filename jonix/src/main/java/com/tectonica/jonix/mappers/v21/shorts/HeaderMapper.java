package com.tectonica.jonix.mappers.v21.shorts;

import org.editeur.onix.v21.shorts.Header;
import org.editeur.onix.v21.shorts.M174;
import org.editeur.onix.v21.shorts.M175;
import org.editeur.onix.v21.shorts.M178;
import org.editeur.onix.v21.shorts.M182;
import org.editeur.onix.v21.shorts.M283;
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
				if (o instanceof M174)
					header.fromCompany = ((M174) o).getValue();
				if (o instanceof M175)
					header.fromPerson = ((M175) o).getValue();
				if (o instanceof M283)
					header.fromEmail = ((M283) o).getValue();
				if (o instanceof M178)
					header.toCompany = ((M178) o).getValue();
				if (o instanceof M182)
					header.sentDate = ((M182) o).getValue();
			}
			return false; // we are currently not processing header composites, so no need to drill down
		}
	}
}
