package PPT8;

// java program to count the number of objects created of class

public class JavaProgram5
{
    static int count=0; //static variable of class scope
    JavaProgram5()
    {
        count++;
    }
    public static void main(String[] args)
    {
        JavaProgram5 obj1 = new JavaProgram5();
        JavaProgram5 obj2 = new JavaProgram5();
        JavaProgram5 obj3 = new JavaProgram5();
        JavaProgram5 obj4 = new JavaProgram5();
        System.out.println("Number of objects created:"+count);
    }
}