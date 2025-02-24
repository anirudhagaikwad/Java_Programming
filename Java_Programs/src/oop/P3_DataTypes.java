package oop;
/*
Data Types in Java

Java is a statically typed language, meaning every variable must have a declared type. 
Java provides two main categories of data types:

1. Primitive Data Types
2. Non-Primitive Data Types

---
## 1. Primitive Data Types

Primitive data types are the basic types of data built into the Java language. 
They are predefined by Java and stored directly in memory for efficient access.

| Data Type | Size (Bytes) | Default Value | Description                              |
|-----------|--------------|---------------|------------------------------------------|
| byte      | 1            | 0             | 8-bit integer (-128 to 127)              |
| short     | 2            | 0             | 16-bit integer (-32,768 to 32,767)       |
| int       | 4            | 0             | 32-bit integer (-2^31 to 2^31-1)         |
| long      | 8            | 0L            | 64-bit integer (-2^63 to 2^63-1) 		  |
| float     | 4            | 0.0f          | 32-bit floating point (single precision) |
| double    | 8            | 0.0d          | 64-bit floating point (double precision) |
| char      | 2            | '\u0000'      | 16-bit Unicode character                 |
| boolean   | 1 (depends on JVM) | false   | Represents `true` or `false`             |


---
## 2. Non-Primitive Data Types

Non-primitive data types are more complex and store references rather than actual values. These include:

### A. Strings
A sequence of characters enclosed in double quotes (`" "`).

String name = "Java Programming";


### B. Arrays
A collection of elements of the same data type.

int[] numbers = {10, 20, 30, 40};


### C. Classes
Classes define user-defined data types.

class Person {
    String name;
    int age;
}


### D. Interfaces
Interfaces define abstract behavior for classes to implement.

interface Animal {
    void makeSound();
}


### E. Enums
A special data type to define a fixed set of constants.

enum Days { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }


---
## Key Differences Between Primitive and Non-Primitive Data Types

| Feature    | Primitive Data Type  | Non-Primitive Data Type                 |
|------------|----------------------|-----------------------------------------|
| Stored In  | Stack Memory         | Heap Memory (reference stored in Stack) |
| Value Type | Stores actual values | Stores memory references                |
| Predefined | Yes, defined by Java | No, created by users (except `String`)  |
| Operations | Supports arithmetic and logical operations | Requires method-based manipulations |

---
## Conclusion
Java provides a rich set of data types to handle different types of data efficiently. 
Understanding these types is crucial for writing efficient and error-free Java programs.


*/
public class P3_DataTypes {

	public static void main(String[] args) {
		//Examples of Primitive Data Types:
			byte b = 127;
			short s = 32000;
			int i = 100000;
			long l = 10000000000L;
			float f = 3.14f;
			double d = 3.141592653589793;
			char c = 'A';
			boolean bool = true;
			
			System.out.println("Byte Datatype Min Value : "+Byte.MIN_VALUE+" Max Value : "+Byte.MAX_VALUE+" Size in bit : "+Byte.SIZE+" Size in byte : "+Byte.BYTES);
			System.out.println("Short Datatype Min Value : "+Short.MIN_VALUE+" Max Value : "+Short.MAX_VALUE+" Size in bit : "+Short.SIZE+" Size in byte : "+Short.BYTES);
			System.out.println("Integer Datatype Min Value : "+Integer.MIN_VALUE+" Max Value : "+Integer.MAX_VALUE+" Size in bit : "+Integer.SIZE+" Size in byte : "+Integer.BYTES);
			System.out.println("Long Datatype Min Value : "+Long.MIN_VALUE+" Max Value : "+Long.MAX_VALUE+" Size in bit : "+Long.SIZE+" Size in byte : "+Long.BYTES);
			System.out.println("Float Datatype Min Value : "+Float.MIN_VALUE+" Max Value : "+Float.MAX_VALUE+" Size in bit : "+Float.SIZE+" Size in byte : "+Float.BYTES);
			System.out.println("Double Datatype Min Value : "+Double.MIN_VALUE+" Max Value : "+Double.MAX_VALUE+" Size in bit : "+Double.SIZE+" Size in byte : "+Double.BYTES);
			System.out.println("Character Datatype Min Value : "+" Max Value : "+" Size in bit : "+Character.SIZE+" Size in byte : "+Character.BYTES);
			
			System.out.println("Boolean TRUE value: " + Boolean.TRUE);
			System.out.println("Boolean FALSE value: " + Boolean.FALSE);
			System.out.println("Boolean Type: " + Boolean.TYPE);
			System.out.println("Parse 'true' as Boolean: " + Boolean.parseBoolean("true"));
			System.out.println("Parse 'false' as Boolean: " + Boolean.parseBoolean("false"));
			System.out.println("Convert 'TRUE' String to Boolean Object: " + Boolean.valueOf("TRUE"));
			System.out.println("Convert 'False' String to Boolean Object: " + Boolean.valueOf("False"));


	}

}
