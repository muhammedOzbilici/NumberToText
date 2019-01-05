import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConverterAdapter converterAdapter = new ConverterAdapter();

        System.out.println("Do you want to convert Number or Words [N/W]");
        Scanner scanner = new Scanner(System.in);
        String scannerNumberOrWordsString = scanner.next();
        String scannerNumber;


        while (scannerNumberOrWordsString.contentEquals("n") || scannerNumberOrWordsString.contentEquals("N") ||
                scannerNumberOrWordsString.contentEquals("w") || scannerNumberOrWordsString.contentEquals("W")) {

            if (scannerNumberOrWordsString.contentEquals("n") || scannerNumberOrWordsString.contentEquals("N")) {
                System.out.println("Please enter Number (For Exit press E)");

                scannerNumber = scanner.next();
                if (scannerNumber.contentEquals("e") || scannerNumber.contentEquals("E")) {
                    System.exit(0);
                }
                if (StringUtils.isNumeric(scannerNumber)) {
                    if (scannerNumber.length() < 16 && Long.parseLong(scannerNumber) != 0) {
                        System.out.println(converterAdapter.convertNumberToWord(new BigDecimal(scannerNumber)));

                    } else {
                        System.out.println("Max Length 15 digit and Min Number is 1");
                    }
                } else {
                    System.out.println("Only Numbers!!");
                }
            } else if (scannerNumberOrWordsString.contentEquals("w") || scannerNumberOrWordsString.contentEquals("W")) {

                scannerNumber = scanner.nextLine();
                System.out.println("Please enter Words (For Exit press E)");
                if (scannerNumber.contentEquals("e") || scannerNumber.contentEquals("E")) {
                    System.exit(0);
                }
                if (!StringUtils.isBlank(scannerNumber)) {
                    System.out.println(converterAdapter.convertWordToNumber(scannerNumber));
                }
            }
        }
        System.out.println("Please enter invalid answer");
    }
}
