import java.util.Scanner;
public class UnicodeCharacter {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        
        char ch = obj.next().charAt(0);
        int unicode = (int) ch ;
        
        System.out.println("The Unicode value of " + ch + " is \\u" + Integer.toHexString(unicode));
    }
}

