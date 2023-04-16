package PPT8;

// java program for pasing and returning objects of class

import java.util.Scanner;
public class JavaProgram3
{
    int length, breadth, area;
    JavaProgram3 area1(JavaProgram3 object1)
    {
        object1 = new JavaProgram3();
        object1.length = this.length;
        object1.breadth = this.breadth;
        object1.area = object1.length * object1.breadth;
        return object1;
    }
    JavaProgram3 area2(JavaProgram3 object2)
    {
        object2 = new JavaProgram3();
        object2.length = this.length + 5;
        object2.breadth = this.breadth + 6;
        object2.area = object2.length * object2.breadth;
        return object2;
    }
    public static void main(String[] args)
    {
        JavaProgram3 obj = new JavaProgram3();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter length:");
        obj.length = s.nextInt();
        System.out.print("Enter breadth:");
        obj.breadth = s.nextInt();
        JavaProgram3 a = obj.area1(obj);
        JavaProgram3 b = obj.area2(obj);
        System.out.println("Area:"+a.area);
        System.out.println("Area:"+b.area);
    }
}
