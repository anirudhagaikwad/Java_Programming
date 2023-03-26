package PPT2;

/*
Given three angles. The task is to check if it is possible to have a triangle of positive area with these angles. If it is possible print “YES” else print “NO”.

Examples:
Input : ang1 = 50, ang2 = 60, ang3 = 70
Output : YES

Input : ang1 = 50, ang2 = 65, ang3 = 80
Output : NO
*/


class JavaProgram2
{
    static String isTriangleExists(int a, int b, int c)
    {
        /* Checking if the sum of three angles is 180 and none of the angles is zero*/
        if(a != 0 && b != 0 && c != 0 && (a + b + c)== 180)
            // Checking if sum of any two angles
            // is greater than equal to the third one
            if((a + b)>= c || (b + c)>= a || (a + c)>= b)
                return "YES";
            else
                return "NO";
        else
            return "NO";
    }

    public static void main(String[] args)
    {
        int a=50, b=60, c = 70;
        System.out.println(isTriangleExists(a, b, c));
    }
}


