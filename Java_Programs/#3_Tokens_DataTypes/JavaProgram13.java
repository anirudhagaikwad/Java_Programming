package PPT3;
/*
* Write a Java program to get whole and fractional parts from a
* double value.
* */
import java.util.*;
public class JavaProgram13 {
    public static void main(String[] args) {
        double value = 12.56;
        //fractional part
        double fractional_part = value % 1;
        //intergral part
        double integral_part = value - fractional_part;
        System.out.print("\nOriginal value: "+value);
        System.out.print("\nIntegral part: "+integral_part);
        System.out.print("\nFractional part: "+fractional_part);
        System.out.println();
    }
}
