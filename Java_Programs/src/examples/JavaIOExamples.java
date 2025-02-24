package examples;
import java.io.*;
import java.util.*;

public class JavaIOExamples {
    public static void main(String[] args) throws IOException {
        String inputFile = "input.txt";
        String encryptedFile = "encrypted.bin";
        String decryptedFile = "decrypted.txt";
        String mergedFile = "merged.bin";
        String serializedFile = "data.bin";
        String logFile = "log.txt";

        // Call Encryption & Decryption
        byte xorKey = 0x5A;
        FileOperations.encryptDecryptFile(inputFile, encryptedFile, xorKey);
        FileOperations.encryptDecryptFile(encryptedFile, decryptedFile, xorKey);

        // Call Merge Files
        FileOperations.mergeFiles(mergedFile, "file1.bin", "file2.bin");

        // Call Serialization
        FileOperations.serialize(serializedFile, "Anirudha Gaikwad", 30, 50000.50);
        FileOperations.deserialize(serializedFile);

        // Call Password Masking
        FileOperations.readMaskedPassword();

        // Call Chat Simulator
        FileOperations.chatSimulator();

        // Call Logging User Input
        FileOperations.logUserInput(logFile);
    }
}



class FileOperations {

    /**
     * 41) Encrypted File Transfer: Reads a binary file, encrypts its content using XOR cipher,
     * and writes it to another file using FileInputStream and FileOutputStream. Implements decryption as well.
     */
    public static void encryptDecryptFile(String inputFile, String outputFile, byte xorKey) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ xorKey);
            }
        }
    }

    /**
     * 42) Merging Large Binary Files: Merges multiple large binary files into a single file using
     * BufferedInputStream and BufferedOutputStream.
     */
    public static void mergeFiles(String outputFile, String... inputFiles) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            for (String inputFile : inputFiles) {
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile))) {
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        bos.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }

    /**
     * 43) Custom Serialization: Serializes and deserializes an object using DataOutputStream and DataInputStream.
     */
    public static void serialize(String outputFile, String name, int age, double salary) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFile))) {
            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeDouble(salary);
        }
    }

    public static void deserialize(String inputFile) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(inputFile))) {
            System.out.println("Name: " + dis.readUTF() + ", Age: " + dis.readInt() + ", Salary: " + dis.readDouble());
        }
    }

    /**
     * 51) Password Masking on Console: Reads password securely.
     */
    public static void readMaskedPassword() {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available.");
            return;
        }
        char[] password = console.readPassword("Enter password: ");
        System.out.println("Password entered: " + "*".repeat(password.length));
    }

    /**
     * 52) Interactive Command-line Chat: Simulated chat responses.
     */
    public static void chatSimulator() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type 'exit' to quit.");

        String input;
        while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
            System.out.println("Chatbot: " + input.toUpperCase());
        }
    }

    /**
     * 53) Logging User Input to a File: Logs user input with timestamps.
     */
    public static void logUserInput(String logFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new FileWriter(logFile, true))) {

            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                pw.println(new Date() + " - " + input);
            }
        }
    }


}
