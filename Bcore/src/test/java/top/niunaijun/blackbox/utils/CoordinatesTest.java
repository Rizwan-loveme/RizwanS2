package top.niunaijun.blackbox.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinatesTest {

    private static final double EPS = 1e-9;

    @Test
    public void parse_plainNumbers() {
        Coordinates.Result r = Coordinates.parse("23.8103", " 90.4125 ");
        assertTrue(r.ok());
        assertEquals(23.8103, r.latitude, EPS);
        assertEquals(90.4125, r.longitude, EPS);
    }

    @Test
    public void parse_negativeAndSigned() {
        Coordinates.Result r = Coordinates.parse("-33.8688", "+151.2093");
        assertTrue(r.ok());
        assertEquals(-33.8688, r.latitude, EPS);
        assertEquals(151.2093, r.longitude, EPS);
    }

    @Test
    public void parse_bengaliDigitsAndDegreeSign() {
        Coordinates.Result r = Coordinates.parse("২৩.৮১০৩°", "৯০.৪১২৫");
        assertTrue(r.ok());
        assertEquals(23.8103, r.latitude, EPS);
        assertEquals(90.4125, r.longitude, EPS);
    }

    @Test
    public void parse_rangeErrors() {
        assertEquals(Coordinates.Error.LAT_RANGE, Coordinates.parse("90.0001", "10").error);
        assertEquals(Coordinates.Error.LAT_RANGE, Coordinates.parse("-91", "10").error);
        assertEquals(Coordinates.Error.LON_RANGE, Coordinates.parse("10", "180.5").error);
        assertEquals(Coordinates.Error.LON_RANGE, Coordinates.parse("10", "-181").error);
        assertTrue(Coordinates.parse("90", "180").ok());
        assertTrue(Coordinates.parse("-90", "-180").ok());
    }

    @Test
    public void parse_emptyAndNotNumbers() {
        assertEquals(Coordinates.Error.EMPTY, Coordinates.parse("", "10").error);
        assertEquals(Coordinates.Error.EMPTY, Coordinates.parse("10", null).error);
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parse("abc", "10").error);
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parse("NaN", "10").error);
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parse("Infinity", "10").error);
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parse("1e2", "10").error);
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parse("0x10", "10").error);
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parse("1.5f", "10").error);
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parse("23,81", "90").error);
    }

    @Test
    public void parse_zeroZeroIsRefused() {
        assertEquals(Coordinates.Error.NULL_ISLAND, Coordinates.parse("0", "0").error);
        assertEquals(Coordinates.Error.NULL_ISLAND, Coordinates.parse("0.0", "-0").error);
        assertTrue(Coordinates.parse("0", "10").ok());
        assertTrue(Coordinates.parse("10", "0").ok());
    }

    @Test
    public void parsePair_commaSpaceSemicolon() {
        for (String text : new String[]{"23.8103, 90.4125", "23.8103,90.4125", "23.8103 90.4125",
                "  23.8103 ;  90.4125 ", "23.8103,\n90.4125"}) {
            Coordinates.Result r = Coordinates.parsePair(text);
            assertTrue(text, r.ok());
            assertEquals(23.8103, r.latitude, EPS);
            assertEquals(90.4125, r.longitude, EPS);
        }
    }

    @Test
    public void parsePair_wrongCountOrEmpty() {
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parsePair("23.8").error);
        assertEquals(Coordinates.Error.NOT_A_NUMBER, Coordinates.parsePair("1 2 3").error);
        assertEquals(Coordinates.Error.EMPTY, Coordinates.parsePair("   ").error);
        assertEquals(Coordinates.Error.EMPTY, Coordinates.parsePair(null).error);
    }

    @Test
    public void format_noTrailingZerosAndNoMinusZero() {
        assertEquals("23.8103", Coordinates.format(23.8103));
        assertEquals("90", Coordinates.format(90.0));
        assertEquals("-0.1278", Coordinates.format(-0.1278));
        assertEquals("0", Coordinates.format(-0.0000001));
        assertFalse(Coordinates.format(1.23456789).contains("789"));
    }
}
