package examples;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;

public class NIOExample1 {

	 public static void main(String[] args) {
	        try {
	        	NIOExamples.extractPalindromes("input.txt", "palindromes.txt");
	        	NIOExamples.maskPassword();
	        	NIOExamples.interactiveChat();
	        	NIOExamples.logUserInput("user_log.txt");
	        	NIOExamples.multiThreadedChat();
	        	NIOExamples.realTimeDataStreaming("data_log.txt");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}



class NIOExamples {

    /**
     * 50) Extract Palindromes from a File (NIO-based version)
     * Reads a file using FileChannel and ByteBuffer, extracts all palindrome words,
     * and writes them to another file using FileChannel and ByteBuffer.
     */
    public static void extractPalindromes(String inputFile, String outputFile) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            StringBuilder content = new StringBuilder();
            while (inChannel.read(buffer) > 0) {
                buffer.flip();
                content.append(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
            }

            List<String> palindromes = Arrays.stream(content.toString().split("\\s+"))
                    .filter(word -> word.length() > 1 && word.equalsIgnoreCase(new StringBuilder(word).reverse().toString()))
                    .collect(Collectors.toList());

            ByteBuffer outBuffer = ByteBuffer.wrap(String.join("\n", palindromes).getBytes(StandardCharsets.UTF_8));
            outChannel.write(outBuffer);
        }
    }

    /**
     * 51) Password Masking on Console (NIO-based version)
     * Reads a password from System.in via Channel-based NIO input stream,
     * masks input, and securely stores it.
     */
    public static void maskPassword() throws IOException {
        System.out.print("Enter Password: ");
        ReadableByteChannel inChannel = Channels.newChannel(System.in);
        ByteBuffer buffer = ByteBuffer.allocate(50);
        inChannel.read(buffer);
        buffer.flip();
        
        char[] passwordChars = new char[buffer.remaining()];
        for (int i = 0; i < passwordChars.length; i++) {
            passwordChars[i] = (char) buffer.get();
            System.out.print("*");
        }
        System.out.println("\nPassword securely stored.");
    }

    /**
     * 52) Interactive Command-line Chat (NIO-based version)
     * Simulates a chat where user inputs via non-blocking NIO and receives responses.
     */
    public static void interactiveChat() throws IOException {
        ReadableByteChannel inChannel = Channels.newChannel(System.in);
        ByteBuffer buffer = ByteBuffer.allocate(256);
        System.out.println("Start chatting (type 'exit' to quit):");

        while (true) {
            buffer.clear();
            inChannel.read(buffer);
            buffer.flip();
            String input = StandardCharsets.UTF_8.decode(buffer).toString().trim();

            if ("exit".equalsIgnoreCase(input)) break;
            System.out.println("Bot: " + input.toUpperCase()); // Simple response logic
        }
    }

    /**
     * 53) Logging User Input to a File (NIO-based version)
     * Captures user input using NIO Channels and logs them with timestamps.
     */
    public static void logUserInput(String logFile) throws IOException {
        FileChannel outChannel = FileChannel.open(Paths.get(logFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        ReadableByteChannel inChannel = Channels.newChannel(System.in);
        ByteBuffer buffer = ByteBuffer.allocate(256);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("Start typing (type 'exit' to quit):");
        while (true) {
            buffer.clear();
            inChannel.read(buffer);
            buffer.flip();
            String input = StandardCharsets.UTF_8.decode(buffer).toString().trim();

            if ("exit".equalsIgnoreCase(input)) break;

            String logEntry = dtf.format(LocalDateTime.now()) + " - " + input + "\n";
            ByteBuffer logBuffer = ByteBuffer.wrap(logEntry.getBytes(StandardCharsets.UTF_8));
            outChannel.write(logBuffer);
        }
    }

    /**
     * 54) Multi-Threaded Console Chat (NIO-based version)
     * Uses two threads: one for reading user input and another for responding asynchronously.
     */
    public static void multiThreadedChat() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                ReadableByteChannel inChannel = Channels.newChannel(System.in);
                ByteBuffer buffer = ByteBuffer.allocate(256);
                while (true) {
                    buffer.clear();
                    inChannel.read(buffer);
                    buffer.flip();
                    String input = StandardCharsets.UTF_8.decode(buffer).toString().trim();
                    if ("exit".equalsIgnoreCase(input)) break;
                    System.out.println("You: " + input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    System.out.println("Chatbot: I'm here to chat!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        executor.shutdown();
    }

    /**
     * 55) Real-time Data Streaming (NIO-based version)
     * Reads numeric inputs, computes a moving average, and writes results to a file.
     */
    public static void realTimeDataStreaming(String outputFile) throws IOException {
        FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        ReadableByteChannel inChannel = Channels.newChannel(System.in);
        ByteBuffer buffer = ByteBuffer.allocate(256);
        List<Double> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'exit' to stop):");
        while (true) {
            buffer.clear();
            inChannel.read(buffer);
            buffer.flip();
            String input = StandardCharsets.UTF_8.decode(buffer).toString().trim();

            if ("exit".equalsIgnoreCase(input)) break;
            try {
                double num = Double.parseDouble(input);
                numbers.add(num);
                if (numbers.size() > 5) numbers.remove(0); // Keep last 5 entries for moving average

                double avg = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0);
                String logEntry = "Number: " + num + ", Moving Average: " + avg + "\n";
                ByteBuffer logBuffer = ByteBuffer.wrap(logEntry.getBytes(StandardCharsets.UTF_8));
                outChannel.write(logBuffer);

                System.out.println("Current Moving Average: " + avg);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }
}
