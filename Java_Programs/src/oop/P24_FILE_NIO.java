package oop;
/*
## 1. What is Java NIO?  
Java NIO (New Input/Output) is an alternative I/O API introduced in Java 1.4 under the `java.nio` package. 
It provides a non-blocking, buffer-oriented, and more efficient way to perform input and output operations 
compared to traditional Java IO (`java.io`).  

### Key Features of Java NIO
- Non-blocking (Asynchronous) I/O – Allows processing multiple channels in a single thread.
- Buffers Instead of Streams – Data is read and written using buffers instead of streams.
- Selectors – Allows monitoring multiple channels for events (like read, write) using a single thread.
- Direct Memory Access – Uses memory-mapped files for faster data transfer.
- Efficient File and Network Handling – Improves performance for large data processing.

---

## 2. Components of Java NIO
Java NIO is built around three core components:
| Component | Description |
|-------------|----------------|
| Buffer | Stores data in memory for reading and writing operations. |
| Channel | A bidirectional data transfer mechanism between a buffer and an entity (file, socket, etc.). |
| Selector | Monitors multiple channels and determines which ones are ready for I/O operations. |

---
### Tree Diagram 
java.nio
│
├── Interface
│   ├── ByteOrder
│
├── Abstract Classes (Extend Buffer)
│   ├── Buffer (Root Abstract Class)
│   │   ├── ByteBuffer (extends Buffer)
│   │   ├── CharBuffer (extends Buffer)
│   │   ├── DoubleBuffer (extends Buffer)
│   │   ├── FloatBuffer (extends Buffer)
│   │   ├── IntBuffer (extends Buffer)
│   │   ├── LongBuffer (extends Buffer)
│   │   ├── ShortBuffer (extends Buffer)
│   │   ├── MappedByteBuffer (extends ByteBuffer)
│
├── Concrete Classes (Extends Buffers)
│   ├── HeapByteBuffer (extends ByteBuffer)
│   ├── DirectByteBuffer (extends ByteBuffer)
│   ├── HeapCharBuffer (extends CharBuffer)
│   ├── DirectCharBuffer (extends CharBuffer)
│   ├── HeapDoubleBuffer (extends DoubleBuffer)
│   ├── DirectDoubleBuffer (extends DoubleBuffer)
│   ├── HeapFloatBuffer (extends FloatBuffer)
│   ├── DirectFloatBuffer (extends FloatBuffer)
│   ├── HeapIntBuffer (extends IntBuffer)
│   ├── DirectIntBuffer (extends IntBuffer)
│   ├── HeapLongBuffer (extends LongBuffer)
│   ├── DirectLongBuffer (extends LongBuffer)
│   ├── HeapShortBuffer (extends ShortBuffer)
│   ├── DirectShortBuffer (extends ShortBuffer)
│
├── Exception Classes (Extends RuntimeException)
│   ├── BufferOverflowException
│   ├── BufferUnderflowException
│   ├── InvalidMarkException
│   ├── ReadOnlyBufferException
│
├── Subpackages
│   ├── java.nio.channels (For non-blocking channels)
│   ├── java.nio.charset (For character encoding)
│   ├── java.nio.file (For file system operations)


---

## 3. Java NIO vs. Java IO (Traditional IO)
| Feature | Java IO (`java.io`) | Java NIO (`java.nio`) |
|---------|----------------------|----------------------|
| Approach | Stream-oriented | Buffer-oriented |
| Blocking Mode | Always blocking | Supports non-blocking mode |
| Performance | Slower for large data | Faster and efficient for large data |
| Concurrency | Multiple threads needed | Single thread can manage multiple channels |
| Data Handling | Reads byte-by-byte | Reads in bulk using buffers |

---

## 4. Java NIO Buffers
A Buffer is a fixed-size memory block used to read/write data.

### Common Buffer Types in Java NIO
| Buffer Type | Data Type |
|---------------|-------------|
| `ByteBuffer` | Stores bytes (`byte[]`) |
| `CharBuffer` | Stores characters (`char[]`) |
| `IntBuffer` | Stores integers (`int[]`) |
| `LongBuffer` | Stores Long integers (`long[]`) |
| `FloatBuffer` | Stores float numbers (`float[]`) |
| `DoubleBuffer` | Stores double numbers (`double[]`) |
| `ShortBuffer` | Stores short numbers (`short[]`) |

### Buffer Key Methods
| Method | Description |
|------------|---------------|
| `allocate(int capacity)` | Creates a new buffer of given size |
| `put(data)` | Writes data into the buffer |
| `flip()` | Prepares buffer for reading |
| `get()` | Reads data from buffer |
| `clear()` | Clears buffer for new writing |
| `rewind()` | Resets position to re-read data |
| `remaining()` | Returns remaining unread data size |

---

## 5. Java NIO Channels
A Channel is a medium for reading/writing data between a Buffer and an entity (e.g., file, socket).

### Common Channel Types in Java NIO
| Channel Type | Description |
|---------------|----------------|
| `FileChannel` | Reads/writes files |
| `SocketChannel` | Reads/writes TCP sockets |
| `ServerSocketChannel` | Listens for incoming TCP connections |
| `DatagramChannel` | Handles UDP-based connections |

### Key Channel Methods
| Method | Description |
|------------|---------------|
| `open()` | Opens a new channel |
| `read(ByteBuffer buffer)` | Reads data from channel into buffer |
| `write(ByteBuffer buffer)` | Writes data from buffer into channel |
| `close()` | Closes the channel |
| `isOpen()` | Checks if the channel is open |

---

## 6. Java NIO Selectors (For Multiplexing)
A Selector is used for managing multiple channels using a single thread, improving performance in network communication.

### Key Methods of Selector
| Method | Description |
|------------|---------------|
| `open()` | Creates a new selector |
| `select()` | Blocks until at least one channel is ready |
| `selectNow()` | Non-blocking, returns immediately if no channel is ready |
| `keys()` | Returns registered channels |
| `selectedKeys()` | Returns channels that are ready for I/O |

### Use Case of Selector
Selectors are commonly used in server-side applications like chat servers or network-based applications.

---

## 7. Memory-Mapped Files in Java NIO
Java NIO allows fast file reading/writing by mapping a file directly into memory.

### Why Use Memory-Mapped Files?
- Faster performance compared to `FileInputStream`/`FileOutputStream`.
- Direct interaction with OS without intermediate buffering.

### Key Methods
| Method | Description |
|------------|---------------|
| `map(FileChannel.MapMode mode, long position, long size)` | Maps a file into memory |
| `load()` | Loads the file into memory |
| `isLoaded()` | Checks if file is fully loaded into memory |

---

## 8. Java NIO File Handling (`java.nio.file`)
Java 7 introduced NIO.2 (`java.nio.file` package) to simplify file handling.

### Key Classes in `java.nio.file`
| Class | Description |
|----------|---------------|
| `Files` | Utility class for file operations |
| `Path` | Represents a file/directory path |
| `Paths` | Helps in creating `Path` objects |
| `StandardOpenOption` | Defines file open modes |

### Key File Handling Methods
| Method | Description |
|------------|---------------|
| `Files.readAllBytes(Path path)` | Reads file as byte array |
| `Files.write(Path path, byte[] data)` | Writes byte array to file |
| `Files.exists(Path path)` | Checks if file exists |
| `Files.createFile(Path path)` | Creates a new file |
| `Files.delete(Path path)` | Deletes a file |

---

## 9. Real-World Use Cases of Java NIO
| Use Case | Why Java NIO? |
|-------------|----------------|
| High-Performance File Handling | Memory-mapped files improve speed |
| Non-Blocking Network Servers | Selectors manage multiple connections in one thread |
| Data Streaming Applications | Buffer-oriented I/O provides efficient data handling |
| Real-Time Data Processing | Reduces latency by using direct buffers |

---

## 10. Conclusion
- Java NIO provides better performance and scalability than traditional `java.io`.
- Uses buffers instead of streams, improving efficiency in large data handling.
- Supports asynchronous and non-blocking operations, useful in network programming.
- Selectors allow handling multiple channels efficiently using a single thread.

🚀 Why Does Java NIO Not Use Byte/Character Streams?
- NIO is Buffer-Oriented, Not Stream-Oriented.
Instead of reading data byte by byte or character by character, NIO loads data into a buffer and processes 
it in chunks.

- NIO Uses Channels Instead of Streams.
A Channel can perform both read and write operations, unlike InputStream (only read) and OutputStream
(only write).

- NIO Supports Non-Blocking I/O.
Unlike Java IO, where operations block until completed, NIO can process multiple connections simultaneously.
 
*/
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import java.nio.charset.StandardCharsets;
import java.util.List;


import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Channels;


public class P24_FILE_NIO {
//User Input using NIO
    // Core method to read input using NIO
    private static String readFromConsole() throws IOException {
        ReadableByteChannel channel = Channels.newChannel(System.in);
        ByteBuffer buffer = ByteBuffer.allocate(256); // 256-byte buffer
        channel.read(buffer);
        buffer.flip();
        return StandardCharsets.UTF_8.decode(buffer).toString();
    }

	    // Read String input
	    public static String readString(String prompt) throws IOException {
	        System.out.print(prompt);
	        return readFromConsole();
	    }

	    // Read Integer input
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

	    // Read Double input
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

//Byte Copy Using Java NIO
	    public static void copyByteNIO() {
	        Path source = Path.of("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\sample.txt");
	        Path destination = Path.of("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\Dest.txt");

	        try (FileChannel inChannel = FileChannel.open(source, StandardOpenOption.READ);
	             FileChannel outChannel = FileChannel.open(destination, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

	            inChannel.transferTo(0, inChannel.size(), outChannel);
	            System.out.println("✅ Byte copy completed successfully using NIO.");
	            for (String line : Files.readAllLines(destination, StandardCharsets.UTF_8)) {
	                System.out.println(line);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

//Character Copy Using Java NIO
	    public static void copyCharactersNIO() {
	        Path source = Path.of("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\sample.txt");
	        Path destination = Path.of("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\dest2.txt");
	        try {
	            String content = Files.readString(source, StandardCharsets.UTF_8);
	            Files.writeString(destination, content, StandardCharsets.UTF_8);
	            System.out.println("✅ Character copy completed successfully using NIO.");
	            for (String line : Files.readAllLines(destination, StandardCharsets.UTF_8)) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

//Line Copy Using Java NIO
	    public static void copyLinesNIO() {
	        Path source = Path.of("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\sample.txt");
	        Path destination = Path.of("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\dest3.txt");
	        try {
	            List<String> lines = Files.readAllLines(source, StandardCharsets.UTF_8);
	            Files.write(destination, lines, StandardCharsets.UTF_8);
	            System.out.println("✅ Line copy completed successfully using NIO.");
	            for (String line : Files.readAllLines(destination, StandardCharsets.UTF_8)) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

// File and Directory Manipulation
	    public static void methodsForManipulateFileDirNIO() {
	        Path path = Paths.get("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\sample.txt");

	        if (Files.exists(path)) {
	            System.out.println("✅ File Exists!");
	            System.out.println("📌 Is Executable: " + Files.isExecutable(path));
	            System.out.println("📌 Is Readable: " + Files.isReadable(path));
	            System.out.println("📌 Is Writable: " + Files.isWritable(path));
	            System.out.println("📌 File Name: " + path.getFileName());
	            System.out.println("📌 Absolute Path: " + path.toAbsolutePath());           
	            try {
	                System.out.println("📌 File Size (Bytes): " + Files.size(path));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	            // Delete the file (uncomment to enable deletion)
	            // try {
	            //     Files.delete(path);
	            //     System.out.println("🚮 File Deleted Successfully!");
	            // } catch (IOException e) {
	            //     e.printStackTrace();
	            // }
	        } else {
	            System.out.println("❌ File does not exist.");
	        }
	    }

	public static void main(String[] args) {
		   System.out.println("=== Enter data Using Java NIO ===");
            try {
		    String name = readString("Enter your name: ");
	        int age = readInt("Enter your age: ");
	        double salary = readDouble("Enter your salary: ");
	        System.out.println("\n=== User Entered Details ===");
	        System.out.println("Name   : " + name);
	        System.out.println("Age    : " + age);
	        System.out.println("Salary : " + salary);
            }catch(IOException e) {e.printStackTrace();}
	       	   	
		methodsForManipulateFileDirNIO();
		copyLinesNIO(); 
		copyCharactersNIO();
		copyByteNIO();
		
       Path filePath1 = Paths.get("sample2.txt");
       writeFile_FILE(filePath1, "Hello, NIO File Handling!");
       readFile_FILE(filePath1);
       copyFile(filePath1, Paths.get("copy_sample.txt"));
            
        Path filePath2 = Paths.get("mapped_file.txt");
        writeMemoryMappedFile(filePath2, "Hello, Memory-Mapped File!");
        readMemoryMappedFile(filePath2);		
        
        sendMessage("localhost", 5000, "Hello, Server!");
        
        Path filePath3 = Paths.get("channel_data.txt");
        writeFile_efficiently(filePath3, "Hello, FileChannel with NIO!");
        readFile_efficiently(filePath3);

	}
	
//This program demonstrates file creation, writing, reading, and copying using methods.
	    private static void writeFile_FILE(Path path, String content) {
	        try {
	            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
	            System.out.println("File written successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void readFile_FILE(Path path) {
	        try {
	            List<String> lines = Files.readAllLines(path);
	            System.out.println("File Content: " + lines);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void copyFile(Path source, Path destination) {
	        try {
	            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("File copied successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

	
//This example uses ByteBuffer and FileChannel to efficiently read and write a file.
	    private static void writeFile_efficiently(Path path, String data) {
	        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
	            ByteBuffer buffer = ByteBuffer.allocate(64);
	            buffer.put(data.getBytes());
	            buffer.flip(); 
	            fileChannel.write(buffer);
	            System.out.println("Data written using FileChannel.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void readFile_efficiently(Path path) {
	        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
	            ByteBuffer buffer = ByteBuffer.allocate(64);
	            fileChannel.read(buffer);
	            buffer.flip();
	            System.out.println("Read from FileChannel: " + new String(buffer.array()).trim());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

//This example sets up a non-blocking TCP client using SocketChannel "python -m http.server 5000"

	    private static void sendMessage(String host, int port, String message) {
	        try {
	            SocketChannel socketChannel = SocketChannel.open();
	            socketChannel.configureBlocking(false); // Non-blocking mode

	            if (!socketChannel.connect(new InetSocketAddress(host, port))) {
	                while (!socketChannel.finishConnect()) {
	                    System.out.println("Connecting to server...");
	                }
	            }

	            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
	            socketChannel.write(buffer);
	            System.out.println("Message sent to server.");
	            socketChannel.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	
	
//Memory-mapped files allow reading and writing files directly from memory, making I/O much faster.
	    private static void writeMemoryMappedFile(Path path, String data) {
	        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
	            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
	            buffer.put(data.getBytes());
	            System.out.println("Data written to memory-mapped file.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void readMemoryMappedFile(Path path) {
	        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
	            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, (int) fileChannel.size());
	            byte[] readData = new byte[buffer.remaining()];
	            buffer.get(readData);
	            System.out.println("Read from memory-mapped file: " + new String(readData));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
}//P24_FILE_NIO





