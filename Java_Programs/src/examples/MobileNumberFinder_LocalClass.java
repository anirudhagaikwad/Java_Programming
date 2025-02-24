package examples;

//Find Mobile Numbers from String[][] using Local Class
import java.util.regex.*;
public class MobileNumberFinder_LocalClass {

    public static void findMobileNumbers(String[][] data) {
        // Local Class for Extraction
        class MobileExtractor {
            private final Pattern pattern = Pattern.compile("\\+91[- ]?\\d{10}|\\d{10}");

            void extract() {
                System.out.println("Valid Mobile Numbers Found:");
                for (String[] row : data) {
                    for (String cell : row) {
                        Matcher matcher = pattern.matcher(cell);
                        while (matcher.find()) {
                            System.out.println(matcher.group());
                        }
                    }
                }
            }
        }

        // Creating an instance of the local class and extracting numbers
        MobileExtractor extractor = new MobileExtractor();
        extractor.extract();
    }

    public static void main(String[] args) {
        String[][] data = {
            {"Hello +91 6800009055", "Contact 9860405570"},
            {"+91-7895421689 is my number", "Call me at 9876003210"}
        };

        findMobileNumbers(data);
    }
}

