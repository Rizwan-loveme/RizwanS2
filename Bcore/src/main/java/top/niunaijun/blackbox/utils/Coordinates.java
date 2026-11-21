package top.niunaijun.blackbox.utils;

import java.util.regex.Pattern;

/**
 * Reads a latitude / longitude that a person typed or pasted (for example "23.8103, 90.4125" copied
 * from a map app). No Android classes, so it can be tested on a plain JVM.
 *
 * <ul>
 *   <li>Bengali digits are accepted and turned into 0-9.</li>
 *   <li>A degree sign is ignored. The decimal separator is a dot.</li>
 *   <li>Latitude must be -90..90, longitude -180..180.</li>
 *   <li>0, 0 is refused: the engine treats it as "no location" ({@code BLocation.isEmpty()}), so it
 *       would silently do nothing.</li>
 * </ul>
 */
public final class Coordinates {

    public enum Error {
        NONE,
        /** A field is empty. */
        EMPTY,
        /** Not a plain decimal number. */
        NOT_A_NUMBER,
        LAT_RANGE,
        LON_RANGE,
        /** 0, 0 - means "no location" for the engine. */
        NULL_ISLAND
    }

    public static final class Result {
        public final double latitude;
        public final double longitude;
        public final Error error;

        private Result(double latitude, double longitude, Error error) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.error = error;
        }

        public boolean ok() {
            return error == Error.NONE;
        }
    }

    private static final Pattern NUMBER = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)");
    private static final Pattern SEPARATORS = Pattern.compile("[\\s,;]+");

    private Coordinates() {
    }

    /** Parses the two fields. */
    public static Result parse(String latitude, String longitude) {
        if (isBlank(latitude) || isBlank(longitude)) {
            return fail(Error.EMPTY);
        }
        Double lat = number(latitude);
        Double lon = number(longitude);
        if (lat == null || lon == null) {
            return fail(Error.NOT_A_NUMBER);
        }
        if (lat < -90 || lat > 90) {
            return fail(Error.LAT_RANGE);
        }
        if (lon < -180 || lon > 180) {
            return fail(Error.LON_RANGE);
        }
        if (lat == 0 && lon == 0) {
            return fail(Error.NULL_ISLAND);
        }
        return new Result(lat, lon, Error.NONE);
    }

    /**
     * Parses one text with both numbers, separated by a comma, a semicolon or spaces. Used for a
     * pasted pair. Anything but exactly two numbers is {@link Error#NOT_A_NUMBER} (empty text:
     * {@link Error#EMPTY}).
     */
    public static Result parsePair(String text) {
        if (isBlank(text)) {
            return fail(Error.EMPTY);
        }
        String[] parts = SEPARATORS.split(text.trim());
        if (parts.length != 2) {
            return fail(Error.NOT_A_NUMBER);
        }
        return parse(parts[0], parts[1]);
    }

    /** Plain text of a coordinate with up to 6 decimals and no trailing zeros, for showing in a field. */
    public static String format(double value) {
        String s = new java.math.BigDecimal(value).setScale(6, java.math.RoundingMode.HALF_UP)
                .stripTrailingZeros().toPlainString();
        return "-0".equals(s) ? "0" : s;
    }

    private static Double number(String text) {
        String t = normalise(text);
        if (!NUMBER.matcher(t).matches()) {
            return null;
        }
        try {
            double v = Double.parseDouble(t);
            return Double.isNaN(v) || Double.isInfinite(v) ? null : v;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /** Trims, drops the degree sign, turns Bengali digits (০-৯) into 0-9. */
    private static String normalise(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.trim().toCharArray()) {
            if (c >= '\u09E6' && c <= '\u09EF') {
                sb.append((char) ('0' + (c - '\u09E6')));
            } else if (c != '\u00B0') {
                sb.append(c);
            }
        }
        return sb.toString().trim();
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private static Result fail(Error e) {
        return new Result(0, 0, e);
    }
}
