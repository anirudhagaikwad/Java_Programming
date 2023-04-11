package PPT2;
import java.util.Scanner;

/*
 *
 * Write Program for convert Tyre Air Pressure using Abstract Class
 * BAR to PSI
 * PSI to BAR
 * PSI stands for ‘pound-force per square inch’
 * BAR stands for '   '
 * Converting from BAR to PSI :
For an approximate result, multiply the pressure value by 14.504
Converting from PSI to kPa :
For an approximate result, divide the pressure value by 6.895
 */
public class JavaProgram6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //TyreAirPressure obj=new TyreAirPressure(;)
        Convertor obj=new Convertor();
        obj.convert_BAR_TO_PSI();
        obj.convert_PSI_To_BAR();

    }

}

abstract class TyreAirPressure{

    abstract void convert_PSI_To_BAR();
    int psi=5;
    void convert_BAR_TO_PSI() {
        Scanner scObj=new Scanner(System.in);
        System.out.println("Enter BAR VAlue: ");
        int bar=scObj.nextInt();
        //1 bar=14.503773773 psi
        double psi=bar*14.503773773;
        System.out.println(bar+"bar = "+psi+" psi");

    }
}//abstract class

class Convertor extends TyreAirPressure{
    public void convert_PSI_To_BAR() {
        Scanner scObj=new Scanner(System.in);
        System.out.println("Enter psi VAlue: ");
        int psi=scObj.nextInt();
        //1 bar=0.06894 psi
        double bar=psi*0.06894;
        System.out.println(psi+"psi = "+bar+" bar");

    }
}

