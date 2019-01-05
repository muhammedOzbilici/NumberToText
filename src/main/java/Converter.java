import java.math.BigDecimal;

public interface Converter {

    String convertNumberToWord(BigDecimal number);

    String convertWordToNumber(String words);
}
