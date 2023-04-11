package PPT2;
/*
Write a JAVA program to calculate volume of tetrahedron.

A Tetrahedron is simply a pyramid with a triangular base.
It is a solid object with four triangular faces, three on the sides or lateral faces,
one on the bottom of the base and four vertices or corners.
If the faces are all congruent equilateral triangles, then the tetrahedron is called regular.


The volume of the tetrahedron can be found by using the following formula :
Volume = a3/(6√2)

Examples :
Input : side = 3
Output: 3.18

Input : side = 20
Output: 942.81
* */

import java.io.*;

class JavaProgram11 {
    // Function to calculate volume
    static double vol_tetra(int side)
    {
        double volume = (Math.pow(side, 3) / (6 * Math.sqrt(2)));
        return volume;
    }

    public static void main(String[] args)
    {
        int side = 3;
        double vol = vol_tetra(side);
        vol = (double)Math.round(vol * 100) / 100;
        System.out.println(vol);
    }
}
