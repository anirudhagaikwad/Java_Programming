package oop;
/*
String is an object that represents a sequence of characters. In Java, a string is represented by the 
String class,which is located in the java.lang package.
 
String objects are immutable, meaning once a string object is created, it cannot be changed.
Immutable Object: An object whose state cannot be changed after it is created.
String objects are stored in a special memory area called the string constant pool inside the heap memory.
 
### String Pool:
1. When a string is created using a string literal, it is stored in the string pool.
2. If the same string is encountered again, Java returns a reference to the existing string instead of creating a new one.
3. Strings created using the 'new' keyword are stored in the heap memory and do not utilize the string pool unless explicitly interned.
  

## Mutable Strings  
In Java, `String` objects are immutable, meaning they cannot be modified once created. However, 
Java provides `StringBuffer` and `StringBuilder`, which allow mutable (modifiable) string operations.

---

## Difference Between `String`, `StringBuffer`, and `StringBuilder`  

| Feature       | `String`                    | `StringBuffer`                                | `StringBuilder` |
|---------------|-----------------------------|-----------------------------------------------|-------------------|
| Mutability    | Immutable                   | Mutable                                       | Mutable            |
| Thread-Safety | Yes (safe)                  | Yes (synchronized)                            | No (not synchronized)    |
| Performance   | Slow                        | Slower (because of synchronization)           | Faster (no synchronization overhead) |
| Usage         | When immutability is needed | When thread-safe mutable strings are required | When fast and non-thread-safe operations are needed |

---
## `StringBuffer` in Java  
The `StringBuffer` class provides a mutable sequence of characters and is thread-safe, 
meaning multiple threads cannot modify it simultaneously.  

---
## `StringBuilder` in Java  
The `StringBuilder` class is similar to `StringBuffer` but is not thread-safe, 
making it faster for single-threaded applications.


---

## When to Use What?  
- Use `String` if immutability is required.  
- Use `StringBuffer` if multiple threads modify the string.  
- Use `StringBuilder` if you need better performance in a single-threaded environment.  

---
### What is hashCode() Method?
- hashCode() is a method from Object class that returns an integer representation (hash value) of an object.
  Used in hash-based collections (HashMap, HashSet).
- Enables efficient searching and storage.Used with equals() to compare objects.
- If two objects are equal (equals() returns true), then their hashCode() must be the same.
- If hashCode() values are different, objects must be different.
*/

public class P11_String_StringBuffer_StringBuilder {

	    static void stringBuiltInMethods() {
	        //Creating Strings using different methods
	        String strB = "Hello"; // String literal (stored in string pool)
	        
	        char[] charArray = {'J', 'a', 'v', 'a'}; 
	        String strC = new String(charArray); // Creating string from character array
	        String strD = new String(charArray, 1, 2); // Creating substring from character array
	        
	        byte[] byteArray = {65, 66, 67}; // ASCII values (65 = A, 66 = B, 67 = C)
	        String strE = new String(byteArray); // Creating string from byte array (Output: "ABC")
	        String strF = new String(byteArray, 1, 2); // Creating substring from byte array (Output: "BC")
	        
	        String strG = new String(new StringBuffer("StringBuffer")); // Creating from StringBuffer
	        String strH = new String(new StringBuilder("StringBuilder")); // Creating from StringBuilder
	        
	        //Demonstrating String methods
	        String str1 = "Hello"; // Original string
	        System.out.println("Original String: " + str1);
	        
	        String str2 = new String("hello"); // New object in heap memory
	        String str3 = "hello"; // String literal
	        
	        //Concatenation (Joining strings)
	        String str4 = str1.concat(str2); // Using concat() method
	        System.out.println("Concatenation using concat(): " + str4);
	        System.out.println("Concatenation using + operator: " + str1 + "Java");

	        //equals() - Compares content of two strings
	        System.out.println("str1.equals(str2): " + str1.equals(str2)); // false (case-sensitive)

	        //== - Compares memory references, not content
	        System.out.println("str1 == str2: " + (str1 == str2)); // false (different memory locations)

	        //compareTo() - Lexicographically compares two strings (returns 0 if equal, negative if less, positive if greater)
	        System.out.println("str1.compareTo(\"Java\"): " + str1.compareTo("Java")); // Output depends on lexicographical order
	        System.out.println("str2.compareTo(str3): " + str2.compareTo(str3)); // 0 (both strings are same)

	        //charAt() - Returns character at the specified index
	        System.out.println("str1.charAt(1): " + str1.charAt(1)); // Output: 'e'

	        //equalsIgnoreCase() - Compares two strings ignoring case
	        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2)); // true

	        //indexOf() - Returns the index of the first occurrence of the given character
	        System.out.println("str1.indexOf('l'): " + str1.indexOf('l')); // Output: 2

	        //length() - Returns the length of the string
	        System.out.println("str1.length(): " + str1.length()); // Output: 5

	        //replace() - Replaces a character with another character in the string
	        System.out.println("Replaced String: " + str1.replace('o', 'O')); // Output: HellO

	        //substring() - Extracts a substring from the string
	        System.out.println("Substring from index 1: " + str1.substring(1)); // Output: ello
	        System.out.println("Substring from index 1 to 3: " + str1.substring(1, 3)); // Output: el

	        //Capitalizing first letter using substring()
	        System.out.println("Capitalized first letter: " + str2.substring(0, 1).toUpperCase() + str2.substring(1)); // Output: Hello

	        //toUpperCase(), toLowerCase() - Converts string to uppercase/lowercase
	        System.out.println("Uppercase: " + str2.toUpperCase()); // Output: HELLO
	        System.out.println("Lowercase: " + "JAVA".toLowerCase()); // Output: java

	        //valueOf() - Converts various data types to String
	        System.out.println("String.valueOf(123): " + String.valueOf(123)); // Output: "123"

	        //contains() - Checks if a string contains a specific sequence of characters
	        System.out.println("str2.contains(\"ell\"): " + str2.contains("ell")); // Output: true

	        //endsWith(), startsWith() - Checks if string starts or ends with a specific substring
	        System.out.println("str1.endsWith(\"o\"): " + str1.endsWith("o")); // true
	        System.out.println("str1.startsWith(\"H\"): " + str1.startsWith("H")); // true

	        //isEmpty(), isBlank() - Checks if string is empty or only contains whitespace
	        String str10 = "";
	        System.out.println("str10.isEmpty(): " + str10.isEmpty()); // true
	        String str11 = "   ";
	        System.out.println("str11.isBlank(): " + str11.isBlank()); // true

	        //join() - Joins multiple strings with a specified delimiter
	        System.out.println("Joined String: " + String.join("/", "18", "April", "2022")); // Output: 18/April/2022
	    }

	    public static void main(String[] args) {
	    	stringBuiltInMethods();
	        
	    	P11_String_StringBuffer_StringBuilder obj=new P11_String_StringBuffer_StringBuilder();
	        //toString() - Returns a string representation of an object
	        System.out.println("ToString: " + obj.toString()); // Output: oop.P11_String_StringBuffer_StringBuilder@44e81672

	        //hashCode() - Returns a hash code for the string
	        System.out.println("hashCode: " + obj.hashCode()); // Output: Unique hash code for the object
	        
	        stringBufferBuiltInMethod();
	        stringBuilderBuiltInMethod();
	    }
	    
	 // Demonstrating common StringBuffer methods
	   static void stringBufferBuiltInMethod() {
	        System.out.println("\n🔹 Demonstrating StringBuffer Methods");
	        
	        // Creating a StringBuffer object
	        StringBuffer sbf = new StringBuffer("Welcome");
	        System.out.println("Original StringBuffer: " + sbf);
	        
	        // append() - Appends a string at the end
	        sbf.append(" to Java");
	        System.out.println("After append(): " + sbf);
	        
	        // insert() - Inserts a string at the specified index
	        sbf.insert(7, " Everyone");
	        System.out.println("After insert(): " + sbf);
	        
	        // replace() - Replaces characters between specified indexes
	        sbf.replace(8, 16, "All");
	        System.out.println("After replace(): " + sbf);
	        
	        // delete() - Deletes characters between specified indexes
	        sbf.delete(8, 11);
	        System.out.println("After delete(): " + sbf);
	        
	        // reverse() - Reverses the content
	        sbf.reverse();
	        System.out.println("After reverse(): " + sbf);
	        
	        // capacity() - Returns the current capacity of StringBuffer
	        System.out.println("Capacity: " + sbf.capacity());
	        
	        // setLength() - Changes the length of the string
	        sbf.setLength(7);
	        System.out.println("After setLength(7): " + sbf);
	    }
	    
	 // Demonstrating common StringBuilder methods
	    static void stringBuilderBuiltInMethod() {
	        System.out.println("\n🔹 Demonstrating StringBuilder Methods");
	        
	        // Creating a StringBuilder object
	        StringBuilder sb = new StringBuilder("Hello");
	        System.out.println("Original StringBuilder: " + sb);
	        
	        // append() - Adds a string at the end
	        sb.append(" World");
	        System.out.println("After append(): " + sb);
	        
	        // insert() - Inserts a string at the specified position
	        sb.insert(5, " Java");
	        System.out.println("After insert(): " + sb);
	        
	        // replace() - Replaces part of the string with another string
	        sb.replace(6, 10, "C++");
	        System.out.println("After replace(): " + sb);
	        
	        // delete() - Removes part of the string
	        sb.delete(6, 9);
	        System.out.println("After delete(): " + sb);
	        
	        // reverse() - Reverses the string
	        sb.reverse();
	        System.out.println("After reverse(): " + sb);
	        
	        // capacity() - Returns the current capacity
	        System.out.println("Capacity: " + sb.capacity());
	        
	        // setLength() - Sets the length of the sequence
	        sb.setLength(5);
	        System.out.println("After setLength(5): " + sb);
	        
// Ensure Capacity: Ensures that the buffer can hold at least 50 characters ,default is 16      
//newCapacity = (value.length >> 1) + value.length is Equivalent to newCapacity = oldCapacity + (oldCapacity / 2);
// It allows you to pre-allocate memory to avoid performance issues when appending large amounts of data.
	    
	        int oldCapacity = sb.capacity();
	        sb.ensureCapacity(50);
	        int newCapacity = sb.capacity(); // Will follow (oldCapacity + oldCapacity / 2)
	        System.out.println("Old Capacity: " + oldCapacity);
	        System.out.println("New Capacity after ensureCapacity(50): " + newCapacity);
	    }	    
	}

/*
Let's analyze how `ensureCapacity(int minimumCapacity)` actually works in Java 21.

---

## How `ensureCapacity(int minimumCapacity)` Works
- If the requested `minimumCapacity` is larger than the current capacity, Java increases it based on an 
  internal formula.
- Java 21's `StringBuilder.ensureCapacity(int)` implementation follows this formula:
  
  int newCapacity = (oldCapacity * 2) + 2;
  
- However, if the requested capacity (`minimumCapacity`) is greater than the calculated `newCapacity`, 
  it directly sets `minimumCapacity` as the new capacity.

---

### Breaking Down the Calculation
Let's assume:
- Old Capacity = `21`
- Requested Capacity = `50`
  
1. Calculate `newCapacity` using Java 21 formula:
   
   newCapacity = (oldCapacity * 2) + 2
               = (21 * 2) + 2
               = 42 + 2
               = 44
   
2. Check if `newCapacity` is sufficient:
   - Since `44 < 50` (not enough), Java sets capacity directly to `50`.

---

### Final Output

Old Capacity: 21
New Capacity after ensureCapacity(50): 50


---

## Why Does Java Use `(oldCapacity * 2) + 2` Instead of `oldCapacity + (oldCapacity / 2)`?
- The 1.5x growth formula (`oldCapacity + (oldCapacity / 2)`) grows more slowly.
- Java optimizes for performance by growing the capacity faster (2x growth), reducing the need for frequent array resizing.
- `+2` is a minor buffer to handle small values.

---

## Key Takeaways
✔ Java 21's `ensureCapacity(minimumCapacity)` formula:
   
   newCapacity = (oldCapacity * 2) + 2;
   if (newCapacity < minimumCapacity)
       newCapacity = minimumCapacity;
   
✔ The 1.5x formula (`oldCapacity + (oldCapacity / 2)`) is NOT used in Java 21.
✔ If the requested capacity is greater than the calculated `newCapacity`, Java directly sets the requested capacity.
✔ Faster growth (2x instead of 1.5x) reduces frequent resizing overhead.


*/