/*
    This file is part of RouteConverter.

    RouteConverter is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    RouteConverter is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with RouteConverter; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Copyright (C) 2007 Christian Pesch. All Rights Reserved.
*/

package slash.navigation.nmn;

import slash.navigation.Wgs84Position;
import slash.navigation.util.Conversion;
import slash.navigation.util.CompactCalendar;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads and writes Navigon Mobile Navigator 6 Favorites (.storage) files.
 * <p/>
 * Format: [P HALLENEU CINEMAXX||][0][10]|11.92417,51.47978|06122|11.92417|51.47978[8]|NEUSTÄDTER PASSAGE|06122|11.92678|51.48087[7]|NEUSTADT|[6]|HALLE (SAALE)|06108|11.97546|51.48129[3]|HALLE (SAALE)|[2]|Sachsen-Anhalt||4366[0]|Deutschland||17<br/>
 *         [P SCHIERKE         ||][0][15]|AM THÄLCHEN      |38879|10.66664|51.76459|633,0|1[14]|Alle Kategorien||196658,0[13]|Parken||3,0[6]|SCHIERKE|38879|10.65527|51.76586[3]|WERNIGERODE|[2]|Sachsen-Anhalt||4366[0]|Deutschland||17<br/>
 *         [HYGIENE4YOU        ||][0][10]|15.43511,47.07848     ||15.43511|47.07848[8]|WICKENBURGGASSE   |8010 |15.43655|47.07876[6]|GRAZ    |8010|15.44273|47.06833[3]|GRAZ|[2]|Steiermark||1030[0]|Österreich||4<br/>
 *         [HYGIENE4YOU|UserWords3|][0][10]|15.43511,47.07848||15.43511|47.07848[8]|WICKENBURGGASSE|8010|15.43655|47.07876[6]|GRAZ|8010|15.44273|47.06833[3]|GRAZ|[2]|Steiermark||1030[0]|Österreich||4
 *
 * @author Christian Pesch
 */

public class Nmn6FavoritesFormat extends NmnFormat {
    private static final String WILDCARD = "[.[^" + SEPARATOR_CHAR + "\\p{Lower}]]*";

    // [P HALLENEU CINEMAXX||][0][10]|11.92417,51.47978|06122|11.92417|51.47978[8]|NEUSTÄDTER PASSAGE|06122|11.92678|51.48087[7]|NEUSTADT|[6]|HALLE (SAALE)|06108|11.97546|51.48129[3]|HALLE (SAALE)|[2]|Sachsen-Anhalt||4366[0]|Deutschland||17
    // [P SCHIERKE         ||][0][15]|AM THÄLCHEN      |38879|10.66664|51.76459|633,0|1[14]|Alle Kategorien||196658,0[13]|Parken||3,0[6]|SCHIERKE|38879|10.65527|51.76586[3]|WERNIGERODE|[2]|Sachsen-Anhalt||4366[0]|Deutschland||17
    // [HYGIENE4YOU        ||][0][10]|15.43511,47.07848     ||15.43511|47.07848[8]|WICKENBURGGASSE   |8010 |15.43655|47.07876[6]|GRAZ    |8010|15.44273|47.06833[3]|GRAZ|[2]|Steiermark||1030[0]|Österreich||4
    // [HYGIENE4YOU|UserWords3|][0][10]|15.43511,47.07848||15.43511|47.07848[8]|WICKENBURGGASSE|8010|15.43655|47.07876[6]|GRAZ|8010|15.44273|47.06833[3]|GRAZ|[2]|Steiermark||1030[0]|Österreich||4
    private static final Pattern POSITION_PATTERN = Pattern.
                    compile("\\" + LEFT_BRACE + "(" + WILDCARD + ")" + SEPARATOR + WILDCARD + SEPARATOR + "?\\" + RIGHT_BRACE +
                    "\\" + LEFT_BRACE + "\\d+\\" + RIGHT_BRACE +
                    "\\" + LEFT_BRACE + "\\d+\\" + RIGHT_BRACE +
                    SEPARATOR + WILDCARD +
                    SEPARATOR + WILDCARD +
                    SEPARATOR + "(" + POSITION + ")" + SEPARATOR + "(" + POSITION + ")" +
                    "\\" + LEFT_BRACE + "?\\d*\\" + RIGHT_BRACE + "?" +
                    SEPARATOR + "(" + WILDCARD + ")" +
                    "(.*)" +
                    SEPARATOR + SEPARATOR + "4");

    public String getName() {
        return "Navigon Mobile Navigator 6 Favorites (*" + getExtension() + ")";
    }


    public String getExtension() {
        return ".storage";
    }

    protected boolean isPosition(String line) {
        Matcher matcher = POSITION_PATTERN.matcher(line);
        return matcher.matches();
    }

    protected NmnPosition parsePosition(String line, CompactCalendar startDate) {
        Matcher lineMatcher = POSITION_PATTERN.matcher(line);
        if (!lineMatcher.matches())
            throw new IllegalArgumentException("'" + line + "' does not match");
        String city = Conversion.trim(lineMatcher.group(1));
        String longitude = lineMatcher.group(2);
        String latitude = lineMatcher.group(3);
        String street = Conversion.trim(lineMatcher.group(4));
        String comment = (city != null ? city + " " : "") + (street != null ? street : "");
        if (comment.toUpperCase().equals(comment))
            comment = Conversion.toMixedCase(comment);
        return new NmnPosition(Conversion.parseDouble(longitude), Conversion.parseDouble(latitude), (Double) null, null, null, Conversion.trim(comment));
    }

    private static String formatForNmnFavorites(String string) {
        return string != null ? string.replaceAll("[\\" + LEFT_BRACE + "|" + SEPARATOR + "|\\" + RIGHT_BRACE + "]", "").toUpperCase() : "";
    }

    protected void writePosition(Wgs84Position position, PrintWriter writer, int index, boolean firstPosition) {
        String longitude = Conversion.formatDoubleAsString(position.getLongitude());
        String latitude = Conversion.formatDoubleAsString(position.getLatitude());
        String comment = formatForNmnFavorites(position.getComment());
        writer.println(LEFT_BRACE + comment + SEPARATOR_CHAR + RIGHT_BRACE +
                LEFT_BRACE + "0" + RIGHT_BRACE + LEFT_BRACE + "10" + RIGHT_BRACE +
                SEPARATOR_CHAR + SEPARATOR_CHAR + SEPARATOR_CHAR +
                longitude + SEPARATOR_CHAR + latitude + SEPARATOR_CHAR + SEPARATOR_CHAR + SEPARATOR_CHAR +
                longitude + SEPARATOR_CHAR + latitude + SEPARATOR_CHAR +
                comment + SEPARATOR_CHAR + SEPARATOR_CHAR +
                comment + SEPARATOR_CHAR + SEPARATOR_CHAR +
                longitude + SEPARATOR_CHAR + latitude + SEPARATOR_CHAR +
                comment + SEPARATOR_CHAR + SEPARATOR_CHAR +
                SEPARATOR_CHAR + SEPARATOR_CHAR +
                SEPARATOR_CHAR + SEPARATOR_CHAR + SEPARATOR_CHAR + "4"
        );
    }
}
