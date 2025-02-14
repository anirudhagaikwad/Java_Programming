package fundamentals;
/*
 * String is an object that represents a sequence of characters. In Java, a string is represented by the String class,
 * which is located in the java.lang package.
 *
 * String objects are immutable, meaning once a string object is created, it cannot be changed.
 * Immutable Object: An object whose state cannot be changed after it is created.
 * String objects are stored in a special memory area called the string constant pool inside the heap memory.
 *
 * String Pool:
 * 1. When a string is created using a string literal, it is stored in the string pool.
 * 2. If the same string is encountered again, Java returns a reference to the existing string instead of creating a new one.
 * 3. Strings created using the 'new' keyword are stored in the heap memory and do not utilize the string pool unless explicitly interned.
 */

public class P10_String {
    
    void stringMethods() {
        // Creating Strings using different constructors
        String strB = "Hello";
        char[] charArray = {'J', 'a', 'v', 'a'};
        String strC = new String(charArray);
        String strD = new String(charArray, 1, 2);
        byte[] byteArray = {65, 66, 67};
        String strE = new String(byteArray);
        String strF = new String(byteArray, 1, 2);
        String strG = new String(new StringBuffer("StringBuffer"));
        String strH = new String(new StringBuilder("StringBuilder"));
        
        // Demonstrating String methods
        String str1 = "Hello";
        System.out.println("Original String: " + str1);
        String str2 = new String("hello");
        String str3 = "hello";
        
        // Concatenation
        String str4 = str1.concat(str2);
        System.out.println("Concatenation using concat(): " + str4);
        System.out.println("Concatenation using + operator: " + str1 + "Java");
        
        // equals() - Compares content
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        
        // == - Compares object references
        System.out.println("str1 == str2: " + (str1 == str2));
        
        // compareTo() - Lexicographic comparison 
        //compares values and return integer value which tells if the string compared is less-than,greater-then or equal to , it compares string based on natural ordering
        // Its compare string given with the current string in lexicographical manner, Comapres are done on basis of unicode value of characters avilable in String	
        System.out.println("str1.compareTo(str5): " + str1.compareTo("Java"));
        System.out.println("str2.compareTo(str3): " + str2.compareTo(str3));
        
        // charAt() - Returns character at index
        System.out.println("str1.charAt(1): " + str1.charAt(1));
        
        // equalsIgnoreCase()
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2));
        
        // indexOf()
        System.out.println("str1.indexOf('l'): " + str1.indexOf('l'));
        
        // length()
        System.out.println("str1.length(): " + str1.length());
        
        // replace()
        System.out.println("Replaced String: " + str1.replace('o', 'O'));
        
        // substring()
        System.out.println("Substring from index 1: " + str1.substring(1));
        System.out.println("Substring from index 1 to 3: " + str1.substring(1, 3));
        
        // Capitalizing first letter
        System.out.println("Capitalized first letter: " + str2.substring(0, 1).toUpperCase() + str2.substring(1));
        
        // toUpperCase(), toLowerCase()
        System.out.println("Uppercase: " + str2.toUpperCase());
        System.out.println("Lowercase: " + "JAVA".toLowerCase());
        
        // valueOf() - Converts different types to String
        System.out.println("String.valueOf(123): " + String.valueOf(123));
        
        // contains()
        System.out.println("str2.contains(\"ell\"): " + str2.contains("ell"));
        
        // endsWith(), startsWith()
        System.out.println("str1.endsWith(\"o\"): " + str1.endsWith("o"));
        System.out.println("str1.startsWith(\"H\"): " + str1.startsWith("H"));
        
        // isEmpty(), isBlank()
        String str10 = "";
        System.out.println("str10.isEmpty(): " + str10.isEmpty());
        String str11 = "   ";
        System.out.println("str11.isBlank(): " + str11.isBlank());
        
        // join()
        System.out.println("Joined String: " + String.join("/", "18", "April", "2022"));
    }

    public static void main(String[] args) {
        P10_String obj = new P10_String();
        obj.stringMethods();
        
      //toString() If you want to represent any object as a string, toString() method comes into existence
      System.out.println("ToString : "+obj.toString());//JavaString@277c0f21
      System.out.println("hashCode : "+obj.hashCode());// hashCode() method returns an integer representation of the hash code value of the JavaString object.
    }
}
