package PPT13;

/*
Write a Java program which creates only one object. If user attempts to create second object, he should not be able to create it. (Using Exception Handling).
*/

//create custom exception
class NotMoreException extends Exception
{
    NotMoreException()
    {
        super("No more than 1 object");
    }
}



class Test
{
    static int cnt=0;
    Test() throws NotMoreException
    {
        if (cnt == 0)
        {
            cnt++;  //count number of obj
        }
        else
            throw new NotMoreException(); //if count is greater than 1 then throw exception
    }
}


class JavaProgram4
{
    public static void main(String[] args)
    {
        try
        {
            Test t1 = new Test();
            Test t2 = new Test();
            Test t3 = new Test();
            //we have created more than 1 obj so exception will occur
        }
        catch (NotMoreException ex)
        {
            System.out.println(ex);
        }
    }
}


