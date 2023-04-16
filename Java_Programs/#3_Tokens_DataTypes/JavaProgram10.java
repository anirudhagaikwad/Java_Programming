package PPT3;

/*
Given a positive integer, check if the number is prime or not. A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself. Examples of first few prime numbers are {2, 3, 5, Examples :

Input:  n = 11
Output: true

Input:  n = 15
Output: false

Input:  n = 1
Output: false

*/

// A school method based JAVA program  to check if a number is prime
class JavaProgram10 {

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }


    public static void main(String args[])
    {
        if (isPrime(11))
            System.out.println(" true");
        else
            System.out.println(" false");
        if (isPrime(15))
            System.out.println(" true");
        else
            System.out.println(" false");
    }
}
