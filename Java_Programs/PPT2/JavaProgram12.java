package PPT2;

/*
Given radius and height of Cylinder,
calculate the volume, total surface area and curved surface area of cylinder.

Example:
Input  : Enter Radius Of Cylinder   5
         Enter Height Of Cylinder   8
Output : Volume       Of       Cylinder   =   628.3185307179587
         Total  Surface Area  Of Cylinder =   408.4070449666731
         Curved Surface Area  Of Cylinder =   251.32741228718345
* */

import java.io.*;

class JavaProgram12
{
    static double PI = 3.14159;

    // Function To Calculate Volume OF Cylinder
    static void volume(double r, double h)
    {
        double vol = PI * r * r * h;
        System.out.println( "Volume of Cylinder = "
                + vol );
    }

    // Function To Calculate Total Surface Area OF Cylinder
    static void totalsurfacearea(double r, double h)
    {
        double tsurf_ar = (2 * PI * r * h) + (2 * PI * r * r);
        System.out.println( "Total Surface Area Of Cylinder = "
                + tsurf_ar );
    }

    // Function To Calculate Curved Surface Area OF Cylinder
    static void curvedsurfacearea(double r, double h)
    {
        double cursurf_ar = (2 * PI * r * h);
        System.out.println( "Curved Surface Area Of Cylinder = "
                + cursurf_ar );
    }


    public static void main (String[] args)
    {
        double r = 7;
        double h = 6;
        volume(r, h);
        totalsurfacearea(r, h);
        curvedsurfacearea(r, h);
    }
}


