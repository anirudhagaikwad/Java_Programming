package oop;
/*
### Shallow Copy:
Copies field values as is, meaning that if the object contains references to other objects, 
the references are copied instead of the actual objects.
Any modifications to the referenced objects in one copy will affect the other.

### Deep Copy:
Creates a completely independent copy, including copies of referenced objects.
Modifications to the copied object won’t affect the original object.

## 2) Shallow Copy vs Deep Copy
| Feature          | Shallow Copy | Deep Copy |
|------------------|-------------|-----------|
| Definition       | Copies object references, meaning changes in copied object affect the original. | Creates a completely new object with new copies of original values. |
| Memory Usage     | Less, as it only copies references. | More, as it duplicates all values. |
| Performance      | Faster, since only references are copied. | Slower, as deep copies require extra processing. |
| Used In          | Default behavior of `clone()` method in `Object` class. | When independent copies are needed, such as in multi-threaded environments. |
| Implementation   | Uses `Object.clone()` method. | Requires implementing `Cloneable` and manually copying objects. |

---
 
*/
public class P28_ShallowCopy_DeepCopy {

	 public static void main(String[] args) {
	     try {
	         // Creating original object
	         Address address = new Address("Pune");
	         PersonDummy original = new PersonDummy("Anirudha", address);
	         
	         // Shallow Copy
	         PersonDummy shallowCopy = (PersonDummy) original.clone();
	         
	         // Deep Copy
	         PersonDummy deepCopy = original.deepCopy();

	         // Displaying before modification
	         System.out.println("Before modification:");
	         original.display();
	         shallowCopy.display();
	         deepCopy.display();

	         // Modifying the address in the original object
	         original.address.city = "Los Angeles";

	         // Displaying after modification
	         System.out.println("\nAfter modifying original's address:");
	         original.display();
	         shallowCopy.display(); // Shallow copy will reflect changes
	         deepCopy.display(); // Deep copy remains unaffected

	     } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	     }
	 }

}


//Class representing an Address
class Address {
 String city;
 
 // Constructor
 public Address(String city) {
     this.city = city;
 }
}

//Class representing a PersonDummy
class PersonDummy implements Cloneable {
 String name;
 Address address; // Reference type field
 
 // Constructor
 public PersonDummy(String name, Address address) {
     this.name = name;
     this.address = address;
 }
 
 // Shallow Copy Method (Uses default clone)
 @Override
 protected Object clone() throws CloneNotSupportedException {
     return super.clone(); // Creates a shallow copy
 }
 
 // Deep Copy Method (Manually clones referenced objects)
 public PersonDummy deepCopy() {
     return new PersonDummy(this.name, new Address(this.address.city)); // New Address object created
 }

 // Method to display object details
 public void display() {
     System.out.println("Name: " + name + ", City: " + address.city);
 }
}

