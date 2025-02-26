package examples.clientserver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.net.InetSocketAddress;

public class FileClient {
    private static final String FILE_TO_SEND = "E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\output.txt";
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
             FileChannel fileChannel = FileChannel.open(Paths.get(FILE_TO_SEND), StandardOpenOption.READ)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }

            System.out.println("File sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

