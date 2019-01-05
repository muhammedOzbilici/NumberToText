import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ConverterAdapterTest {

    private ConverterAdapter converterAdapter;

    @Before
    public void doBefore() {
        converterAdapter = new ConverterAdapter();
    }

    @Test
    public void shouldConvertToWords_1_2_3() throws Exception {
        assertEquals("one dollar", converterAdapter.convertNumberToWord(new BigDecimal(1)));
        assertEquals("two dollars", converterAdapter.convertNumberToWord(new BigDecimal(2)));
        assertEquals("three dollars", converterAdapter.convertNumberToWord(new BigDecimal(3)));
    }

    @Test
    public void shouldConvertToWords_60_75_89() throws Exception {
        assertEquals("sixty dollars", converterAdapter.convertNumberToWord(new BigDecimal(60)));
        assertEquals("seventy five dollars", converterAdapter.convertNumberToWord(new BigDecimal(75)));
        assertEquals("eighty nine dollars", converterAdapter.convertNumberToWord(new BigDecimal(89)));
    }

    @Test
    public void shouldConvertToWords_100_211_347() throws Exception {
        assertEquals("one hundred dollars", converterAdapter.convertNumberToWord(new BigDecimal(100)));
        assertEquals("two hundred eleven dollars", converterAdapter.convertNumberToWord(new BigDecimal(211)));
        assertEquals("three hundred forty seven dollars", converterAdapter.convertNumberToWord(new BigDecimal(347)));
    }

    @Test
    public void shouldConvertToWords_1000_2045_7846() throws Exception {
        assertEquals("one thousand dollars", converterAdapter.convertNumberToWord(new BigDecimal(1000)));
        assertEquals("two thousand forty five dollars", converterAdapter.convertNumberToWord(new BigDecimal(2045)));
        assertEquals("seven thousand eight hundred forty six dollars", converterAdapter.convertNumberToWord(new BigDecimal(7846)));
    }

    @Test
    public void shouldConvertToWords_99999_888888_555555555555555() throws Exception {
        assertEquals("ninety nine thousand nine hundred ninety nine dollars",
                converterAdapter.convertNumberToWord(new BigDecimal(99999)));
        assertEquals("eight hundred eighty eight thousand eight hundred eighty eight dollars",
                converterAdapter.convertNumberToWord(new BigDecimal(888888)));
        BigDecimal bigDecimal = new BigDecimal(555555555555555L);
        assertEquals("five hundred fifty five trillion five hundred fifty five billion " +
                        "five hundred fifty five million five hundred fifty five thousand five hundred fifty five dollars",
                converterAdapter.convertNumberToWord(bigDecimal));
    }

    @Test
    public void shouldConvertToNumber_60_75_89() throws Exception {
        assertEquals("60", converterAdapter.convertWordToNumber("sixty"));
        assertEquals("75", converterAdapter.convertWordToNumber("seventy five"));
        assertEquals("89", converterAdapter.convertWordToNumber("eighty nine"));
    }

    @Test
    public void shouldConvertToNumber_1_2_3() throws Exception {
        assertEquals("1", converterAdapter.convertWordToNumber("one"));
        assertEquals("2", converterAdapter.convertWordToNumber("two"));
        assertEquals("3", converterAdapter.convertWordToNumber("three"));
    }

    @Test
    public void shouldConvertToNumber_100_211_347() throws Exception {
        assertEquals("100", converterAdapter.convertWordToNumber("one hundred"));
        assertEquals("211", converterAdapter.convertWordToNumber("two hundred eleven"));
        assertEquals("347", converterAdapter.convertWordToNumber("three hundred forty seven"));
    }

    @Test
    public void shouldConvertToNumber_1000_2045_7846() throws Exception {
        assertEquals("1000", converterAdapter.convertWordToNumber("one thousand"));
        assertEquals("2045", converterAdapter.convertWordToNumber("two thousand forty five"));
        assertEquals("7846", converterAdapter.convertWordToNumber("seven thousand eight hundred forty six"));
    }

    @Test
    public void shouldConvertToNumber_99999_888888_555555555555555() throws Exception {
        assertEquals("99999",
                converterAdapter.convertWordToNumber("ninety nine thousand nine hundred ninety nine"));
        assertEquals("888888",
                converterAdapter.convertWordToNumber("eight hundred eighty eight thousand eight hundred eighty eight"));
        assertEquals("555555555555555",
                converterAdapter.convertWordToNumber("five hundred fifty five trillion five hundred fifty five billion " +
                        "five hundred fifty five million five hundred fifty five thousand five hundred fifty five"));
    }

}