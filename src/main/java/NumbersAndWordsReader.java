import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumbersAndWordsReader {

    static List<String> OneToNineteenNumberAndWords = Arrays.asList
            (
                    "", " one", " two", " three", " four", " five", " six",
                    " seven", " eight", " nine", " ten", " eleven", " twelve",
                    " thirteen", " fourteen", " fifteen"," sixteen",
                    " seventeen", " eighteen", " nineteen"
            );

    static List<String> TenToNinetyNumberAndWords = Arrays.asList
            (
                    ""," ten"," twenty"," thirty"," forty"," fifty",
                    " sixty"," seventy"," eighty"," ninety"
            );

    static Map<Long, String> allowedWordsMap = new HashMap<Long, String>()
    {
        {
            put(Long.valueOf(1), "one");
            put(Long.valueOf(2 ),"two");
            put(Long.valueOf(3 ),"three");
            put(Long.valueOf(4) ,"four");
            put(Long.valueOf(5 ),"five");
            put(Long.valueOf(6) ,"six");
            put(Long.valueOf(7) ,"seven");
            put(Long.valueOf(8) ,"eight");
            put(Long.valueOf(9 ),"nine");
            put(Long.valueOf(10) ,"ten");
            put(Long.valueOf(11) ,"eleven");
            put(Long.valueOf(12) ,"twelve");
            put(Long.valueOf(13) ,"thirteen");
            put(Long.valueOf(14),"fourteen");
            put(Long.valueOf(15) ,"fifteen");
            put(Long.valueOf(16) ,"sixteen");
            put(Long.valueOf(17) ,"seventeen");
            put(Long.valueOf(18) ,"eighteen");
            put(Long.valueOf(19) ,"nineteen");
            put(Long.valueOf(20),"twenty");
            put(Long.valueOf(30),"thirty");
            put(Long.valueOf(40),"forty");
            put(Long.valueOf(50) ,"fifty");
            put(Long.valueOf(60) ,"sixty");
            put(Long.valueOf(70),"seventy");
            put(Long.valueOf(80),"eighty");
            put(Long.valueOf(90),"ninety");
            put(Long.valueOf(100),"hundred");
            put(Long.valueOf(1000),"thousand");
            put(Long.valueOf(1000000),"million");
            put(Long.valueOf(1000000000),"billion");
            put(Long.valueOf(1000000000000L),"trillion");
        }
    };

}
