package PPT4;

// write a java program to generate random numbers within range given

import java.io.*;
import java.util.*;

class JavaProgram10 {
    public static void main (String[] args) {
        Random rand = new Random();
        int max=100,min=50;
        System.out.println("Generated numbers are within "+min+" to "+max);
        System.out.println(rand.nextInt(max - min + 1) + min);
        System.out.println(rand.nextInt(max - min + 1) + min);
        System.out.println(rand.nextInt(max - min + 1) + min);
    }
}
