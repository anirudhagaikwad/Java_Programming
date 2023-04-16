package PPT8;

/* Java program to demonstrate initializing
 an array of objects using a method
 */

class JavaProgram13 {
    public static void main(String args[])
    {
        // Declaring an array of student
        Student[] arr;
        // Allocating memory for 2 objects
        // of type student
        arr = new Student[2];

        // Creating actual student objects
        arr[0] = new Student();
        arr[1] = new Student();

        // Assigning data to student objects
        arr[0].setData(1701289270, "Satyabrata");
        arr[1].setData(1701289219, "Omm Prasad");

        // Displaying the student data
        System.out.println(
                "Student data in student arr 0: ");
        arr[0].display();

        System.out.println(
                "Student data in student arr 1: ");
        arr[1].display();
    }
}

// Creating a Student class with
// id and name as a attributes
class Student {

    public int id;
    public String name;

    // Method to set the data to
    // student objects
    public void setData(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    // display() method to display
    // the student data
    public void display()
    {
        System.out.println("Student id is: " + id + " "
                + "and Student name is: "
                + name);
        System.out.println();
    }
}

