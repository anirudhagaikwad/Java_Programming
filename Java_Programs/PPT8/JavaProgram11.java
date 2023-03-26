package PPT8;
/*
write a java program to assign and fetch instance variable of class
*/
class Dog {
    // Instance Variables
    String breed;
    String size;
    int age;
    String color;


    // method to print current object data
    public String getInfo() {

        return ("Breed is: "+breed+" Size is:"+size+" Age is:"+age+" color is: "+color);
    }
}
public class JavaProgram11{
    public static void main(String[] args) {
        Dog maltese = new Dog();
        //set instance variables using dot operator
        maltese.breed="Maltese";
        maltese.size="Small";
        maltese.age=2;
        maltese.color="white";
        System.out.println(maltese.getInfo());
    }
}

