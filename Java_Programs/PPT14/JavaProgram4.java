package PPT14;

/*
* Write a generic method in JAVA for printing elements of array
* */
public class JavaProgram4{
    public static < T > void printGenericArray(T[] items) {
        for ( T item : items){
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void main( String args[] )
    {
        Integer[] int_Array = { 1, 3, 5, 7, 9, 11 };
        Character[] char_Array = { 'J', 'A', 'V', 'A', 'T','U','T','O','R','I','A', 'L','S' };

        System.out.println( "Integer Array contents:" );
        printGenericArray(int_Array  );

        System.out.println( "Character Array contents:" );
        printGenericArray(char_Array );
    }
}