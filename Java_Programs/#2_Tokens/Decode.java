public class Decode{
public static String decode(String input, int key) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        c = (char) (c ^ key);
        output.append(c);
    }
    return output.toString();
}

public static String encode(String input, int key) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        c = (char) (c ^ key);
        output.append(c);
    }
    return output.toString();
}

public static void main(String ar[]){

String message = "Literals In Java";
int key = 11;

String encodedMessage = encode(message, key);
System.out.println("Encoded message: " + encodedMessage);

String decodedMessage = decode(encodedMessage, key);
System.out.println("Decoded message: " + decodedMessage);

}



}
