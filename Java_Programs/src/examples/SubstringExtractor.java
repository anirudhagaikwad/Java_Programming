package examples;

//Extract Substring from String[][] with Exception Handling
public class SubstringExtractor {
	    public static void extractSubstring(String mainString, String subString) {
	        int index = mainString.indexOf(subString);
	        int count = 0;

	        // Checking if substring exists in main string
	        if (index == -1) {
	            System.out.println("Substring not found in the given string.");
	            return;
	        }

	        System.out.println("Occurrences of substring \"" + subString + "\":");

	        // Finding all occurrences
	        while (index != -1) {
	            int endIndex = index + subString.length() - 1;
	            System.out.println("Start: " + index + ", End: " + endIndex);
	            count++;
	            index = mainString.indexOf(subString, index + 1); // Search next occurrence
	        }

	        System.out.println("Total occurrences: " + count);
	    }

	    public static void main(String[] args) {
	        String mainString = "hello world, hello java, hello everyone!";
	        String subString = "hello";

	        extractSubstring(mainString, subString);
	    }
	}
