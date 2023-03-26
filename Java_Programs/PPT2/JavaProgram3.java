package PPT2;

/*
Given a right angled triangle with height l, base b & hypotenuse h.We need to find the area of the largest square that can fit in the right angled triangle.

Examples:

Input: l = 3, b = 4, h = 5
Output: 2.93878
The biggest square that can fit inside
is of 1.71428 * 1.71428 dimension

Input: l = 5, b = 12, h = 13
Output: 12.4567
*/

//Java Program to find the area of the biggest square
//which can fit inside the right angled triangle
public class JavaProgram3 {

    //Function to find the area of the biggest square
    static float squareArea(float l, float b, float h)
    {

        // the height or base or hypotenuse cannot be negative
        if (l < 0 || b < 0 || h < 0)
            return -1;

        // side of the square
        float a = (l * b) / (l + b);

        // squaring to get the area
        return a * a;
    }

    public static void main(String[] args) {

        float l = 5, b = 12, h = 13;
        System.out.println(squareArea(l, b, h));
    }
}

