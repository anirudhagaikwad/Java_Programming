package PPT2;
/*
Given area and hypotenuse, the aim is to print all sides if right triangle can exist, else print -1. We need to print all sides in ascending order.

Examples:

Input  : 6 5
Output : 3 4 5

Input  : 10 6
Output : -1
*/
class JavaProgram1 {

    // Prints three sides of a right triangle
    // from given area and hypotenuse if triangle
    // is possible, else prints -1.
    static void findRightAngle(double A, double H)
    {
        // Descriminant of the equation
        double D = Math.pow(H, 4) - 16 * A * A;

        if (D >= 0)
        {
            // applying the linear equation
            // formula to find both the roots
            double root1 = (H * H + Math.sqrt(D)) / 2;
            double root2 = (H * H - Math.sqrt(D)) / 2;

            double a = Math.sqrt(root1);
            double b = Math.sqrt(root2);
            if (b >= a)
                System.out.print(a + " " + b + " " + H);
            else
                System.out.print(b + " " + a + " " + H);
        }
        else
            System.out.print("-1");
    }


    public static void main(String arg[])
    {
        findRightAngle(6, 5);
    }
}

