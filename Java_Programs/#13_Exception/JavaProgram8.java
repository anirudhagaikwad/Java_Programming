package PPT13;

// Java Program to Handle multiple Exceptions

class JavaProgram8 {
    public static void main(String[] args)
    {
        // Array1 Elements
        int[] array1 = { 2, 4, 6, 7, 8 };

        // Array2 Elements
        int[] array2 = { 1, 2, 3, 4, 5 };
        // Initialized to null value
        int[] ans = null;
        try {
            for (int i = 0; i < 5; i++) {
                ans[i] = array1[i] / array2[i];
                // Generates Number Format Exception
                Integer.parseInt("Geeks for Geeks");
            }
        }
        catch (ArithmeticException error) {
            System.out.println(
                    "The catch block with Arithmetic Exception is executed");
        }
        catch (NullPointerException error) {
            System.out.println(
                    "The catch block with Null Pointer Exception is executed");
        }
        catch (ArrayIndexOutOfBoundsException error) {
            System.out.println(
                    "The catch block with Array Index Out Of Bounds Exception is executed");
        }
        catch (NumberFormatException error) {
            System.out.println(
                    "The catch block with Number Format Exception is executed");
        }
        // Executes when an exception which
        // is not specified above occurs
        catch (Exception error) {
            System.out.println(
                    "An unknown exception is found "
                            + error.getMessage());
        }

        // Executes after the catch block
        System.out.println("End of program");
    }
}
