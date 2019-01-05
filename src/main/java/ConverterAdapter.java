import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConverterAdapter implements Converter {

    public String convertNumberToWord(BigDecimal number) {
        return convert(number.longValue()) + (number.intValue() == 1 ? " dollar" : " dollars");
    }

    public String convertWordToNumber(String words) {

        boolean isValidWords = true;
        long result = 0;
        long finalResult = 0;
        String[] splittedWords;

        if (words != null && words.length() > 0) {
            splittedWords = words.trim().split("\\s+");

            for (String str : splittedWords) {
                if (!NumbersAndWordsReader.allowedWordsMap.containsValue(str)) {
                    isValidWords = false;
                    return "Wrong Words!! Please reenter";
                } else if (!checkWordsForRules(splittedWords)) {
                    isValidWords = false;
                    return "Wrong Format!! Please reenter";
                }
            }
            if (isValidWords) {
                final List<Long> wordsInNumber = new ArrayList<>();
                for (String word : splittedWords) {
                    NumbersAndWordsReader.allowedWordsMap.forEach((k, v) ->
                            {
                                if (v.equalsIgnoreCase(word)) {
                                    if (k < 100) {
                                        wordsInNumber.add(k);
                                    }
                                }
                            }
                    );
                    if (wordsInNumber.size() > 0) {
                        result += Long.valueOf(wordsInNumber.get(0).intValue());
                        wordsInNumber.remove(0);
                    }

                    if (word.equalsIgnoreCase("hundred")) {
                        result *= 100;
                    } else if (word.equalsIgnoreCase("thousand")) {
                        result *= 1000;
                        finalResult += result;
                        result = 0;
                    } else if (word.equalsIgnoreCase("million")) {
                        result *= 1000000;
                        finalResult += result;
                        result = 0;
                    } else if (word.equalsIgnoreCase("billion")) {
                        result *= 1000000000;
                        finalResult += result;
                        result = 0;
                    } else if (word.equalsIgnoreCase("trillion")) {
                        result *= 1000000000000L;
                        finalResult += result;
                        result = 0;
                    }
                }
                finalResult += result;
                result = 0;
            }
        }

        return String.valueOf(finalResult);
    }

    private boolean checkWordsForRules(String[] splittedWords) {
//        List<Long> splittedWordsInNumber = new ArrayList<>();
//        for (String str : splittedWords) {
//            for (Map.Entry<Long, String> entry : NumbersAndWordsReader.allowedWordsMap.entrySet()) {
//                if (entry.getValue().equals(str)) {
//                    splittedWordsInNumber.add(entry.getKey());
//                }
//            }
//        }
//
//        int nextDigit = 0;
//        int nextTBMTHDigit = 0;
//        int firstDigit = String.valueOf(splittedWordsInNumber.get(0)).length();
//        for (int i = 1; i < splittedWordsInNumber.size(); i++) {
//
//            if (splittedWordsInNumber.size() > 1 && splittedWordsInNumber.get(i) == 1000000000000L) {
//                splittedWordsInNumber.set(i - 1, (splittedWordsInNumber.get(i - 1) * 1000000000000L));
//                splittedWordsInNumber.remove(i);
//                firstDigit = String.valueOf(splittedWordsInNumber.get(0)).length();
//            }
//
//            if (splittedWordsInNumber.size() > 1 && splittedWordsInNumber.get(i) == 1000000000) {
//                splittedWordsInNumber.set(i - 1, (splittedWordsInNumber.get(i - 1) * 1000000000));
//                splittedWordsInNumber.remove(i);
//                firstDigit = String.valueOf(splittedWordsInNumber.get(0)).length();
//            }
//
//            if (splittedWordsInNumber.size() > 1 && splittedWordsInNumber.get(i) == 1000000) {
//                splittedWordsInNumber.set(i - 1, (splittedWordsInNumber.get(i - 1) * 1000000));
//                splittedWordsInNumber.remove(i);
//                firstDigit = String.valueOf(splittedWordsInNumber.get(0)).length();
//            }
//
//            if (splittedWordsInNumber.size() > 1 && splittedWordsInNumber.get(i) == 1000) {
//                splittedWordsInNumber.set(i - 1, (splittedWordsInNumber.get(i - 1) * 1000));
//                splittedWordsInNumber.remove(i);
//                firstDigit = String.valueOf(splittedWordsInNumber.get(0)).length();
//            }
//
//            if (splittedWordsInNumber.size() > 1 && splittedWordsInNumber.get(i) == 100) {
//                splittedWordsInNumber.set(i - 1, (splittedWordsInNumber.get(i - 1) * 100));
//                splittedWordsInNumber.remove(i);
//                firstDigit = String.valueOf(splittedWordsInNumber.get(0)).length();
//            }
//
//            if (splittedWordsInNumber.size() > 1) {
//                nextDigit = String.valueOf(splittedWordsInNumber.get(i)).length();
//                if (splittedWordsInNumber.get(i) == 1000) {
//                    nextTBMTHDigit = String.valueOf(splittedWordsInNumber.get(i)).length();
//                }
//                if (firstDigit <= nextDigit && nextTBMTHDigit < firstDigit) {
//                    return false;
//                }
//            }
//
//            firstDigit = nextDigit;
//        }

        return true;
    }

    private static String convertNumberLessThanThousand(int number) {
        String convertedNumber = "";

        if (number % 100 < 20) {
            convertedNumber = NumbersAndWordsReader.OneToNineteenNumberAndWords.get(number % 100);
            number /= 100;
        } else {
            convertedNumber = NumbersAndWordsReader.OneToNineteenNumberAndWords.get(number % 10);
            number /= 10;
            convertedNumber = NumbersAndWordsReader.TenToNinetyNumberAndWords.get(number % 10) + convertedNumber;
            number /= 10;
        }
        if (number == 0) return convertedNumber;

        return NumbersAndWordsReader.OneToNineteenNumberAndWords.get(number) + " hundred" + convertedNumber;
    }

    public static String convert(Long number) {
        String numberAsString = number.toString();
        String defaultNumberAsString = "000000000000000";
        DecimalFormat decimalFormat = new DecimalFormat(defaultNumberAsString);
        numberAsString = decimalFormat.format(number);
        int trillionCount = Integer.parseInt(numberAsString.substring(0, 3));
        int billionCount = Integer.parseInt(numberAsString.substring(3, 6));
        int millionCount = Integer.parseInt(numberAsString.substring(6, 9));
        int hundredThousandCount = Integer.parseInt(numberAsString.substring(9, 12));
        int thousandCount = Integer.parseInt(numberAsString.substring(12, 15));

        String result = trillionCount == 0 ? "" :
                convertNumberLessThanThousand(trillionCount) + " trillion ";

        result = result + (result = billionCount == 0 ? "" :
                convertNumberLessThanThousand(billionCount) + " billion ");

        result = result + (result = millionCount == 0 ? "" :
                convertNumberLessThanThousand(millionCount) + " million ");

        result = result + (result = hundredThousandCount == 0 ? "" :
                hundredThousandCount == 1 ? "one thousand" :
                        convertNumberLessThanThousand(hundredThousandCount) + " thousand ")
                + convertNumberLessThanThousand(thousandCount);

        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }


}
