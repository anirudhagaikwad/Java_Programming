package PPT3;
/* Given a number x, find next number with same number of 1 bits in it’s
binary representation.
For example, consider x = 12, whose binary representation is 1100
 (excluding leading zeros on 32 bit machine). It contains two logic 1 bits.
 The next higher number with two logic 1 bits is 17 (100012).

*/
class JavaProgram6
{

    // this function returns next higher
// number with same number of set bits as x.
    static int snoob(int x)
    {

        int rightOne, nextHigherOneBit, rightOnesPattern, next = 0;

        if(x > 0)
        {

            // right most set bit
            rightOne = x & -x;

            // reset the pattern and set next higher bit
            // left part of x will be here
            nextHigherOneBit = x + rightOne;

            // nextHigherOneBit is now part [D] of the above explanation.

            // isolate the pattern
            rightOnesPattern = x ^ nextHigherOneBit;

            // right adjust pattern
            rightOnesPattern = (rightOnesPattern)/rightOne;

            // correction factor
            rightOnesPattern >>= 2;

            // rightOnesPattern is now part [A] of the above explanation.

            // integrate new pattern (Add [D] and [A])
            next = nextHigherOneBit | rightOnesPattern;
        }

        return next;
    }


    public static void main (String[] args)
    {
        int x = 156;
        System.out.println("Next higher number with same " +
                "number of set bits is "+snoob(x));
    }
}


