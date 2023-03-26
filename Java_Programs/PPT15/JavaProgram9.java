package PPT15;
/*
Given a string with repeated characters, we have to insert a star i.e.” * “ between pair of adjacent identical characters using recursion.
Examples:

Input : aabb
Output : a*ab*b

Input : xxxy
Output : x*x*xy
*/

// Recursive Java program to insert * between two consecutive same characters.
class JavaProgram9
{

    static String output="";

    // Function to insert * at desired position
    static void pairStar(String input,
                         int i)
    {
        // Append current character
        output = output + input.charAt(i);

        // If we reached last character
        if (i == input.length() - 1)
            return;

        // If next character is same, append '*'
        if (input.charAt(i) == input.charAt(i+1))
            output = output + '*';

        pairStar(input, i+1);
    }


    public static void main(String[] args)
    {
        String input = "pizza";
        pairStar(input,0);
        System.out.println(output);
    }
}


