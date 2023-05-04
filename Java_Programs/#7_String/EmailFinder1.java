import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFinder1 {

    public static void main(String[] args) {
        String input = "Hello, my email address is john@example.com. " +
                       "You can also reach me at jane@example.com.";
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,}\\b";
        // This regex pattern matches the standard format for email addresses.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        // This loop prints all email addresses found in the input string.
    }
}

/*
The program first defines a string input containing the text to search for email addresses. It then defines a regular expression pattern regex that matches the standard format for email addresses.

The program then creates a Pattern object using the Pattern.compile() method and passes the regex pattern as an argument. It also creates a Matcher object using the pattern.matcher() method and passes the input string as an argument.

Finally, the program loops through all matches found by the Matcher object using the matcher.find() method and prints each match using the matcher.group() method.

You can modify the input string to search for email addresses in any text you want.
*/
