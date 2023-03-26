package PPT20;
/*
Encrypt and Decrypt String File Using Java

Example
Let’s assume that the key used here is 7

Sender side:

Clear text :  G E E K
Key:          7 7 7 7
Cipher text:  N L L R
Receiver side:

Cipher text:   N L L R
Key:           7 7 7 7
Decipher text: G E E K

*/

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class JavaProgram10 {
    public static void main(String[] args)
    {

        try {
            // Generating objects of KeyGenerator &
            // SecretKey
            KeyGenerator keygenerator
                    = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            // Creating object of Cipher
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES");

            // Creating byte array to store string
            byte[] text
                    = "No body can see me.".getBytes("UTF8");

            // Encrypting text
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = desCipher.doFinal(text);

            // Converting encrypted byte array to string
            String s = new String(textEncrypted);
            System.out.println(s);

            // Decrypting text
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted
                    = desCipher.doFinal(textEncrypted);

            // Converting decrypted byte array to string
            s = new String(textDecrypted);
            System.out.println(s);
        }
        catch (Exception e) {
            System.out.println("Exception");
        }
    }
}

