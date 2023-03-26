package PPT3;
//Write a java program for checking integer addition overflow
public class JavaProgram2 {

    /* Takes pointer to result and two numbers as
        arguments. If there is no overflow, the function
        places the resultant = sum a+b in “result” and
        returns 0, otherwise it returns -1 */
    static int addOvf(int result, int a, int b) {
        result = a + b;
        if (a > 0 && b > 0 && result < 0)
            return -1;
        if (a < 0 && b < 0 && result > 0)
            return -1;
        return 0;
    }


    public static void main(String args[]) {
        int res = -2147483646; // size of an Integer
        int x = 2147483640;
        int y = 10;

        System.out.println(addOvf(res, x, y));

    }
}

