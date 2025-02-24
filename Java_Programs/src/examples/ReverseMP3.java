package examples;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class ReverseMP3 {
    public static void reverseMp3(String inputFile, String outputFile) throws IOException {
        // Open file channels for reading and writing
        try (FileChannel inputChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            // Allocate a ByteBuffer based on file size
            long fileSize = inputChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);

            // Read the file into the buffer
            inputChannel.read(buffer);
            buffer.flip();  // Prepare buffer for reading

            // Reverse the buffer
            byte[] bytes = buffer.array();
            for (int i = 0; i < bytes.length / 2; i++) {
                byte temp = bytes[i];
                bytes[i] = bytes[bytes.length - 1 - i];
                bytes[bytes.length - 1 - i] = temp;
            }

            // Write the reversed bytes to the output file
            outputChannel.write(ByteBuffer.wrap(bytes));
        }
    }

    public static void main(String[] args) throws IOException {
        String inputMp3 = "original.mp3";
        String outputMp3 = "reversed.mp3";

        reverseMp3(inputMp3, outputMp3);
        System.out.println("Reversed MP3 saved as: " + outputMp3);
    }
}
