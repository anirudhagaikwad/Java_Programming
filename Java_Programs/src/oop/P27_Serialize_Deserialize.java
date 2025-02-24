package oop;
/*

## Serialization & Deserialization in Java
### What is Serialization?
Serialization is the process of converting an object into a byte stream, which can then be stored 
(e.g., in a file or database) or transferred over a network.  

### What is Deserialization?
Deserialization is the reverse process of serialization, where the byte stream is converted back into an object.

### Purpose of Serialization
- Saving object state to a file or database.
- Sending objects over a network (RMI, Web Services, etc.).
- Caching objects for later use.

### Illustration of Serialization & Deserialization Process
1. Serialization Process  
   - Convert an object into a byte stream.
   - Store the byte stream in a file or transmit over a network.
   - Requires `java.io.Serializable` interface.

2. Deserialization Process  
   - Read the byte stream from storage or network.
   - Convert it back to an object.
   - Requires the original class definition to reconstruct the object.

---

- Shallow Copy (clone() method) only copies references. If the original object’s address changes, the copied object’s address also changes.
- Deep Copy (deepCopy() method) creates a completely new Address object, ensuring independence from the original.
✅ Use deep copy when dealing with mutable objects to prevent unintended side effects! 🚀
*/

import java.io.*;

//Step 1: Create a Serializable class
class Person implements Serializable {
 private static final long serialVersionUID = 1L; // Recommended for version control
 private String name;
 private int age;

 // Constructor
 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Display the object details
 public void display() {
     System.out.println("Name: " + name + ", Age: " + age);
 }
}

//Step 2: Class to handle Serialization & Deserialization
public class P27_Serialize_Deserialize {

 // Method to serialize an object and save it to a file
 public static void serializeObject(Person person, String filename) {
     try (FileOutputStream fileOut = new FileOutputStream(filename);
          ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
         // Write the object to the file
         objOut.writeObject(person);
         System.out.println("Serialization successful: Object saved to " + filename);
     } catch (IOException e) {
         System.err.println("Error during serialization: " + e.getMessage());
     }
 }

 // Method to deserialize an object from a file
 public static Person deserializeObject(String filename) {
     try (FileInputStream fileIn = new FileInputStream(filename);
          ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
         // Read the object from the file
         Person person = (Person) objIn.readObject();
         System.out.println("Deserialization successful: Object read from " + filename);
         return person;
     } catch (IOException | ClassNotFoundException e) {
         System.err.println("Error during deserialization: " + e.getMessage());
         return null;
     }
 }

 // Main method to demonstrate serialization & deserialization
 public static void main(String[] args) {
     String filename = "person.ser"; // Serialized file name

     // Creating an object of Person
     Person person1 = new Person("Anirudha Gaikwad", 40);
     
     // Serialize the object
     serializeObject(person1, filename);
     
     // Deserialize the object
     Person person2 = deserializeObject(filename);
     
     // Display deserialized object details
     if (person2 != null) {
         person2.display();
     }
 }
}

/*
Step 1: Creating a Serializable Class
The Person class implements Serializable to enable object serialization.
serialVersionUID is used to maintain version compatibility.
A constructor initializes name and age.
display() method prints the object details.

Step 2: Serialization Method
serializeObject() takes a Person object and a file name.
Uses FileOutputStream to write the object to a file.
Uses ObjectOutputStream to convert the object into a byte stream.

Step 3: Deserialization Method
deserializeObject() reads the object from the file.
Uses FileInputStream and ObjectInputStream to reconstruct the object.
Returns the deserialized Person object.
*/