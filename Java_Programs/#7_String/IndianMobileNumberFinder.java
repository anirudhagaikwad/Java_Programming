

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndianMobileNumberFinder {

    public static void main(String[] args) {
        String input = "My mobile number is +91-9000000000. " +
                       "You can also call me at 91 9000000000 or 09000000000";

        findIndianMobileNumbers(input);
    }

    public static void findIndianMobileNumbers(String input) {
        String regex = "(\\+\\d{1,3}[- ]?)?(\\d{10})";
        // This regex pattern matches Indian mobile phone numbers in various formats.

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
        // This loop prints all Indian mobile phone numbers found in the input string.
    }
}


/*
he program first defines a string input containing the text to search for Indian mobile phone numbers. It then defines a regular expression pattern regex that matches Indian mobile phone numbers in various formats, such as +91-0007910000, 91 0007910000, or 00007910000.

The program then creates a Pattern object using the Pattern.compile() method and passes the regex pattern as an argument. It also creates a Matcher object using the pattern.matcher() method and passes the input string as an argument.

Finally, the program loops through all matches found by the Matcher object using the matcher.find() method and prints only the second group, which contains the actual mobile phone number, using the matcher.group(2) method.

You can modify the input string to search for Indian mobile phone numbers in any text you want.

Pattern.compile() is a method in the java.util.regex package that creates a Pattern object from a regular expression. The Pattern object represents a compiled version of the regular expression and can be used to match text against the regular expression.

pattern.matcher() is a method of the Pattern class that creates a Matcher object for a given input string. The Matcher object can then be used to find matches of the regular expression within the input string.

matcher.find() is a method of the Matcher class that searches for the next occurrence of the regular expression in the input string. It returns a boolean value indicating whether a match was found or not.

matcher.group() is a method of the Matcher class that returns the matched substring for a given group number. A group is defined within the regular expression using parentheses. For example, if the regular expression has two groups, calling matcher.group(1) would return the matched substring for the first group and calling matcher.group(2) would return the matched substring for the second group.

In the context of the Indian mobile number finder program I provided earlier, Pattern.compile() is used to compile the regular expression for matching Indian mobile numbers, pattern.matcher() is used to create a Matcher object for the input string, matcher.find() is used to find all occurrences of Indian mobile numbers within the input string, and matcher.group(2) is used to print only the actual mobile numbers themselves (which are captured in the second group of the regular expression).
*/
