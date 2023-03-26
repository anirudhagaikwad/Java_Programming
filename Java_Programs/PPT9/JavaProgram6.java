package PPT9;

//  Java Program to Use Super Keyword in Inheritance Class.

class BaseCls
{
    int x = 19;
}

class JavaProgram6 extends BaseCls
{
    int x = 20;
    void shows()
    {
        System.out.println("The base class data member (x) by Super Keyword :" + super.x);
        System.out.println("The child class data member :" + x);

    }
    public static void main(String... a)
    {
        JavaProgram6 obj = new JavaProgram6();
        obj.shows();
    }
}