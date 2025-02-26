package examples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

//Read Specific Lines & Write to a New File
public class ReadWriteSpecificLinesNIO {
    public static void main(String[] args) {
        Path inputFile = Paths.get("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\dest2.txt");  // Source file
        Path outputFile = Paths.get("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\output.txt"); // Destination file

        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(inputFile, StandardCharsets.UTF_8);

            // Get the required lines (14, 15, 18) - Remember list index starts from 0
            String line14 = (lines.size() >= 14) ? lines.get(13) : "";
            String line15 = (lines.size() >= 15) ? lines.get(14) : "";
            String line18 = (lines.size() >= 18) ? lines.get(17) : "";

            // Write to a new file
            Files.write(outputFile, List.of(line14, line15, line18), StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Selected lines saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

