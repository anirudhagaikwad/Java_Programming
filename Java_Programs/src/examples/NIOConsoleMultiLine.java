package examples;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
//Multi-Line Input Handling
public class NIOConsoleMultiLine {

    public static void main(String[] args) throws IOException {
        System.out.println("=== Enter Details Using Java NIO ===");

        String name = readString("Enter your name: ");
        int age = readInt("Enter your age: ");
        double salary = readDouble("Enter your salary: ");
        String bio = readMultiLine("Enter your bio (type 'exit' to finish): ");

        System.out.println("\n=== User Entered Details ===");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Salary : " + salary);
        System.out.println("Bio    : \n" + bio);
    }

    // Read Single-Line String input
    public static String readString(String prompt) throws IOException {
        System.out.print(prompt);
        return readFromConsole().trim();
    }

    // Read Integer input with validation
    public static int readInt(String prompt) throws IOException {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(readFromConsole().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    // Read Double input with validation
    public static double readDouble(String prompt) throws IOException {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(readFromConsole().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid decimal number.");
            }
        }
    }

    // Read Multi-Line input until "exit" is entered
    public static String readMultiLine(String prompt) throws IOException {
        System.out.println(prompt);
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = readFromConsole().trim();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            lines.add(line);
        }
        return String.join("\n", lines);
    }

    // Core method to read input using NIO
    private static String readFromConsole() throws IOException {
        ReadableByteChannel channel = Channels.newChannel(System.in);
        ByteBuffer buffer = ByteBuffer.allocate(256); // 256-byte buffer
        channel.read(buffer);
        buffer.flip();
        return StandardCharsets.UTF_8.decode(buffer).toString();
    }
}
