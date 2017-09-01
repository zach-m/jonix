/*
 *   Copyright © 2015 Francisco Sariego Rodríguez
 *
 *   $Id: ISBNHyphenAppender.java 37 2015-01-31 14:25:02Z frsarieg $
 *
 *   This file is part of ISBNHyphenAppender.
 *
 *   ISBNHyphenAppender is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   ISBNHyphenAppender is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with ISBNHyphenAppender.  If not, see <http://www.gnu.org/licenses/>.
 */
package repackaged.net.sourceforge.isbnhyphenappender;

import java.util.Arrays;

/**
 * Appends hyphens to ISBN-10 and ISBN-13 without hyphens.
 *
 * @author Francisco Sariego Rodríguez
 * @version $Revision: 37 $ $Id: ISBNHyphenAppender.java 37 2015-01-31 14:25:02Z frsarieg $
 */
public class ISBNHyphenAppender {

    /**
     * Appends hyphens to an ISBN-10 without hyphens.
     * <p>
     * In an ISBN-10 with hyphens, these hyphens separate the number of the
     * group (similar but no equal to country), the number of the editor, the
     * number of the title and the "checksum" number.
     *
     * @param ISBN10 ISBN-10 to which hyphens are to be added
     * @return the ISBN-10 with the added hyphens
     * @throws NullPointerException if the ISBN-10 provided is {@code null}
     * @throws IllegalArgumentException if the length of the ISBN-10 provided is
     * not 10
     * @throws UnsupportedOperationException if the ISBN-10 provided is from a
     * ISBN group not implemented
     * @deprecated 
     */
    @Deprecated
    public String appendHyphenToISBN10(String ISBN10) {
        //Checks if the ISBN-10 is null
        if (ISBN10 == null) {
            throw new NullPointerException("The ISBN provided cannot be"
                    + " null.");
        }

        //Checks if the length of the ISBN is 10
        if (ISBN10.length() != 10) {
            throw new IllegalArgumentException("The ISBN " + ISBN10
                    + " is not an ISBN-10. The length of the ISBN provided is"
                    + " not 10.");
        }

        return this.appendHyphenToISBN(ISBN10);
    }

    /**
     * Appends hyphens to an ISBN-13 without hyphens.
     * <p>
     * In an ISBN-13 with hyphens, these hyphens separate the first three
     * digits, the number of the group (similar but no equal to country), the
     * number of the editor, the number of the title and the "checksum" number.
     *
     * @param ISBN13 ISBN to which hyphens are to be added
     * @return the ISBN-13 with the added hyphens
     * @throws NullPointerException if the ISBN-13 provided is {@code null}
     * @throws IllegalArgumentException if the length of the ISBN-13 provided is
     * not 13
     * @throws UnsupportedOperationException if the ISBN-13 provided is from a
     * ISBN group not implemented
     * @deprecated 
     */
    @Deprecated
    public String appendHyphenToISBN13(String ISBN13) {
        //Checks if the ISBN is null
        if (ISBN13 == null) {
            throw new NullPointerException("The ISBN provided cannot be"
                    + " null.");
        }

        //Checks if the length of the ISBN is 10
        if (ISBN13.length() != 13) {
            throw new IllegalArgumentException("The ISBN " + ISBN13
                    + " is not an ISBN-13. The length of the ISBN provided"
                    + " is not 13.");
        }

        return this.appendHyphenToISBN(ISBN13);
    }

    /**
     * Appends hyphens to an ISBN-10 or ISBN-13 without hyphens.
     * <p>
     * In an ISBN-10 with hyphens, these hyphens separate the number of the
     * group (similar but no equal to country), the number of the editor, the
     * number of the title and the "checksum" number. The ISBN-13 adds a 3 digit
     * code before.
     *
     * @param ISBN ISBN to which hyphens are to be added
     * @return the ISBN with the added hyphens
     * @throws NullPointerException if the ISBN-10 provided is {@code null}
     * @throws IllegalArgumentException if the length of the ISBN provided is
     * not 10 or 13
     * @throws UnsupportedOperationException if the ISBN provided is from a ISBN
     * group not implemented
     */
    public String appendHyphenToISBN(String ISBN) {
        //Checks if the ISBN is null
        if (ISBN == null) {
            throw new NullPointerException("The ISBN provided cannot be null.");
        }

        String ISBN13;
        //Checks if the length of the ISBN is 10
        if (ISBN.length() == 10) {
            ISBN13 = "978" + ISBN;
        } else {
            if (ISBN.length() == 13) {
                ISBN13 = ISBN;
            } else {
                throw new IllegalArgumentException("The ISBN " + ISBN
                        + " provided is not an ISBN.");
            }
        }

        //Gets the group for the ISBN
        Group group = Group.getGroup(ISBN13);

        //Checks if the group of the ISBN is implemented
        if (group == null) {
            throw new UnsupportedOperationException(ISBN
                    + " is from a group not implemented.");
        }

        //Gets the group number
        String groupNumber = String.valueOf(group.getNumber());

        int groupNumberLength;
        if (ISBN.length() == 10) {
            groupNumber = groupNumber.substring(3);
            //Gets the length of the group number
            groupNumberLength = groupNumber.length();
        } else {
            //Gets the length of the group number
            groupNumberLength = groupNumber.length();
            groupNumber = groupNumber.substring(0, 3) + '-'
                    + groupNumber.substring(3);
        }

        int maximumPublisherNumerLength =
                group.getMaximumPublisherNumberLength();

        //Gets the publisher part
        String publisherPart =
                ISBN.substring(groupNumberLength).
                substring(0, maximumPublisherNumerLength);

        //Gets the valid publisher numbers of the group
        String[][] validPublisherNumbers = group.getValidPublisherNumbers();

        //Tries to find the number of the publisher in one of the valid number
        //ranges for the group
        int i = 0;
        boolean found = false;
        while (!found && i < validPublisherNumbers.length) {

            //Add "0 padding" to the maximum length of the number of publisher
            String minValue = this.rightPad(validPublisherNumbers[i][0],
                    '0', maximumPublisherNumerLength);

            //Adds "9 padding" to the maxiumum publisher number length
            String maxValue = this.rightPad(validPublisherNumbers[i][1],
                    '9', maximumPublisherNumerLength);

            found = (publisherPart.compareTo(minValue) >= 0
                    && publisherPart.compareTo(maxValue) <= 0);

            i++;
        }

        String result;
        if (found) {
            //Gets the mid part
            //The mid part is the ISBN part without the group number and the
            //check digit
            String midPart = ISBN.substring(groupNumberLength, ISBN.length()
                    - 1);

            int midHyphenPosition = validPublisherNumbers[i - 1][0].length();

            //Builds the result with hyphens
            result = new StringBuilder(
                    //Appends the group number
                    groupNumber).
                    //Appends the first hyphen
                    append('-').
                    //Appends the number of the publisher
                    append(midPart.substring(0, midHyphenPosition)).
                    //Appends the mid hyphen
                    append('-').
                    //Appends the number of the title
                    append(midPart.substring(midHyphenPosition)).
                    //Appends the last hyphen
                    append('-').
                    //Appends the check number
                    append(ISBN.substring(ISBN.length() - 1)).toString();
        } else {
            throw new IllegalArgumentException(ISBN
                    + " is a invalid ISBN for this group.");
        }

        return result;
    }

    /**
     * Right pad a {@code String} with the specified {@code character}. The
     * string is padded to the size of {@code maxLength}.
     *
     * @param the String to pad
     * @param character the character to pad with
     * @param maxLength the size to pad to
     * @return right padded {@code String} or original {@code String} if no
     * padding is necessary
     * @throws NumberFormatException if the parameter {@code string} is null
     */
    private String rightPad(String string, char character, int maxLength) {
        int padLength = maxLength - string.length();
        if (padLength > 0) {
            char[] charPad = new char[padLength];

            Arrays.fill(charPad, character);

            string = new StringBuilder(string).append(String.valueOf(charPad)).
                    toString();
        }

        return string;
    }
}