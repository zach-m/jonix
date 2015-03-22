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

package com.tectonica.jonix.codelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList221
 * <p>
 * Message status
 * <p>
 * NOTE: Introduced in Onix3
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum MessageStatuss
{
	/**
	 * Message received but not yet parsed (Acknowledgement must contain neither <MessageStatusDetail> nor <RecordStatusSummary>, and should
	 * include <NoProduct/>). There is no particular implication that the acknowledgement message is valid – the status is based solely on
	 * receipt of a file and minimal parsing of the original ONIX message header to ascertain <MessageNumber> etc.. The Acknowledgement
	 * message MAY give a date when parsing is planned.
	 */
	Message_received("00"), //

	/**
	 * Entire original ONIX message rejected (ie NONE of the data records have been ingested). The status of any recognisable records MAY be
	 * summarised in the remainder of the Acknowledgement Message.
	 */
	Message_rejected("01"), //

	/**
	 * Original ONIX message partially parsed (ie at least SOME of the data records have been ingested, in whole or in part). Records
	 * processed to date MUST be summarised in the remainder of the Acknowledgement Message.
	 */
	Message_part_processed("02"), //

	/**
	 * Original ONIX message parsed and processed in full, and at least SOME of the data records have been ingested, in whole or in part),
	 * Results MUST be summarised in the remainder of the Acknowledgement Message.
	 */
	Message_processed("03");

	public final String value;

	private MessageStatuss(String value)
	{
		this.value = value;
	}

	public static MessageStatuss byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (MessageStatuss e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
