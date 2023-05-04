import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFinder {

    public static List<String> findEmails(String input) {
        List<String> emails = new ArrayList<>();

        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    public static void main(String[] args) {
        String input = "Hello, my email address is john@example.com. " +
                       "You can also reach me at jane@example.com.";

        List<String> emails = findEmails(input);
        for (String email : emails) {
            System.out.println(email);
        }
    }
}



/*
The program first defines a string input containing the text to search for email addresses. It then defines a regular expression pattern regex that matches the standard format for email addresses.

The method first creates an empty List of strings called emails. It then defines the same regular expression pattern as before, creates a Pattern object, and creates a Matcher object using the input string.

The method then loops through all matches found by the Matcher object and adds each match to the emails list using the emails.add() method.

Finally, the method returns the emails list containing all email addresses found in the input string.

*/
