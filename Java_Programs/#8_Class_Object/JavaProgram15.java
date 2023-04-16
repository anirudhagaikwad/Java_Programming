package PPT8;

/* Java program to demonstrate that we can swap two
 objects be swapping members
 */

class Car {
    // Attributes associated with car
    int no;
    Car(int no) { this.no = no; }
}

class JavaProgram15 {
    // Method 1
    // To swap
    public static void swap(Car c1, Car c2)
    {  //swap 2 object using third variable
        int temp = c1.no;
        c1.no = c2.no;
        c2.no = temp;
    }

    // Method 2
    // Main driver method
    public static void main(String[] args)
    {
        // Creating car class objects(creating cars)
        Car c1 = new Car(1);
        Car c2 = new Car(2);

        // Calling method 1
        swap(c1, c2);

        // Print and display commands
        System.out.println("c1.no = " + c1.no);
        System.out.println("c2.no = " + c2.no);
    }
}
