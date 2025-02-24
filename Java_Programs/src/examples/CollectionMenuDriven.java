package examples;


import java.util.*;

//Class to demonstrate ArrayList
class ArrayListDemo {
 private List<String> arrayList = new ArrayList<>();

 // Add element to ArrayList
 public void addElement(String element) {
     arrayList.add(element);
     System.out.println(element + " added to ArrayList.");
 }

 // Remove element from ArrayList
 public void removeElement(String element) {
     if (arrayList.remove(element)) {
         System.out.println(element + " removed from ArrayList.");
     } else {
         System.out.println(element + " not found in ArrayList.");
     }
 }

 // Update element in ArrayList
 public void updateElement(int index, String newElement) {
     if (index >= 0 && index < arrayList.size()) {
         arrayList.set(index, newElement);
         System.out.println("Element at index " + index + " updated.");
     } else {
         System.out.println("Invalid index.");
     }
 }

 // Display all elements in ArrayList
 public void displayElements() {
     System.out.println("ArrayList Elements: " + arrayList);
 }
}

//Class to demonstrate LinkedList
class LinkedListDemo {
 private List<String> linkedList = new LinkedList<>();

 public void addElement(String element) {
     linkedList.add(element);
     System.out.println(element + " added to LinkedList.");
 }

 public void removeElement(String element) {
     if (linkedList.remove(element)) {
         System.out.println(element + " removed from LinkedList.");
     } else {
         System.out.println(element + " not found in LinkedList.");
     }
 }

 public void updateElement(int index, String newElement) {
     if (index >= 0 && index < linkedList.size()) {
         linkedList.set(index, newElement);
         System.out.println("Element at index " + index + " updated.");
     } else {
         System.out.println("Invalid index.");
     }
 }

 public void displayElements() {
     System.out.println("LinkedList Elements: " + linkedList);
 }
}

//Class to demonstrate Vector
class VectorDemo {
 private List<String> vector = new Vector<>();

 public void addElement(String element) {
     vector.add(element);
     System.out.println(element + " added to Vector.");
 }

 public void removeElement(String element) {
     if (vector.remove(element)) {
         System.out.println(element + " removed from Vector.");
     } else {
         System.out.println(element + " not found in Vector.");
     }
 }

 public void updateElement(int index, String newElement) {
     if (index >= 0 && index < vector.size()) {
         vector.set(index, newElement);
         System.out.println("Element at index " + index + " updated.");
     } else {
         System.out.println("Invalid index.");
     }
 }

 public void displayElements() {
     System.out.println("Vector Elements: " + vector);
 }
}

//Main class with menu-driven program
public class CollectionMenuDriven {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     ArrayListDemo arrayListDemo = new ArrayListDemo();
     LinkedListDemo linkedListDemo = new LinkedListDemo();
     VectorDemo vectorDemo = new VectorDemo();

     while (true) {
         System.out.println("\n--- Collection Menu ---");
         System.out.println("1. ArrayList Operations");
         System.out.println("2. LinkedList Operations");
         System.out.println("3. Vector Operations");
         System.out.println("4. Exit");
         System.out.print("Enter choice: ");
         int choice = scanner.nextInt();
         scanner.nextLine();  // Consume newline

         if (choice == 4) {
             System.out.println("Exiting program...");
             break;
         }

         System.out.println("\nChoose Operation:");
         System.out.println("1. Add Element");
         System.out.println("2. Remove Element");
         System.out.println("3. Update Element");
         System.out.println("4. Display Elements");
         System.out.print("Enter operation: ");
         int operation = scanner.nextInt();
         scanner.nextLine();  // Consume newline

         String element;
         int index;

         switch (choice) {
             case 1:
                 switch (operation) {
                     case 1:
                         System.out.print("Enter element to add: ");
                         element = scanner.nextLine();
                         arrayListDemo.addElement(element);
                         break;
                     case 2:
                         System.out.print("Enter element to remove: ");
                         element = scanner.nextLine();
                         arrayListDemo.removeElement(element);
                         break;
                     case 3:
                         System.out.print("Enter index: ");
                         index = scanner.nextInt();
                         scanner.nextLine();
                         System.out.print("Enter new element: ");
                         element = scanner.nextLine();
                         arrayListDemo.updateElement(index, element);
                         break;
                     case 4:
                         arrayListDemo.displayElements();
                         break;
                 }
                 break;

             case 2:
                 switch (operation) {
                     case 1:
                         System.out.print("Enter element to add: ");
                         element = scanner.nextLine();
                         linkedListDemo.addElement(element);
                         break;
                     case 2:
                         System.out.print("Enter element to remove: ");
                         element = scanner.nextLine();
                         linkedListDemo.removeElement(element);
                         break;
                     case 3:
                         System.out.print("Enter index: ");
                         index = scanner.nextInt();
                         scanner.nextLine();
                         System.out.print("Enter new element: ");
                         element = scanner.nextLine();
                         linkedListDemo.updateElement(index, element);
                         break;
                     case 4:
                         linkedListDemo.displayElements();
                         break;
                 }
                 break;

             case 3:
                 switch (operation) {
                     case 1:
                         System.out.print("Enter element to add: ");
                         element = scanner.nextLine();
                         vectorDemo.addElement(element);
                         break;
                     case 2:
                         System.out.print("Enter element to remove: ");
                         element = scanner.nextLine();
                         vectorDemo.removeElement(element);
                         break;
                     case 3:
                         System.out.print("Enter index: ");
                         index = scanner.nextInt();
                         scanner.nextLine();
                         System.out.print("Enter new element: ");
                         element = scanner.nextLine();
                         vectorDemo.updateElement(index, element);
                         break;
                     case 4:
                         vectorDemo.displayElements();
                         break;
                 }
                 break;

             default:
                 System.out.println("Invalid Choice! Try Again.");
         }
     }
     scanner.close();
 }
}


