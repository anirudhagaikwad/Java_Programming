package examples;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class NIOExample3 {
    public static void main(String[] args) {
        try {
            // Test Encrypted File Transfer
        	NIOFileOperations.encryptDecryptFile("original.bin", "encrypted.bin", (byte) 0x5A);
        	NIOFileOperations.encryptDecryptFile("encrypted.bin", "decrypted.bin", (byte) 0x5A);

            // Test Merging Large Files
        	NIOFileOperations.mergeFiles("merged.bin", "file1.bin", "file2.bin", "file3.bin");

            // Test Custom Serialization
        	NIOFileOperations.serialize("data.bin", "Anirudha Gaikwad", 30, 55000.50);
        	NIOFileOperations.deserialize("data.bin");

            // Test Byte-Level File Compression
        	NIOFileOperations.compress("input.bin", "compressed.bin");
        	NIOFileOperations.decompress("compressed.bin", "decompressed.bin");

            // Test Partial File Read & Write
        	NIOFileOperations.readAndWriteRange("large.bin", "partial.bin", 1024, 4096);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



class NIOFileOperations {

    /**
     * Encrypted File Transfer: 
     * Reads a binary file, encrypts its content using XOR cipher, 
     * and writes it to another file. This method can also decrypt.
     */
    public static void encryptDecryptFile(String inputFile, String outputFile, byte xorKey) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(8192);
            while (inChannel.read(buffer) > 0) {
                buffer.flip();
                for (int i = 0; i < buffer.limit(); i++) {
                    buffer.put(i, (byte) (buffer.get(i) ^ xorKey)); // XOR encryption/decryption
                }
                outChannel.write(buffer);
                buffer.clear();
            }
        }
    }

    /**
     * Merging Large Binary Files:
     * Merges multiple large binary files into a single file efficiently.
     */
    public static void mergeFiles(String outputFile, String... inputFiles) throws IOException {
        try (FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(8192);

            for (String inputFile : inputFiles) {
                try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ)) {
                    while (inChannel.read(buffer) > 0) {
                        buffer.flip();
                        outChannel.write(buffer);
                        buffer.clear();
                    }
                }
            }
        }
    }

    /**
     * Custom Serialization:
     * Saves and retrieves an object's data using FileChannel instead of ObjectOutputStream.
     */
    public static void serialize(String outputFile, String name, int age, double salary) throws IOException {
        try (FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(128);
            buffer.putInt(name.length());
            buffer.put(name.getBytes());
            buffer.putInt(age);
            buffer.putDouble(salary);
            buffer.flip();
            outChannel.write(buffer);
        }
    }

    public static void deserialize(String inputFile) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(128);
            inChannel.read(buffer);
            buffer.flip();

            int nameLength = buffer.getInt();
            byte[] nameBytes = new byte[nameLength];
            buffer.get(nameBytes);
            String name = new String(nameBytes);

            int age = buffer.getInt();
            double salary = buffer.getDouble();

            System.out.println("Deserialized: " + name + ", Age: " + age + ", Salary: " + salary);
        }
    }

    /**
     * Byte-Level File Compression (Run-Length Encoding - RLE):
     * Compresses and decompresses a file using basic RLE.
     */
    public static void compress(String inputFile, String outputFile) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(8192);
            inChannel.read(buffer);
            buffer.flip();

            ByteBuffer compressed = ByteBuffer.allocate(8192);
            byte prev = buffer.get();
            int count = 1;

            while (buffer.hasRemaining()) {
                byte curr = buffer.get();
                if (curr == prev && count < 255) {
                    count++;
                } else {
                    compressed.put((byte) count);
                    compressed.put(prev);
                    prev = curr;
                    count = 1;
                }
            }
            compressed.put((byte) count);
            compressed.put(prev);
            compressed.flip();
            outChannel.write(compressed);
        }
    }

    public static void decompress(String inputFile, String outputFile) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(8192);
            inChannel.read(buffer);
            buffer.flip();

            ByteBuffer decompressed = ByteBuffer.allocate(8192);
            while (buffer.hasRemaining()) {
                int count = buffer.get() & 0xFF;
                byte value = buffer.get();
                for (int i = 0; i < count; i++) {
                    decompressed.put(value);
                }
            }
            decompressed.flip();
            outChannel.write(decompressed);
        }
    }

    /**
     * Partial File Read & Write:
     * Reads a specific byte range from a file and writes it to another file.
     */
    public static void readAndWriteRange(String inputFile, String outputFile, long start, long end) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(inputFile), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            inChannel.position(start);
            long size = Math.min(end - start, inChannel.size() - start);

            ByteBuffer buffer = ByteBuffer.allocate((int) size);
            inChannel.read(buffer);
            buffer.flip();
            outChannel.write(buffer);
        }
    }

}
