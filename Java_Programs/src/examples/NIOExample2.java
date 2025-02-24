package examples;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class NIOExample2 {

    // Main method to test the implemented functionalities
    public static void main(String[] args) {
        try {
            String inputFile = "C:\\Users\\aniru\\OneDrive\\Desktop\\Has-A_Time.txt";
            String outputFile = "output.txt";

            NIOFileProcessing.reverseFileContent(inputFile, "reversed.txt");
            NIOFileProcessing.findAndReplace(inputFile, "replaced.txt", "Java", "NIO");
            NIOFileProcessing.parseCSV("C:\\Users\\aniru\\OneDrive\\Desktop\\data.csv", "parsed.txt");
            NIOFileProcessing.countWordFrequency(inputFile, "word_frequency.txt");
            NIOFileProcessing.extractPalindromes(inputFile, "palindromes.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class NIOFileProcessing {

    /** 
     * 1) Reverse Content of a Large File (NIO-based version) 
     * Reads a file using FileChannel, reverses each line, and writes it to another file.
     */
    public static void reverseFileContent(String inputFile, String outputFile) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            
            ByteBuffer buffer = ByteBuffer.allocate(8192);
            StringBuilder sb = new StringBuilder();
            while (inChannel.read(buffer) > 0) {
                buffer.flip();
                sb.append(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
            }

            List<String> lines = Arrays.asList(sb.toString().split("\n"));
            Collections.reverse(lines);

            ByteBuffer outputBuffer = StandardCharsets.UTF_8.encode(String.join("\n", lines));
            outChannel.write(outputBuffer);
        }
        System.out.println("File reversed successfully!");
    }

    /** 
     * 2) Find and Replace Words in a File (NIO-based version) 
     * Reads a file, replaces occurrences of a word, and writes to a new file using FileChannel.
     */
    public static void findAndReplace(String inputFile, String outputFile, String target, String replacement) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            
            ByteBuffer buffer = ByteBuffer.allocate((int) inChannel.size());
            inChannel.read(buffer);
            buffer.flip();

            String content = StandardCharsets.UTF_8.decode(buffer).toString();
            content = content.replaceAll(target, replacement);

            ByteBuffer outputBuffer = StandardCharsets.UTF_8.encode(content);
            outChannel.write(outputBuffer);
        }
        System.out.println("Find and replace completed!");
    }

    /**
     * 3) Custom CSV Parser (NIO-based version)
     * Reads a CSV file using FileChannel, processes each line, and writes formatted output.
     */
    public static void parseCSV(String inputFile, String outputFile) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            
            ByteBuffer buffer = ByteBuffer.allocate((int) inChannel.size());
            inChannel.read(buffer);
            buffer.flip();

            String content = StandardCharsets.UTF_8.decode(buffer).toString();
            List<String> parsedLines = Arrays.stream(content.split("\n"))
                    .map(line -> Arrays.toString(line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"))) // Handling quoted CSV values
                    .collect(Collectors.toList());

            ByteBuffer outputBuffer = StandardCharsets.UTF_8.encode(String.join("\n", parsedLines));
            outChannel.write(outputBuffer);
        }
        System.out.println("CSV Parsing completed!");
    }

    /** 
     * 4) Word Frequency Counter in Large File (NIO-based version)
     * Reads a file using FileChannel, counts word frequency, and writes results.
     */
    public static void countWordFrequency(String inputFile, String outputFile) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate((int) inChannel.size());
            inChannel.read(buffer);
            buffer.flip();

            String content = StandardCharsets.UTF_8.decode(buffer).toString().toLowerCase();
            String[] words = content.split("\\W+");

            Map<String, Integer> frequencyMap = new HashMap<>();
            for (String word : words) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }

            List<String> result = frequencyMap.entrySet().stream()
                    .map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.toList());

            ByteBuffer outputBuffer = StandardCharsets.UTF_8.encode(String.join("\n", result));
            outChannel.write(outputBuffer);
        }
        System.out.println("Word frequency count completed!");
    }

    /**
     * 5) Extract Palindromes from a File (NIO-based version)  
     * Reads a file using FileChannel, extracts palindrome words, and writes them.
     */
    public static void extractPalindromes(String inputFile, String outputFile) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate((int) inChannel.size());
            inChannel.read(buffer);
            buffer.flip();

            String content = StandardCharsets.UTF_8.decode(buffer).toString();
            String[] words = content.split("\\W+");

            List<String> palindromes = Arrays.stream(words)
                    .filter(word -> word.length() > 1 && word.equalsIgnoreCase(new StringBuilder(word).reverse().toString()))
                    .collect(Collectors.toList());

            ByteBuffer outputBuffer = StandardCharsets.UTF_8.encode(String.join("\n", palindromes));
            outChannel.write(outputBuffer);
        }
        System.out.println("Palindromes extracted successfully!");
    }
}


//class NIOFileProcessing {
//
//    /** 
//     * **1) Reverse Content of a Large File (NIO-based version)**  
//     * Reads a large file line by line using FileChannel, reverses each line, 
//     * and writes it to another file using FileChannel.
//     */
//    public static void reverseFileContent(String inputFile, String outputFile) throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get(inputFile), StandardCharsets.UTF_8);
//        Collections.reverse(lines);
//        Files.write(Paths.get(outputFile), lines, StandardCharsets.UTF_8);
//        System.out.println("File reversed successfully!");
//    }
//
//    /** 
//     * **2) Find and Replace Words in a File (NIO-based version)**  
//     * Reads a file, replaces occurrences of a word with another, 
//     * and writes to a new file using FileChannel and ByteBuffer.
//     */
//    public static void findAndReplace(String inputFile, String outputFile, String target, String replacement) throws IOException {
//        Path path = Paths.get(inputFile);
//        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
//        content = content.replaceAll(target, replacement);
//        Files.write(Paths.get(outputFile), content.getBytes(StandardCharsets.UTF_8));
//        System.out.println("Find and replace completed!");
//    }
//
//    /**
//     * **3) Custom CSV Parser (NIO-based version)**  
//     * Reads a CSV file using FileChannel, processes each line to extract values, 
//     * and writes formatted output using FileChannel.
//     */
//    public static void parseCSV(String inputFile, String outputFile) throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get(inputFile), StandardCharsets.UTF_8);
//        List<String> parsedLines = new ArrayList<>();
//
//        for (String line : lines) {
//            String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Handles quoted values
//            parsedLines.add(Arrays.toString(values));
//        }
//
//        Files.write(Paths.get(outputFile), parsedLines, StandardCharsets.UTF_8);
//        System.out.println("CSV Parsing completed!");
//    }
//
//    /** 
//     * **4) Word Frequency Counter in Large File (NIO-based version)**  
//     * Reads a file using FileChannel, counts word frequency (ignoring case),
//     * and writes results to another file.
//     */
//    public static void countWordFrequency(String inputFile, String outputFile) throws IOException {
//        Path path = Paths.get(inputFile);
//        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8).toLowerCase();
//        String[] words = content.split("\\W+");
//        
//        Map<String, Integer> frequencyMap = new HashMap<>();
//        for (String word : words) {
//            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
//        }
//
//        List<String> result = frequencyMap.entrySet().stream()
//                .map(entry -> entry.getKey() + " : " + entry.getValue())
//                .collect(Collectors.toList());
//
//        Files.write(Paths.get(outputFile), result, StandardCharsets.UTF_8);
//        System.out.println("Word frequency count completed!");
//    }
//
//    /**
//     * **5) Extract Palindromes from a File (NIO-based version)**  
//     * Reads a file character by character using FileChannel, extracts palindrome words,
//     * and writes them to another file.
//     */
//    public static void extractPalindromes(String inputFile, String outputFile) throws IOException {
//        Path path = Paths.get(inputFile);
//        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
//        String[] words = content.split("\\W+");
//        
//        List<String> palindromes = Arrays.stream(words)
//                .filter(word -> word.length() > 1 && word.equalsIgnoreCase(new StringBuilder(word).reverse().toString()))
//                .collect(Collectors.toList());
//
//        Files.write(Paths.get(outputFile), palindromes, StandardCharsets.UTF_8);
//        System.out.println("Palindromes extracted successfully!");
//    }
//
//}
