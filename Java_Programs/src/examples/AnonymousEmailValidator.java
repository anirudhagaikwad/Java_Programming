package examples;

import java.util.regex.*;

//Create Anonymous Class to Validate Email
public class AnonymousEmailValidator {
    public static void main(String[] args) {
        String input = "hejsflhlFH ASB@GMAIL.COM,D;D WERED FERT@CEO.ORGFALFAHFAHFA XYZ123@YAHOO.UAELEROPSJD";

        // Anonymous class implementing email validation logic
        Runnable emailValidator = new Runnable() {
            @Override
            public void run() {
                Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
                Matcher matcher = pattern.matcher(input);

                System.out.println("Valid Emails Found:");
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }
        };

        emailValidator.run();
    }
}

