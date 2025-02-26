package examples.clientserver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.Iterator;
import java.util.Set;

public class FileServer {
    private static final int PORT = 5000;
    private static final String OUTPUT_FILE = "received_file.txt";

    public static void main(String[] args) {
        try (Selector selector = Selector.open();
             ServerSocketChannel serverChannel = ServerSocketChannel.open()) {

            serverChannel.bind(new java.net.InetSocketAddress(PORT));
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server started. Waiting for connections...");

            while (true) {
                selector.select(); // Wait for events
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {  // Accept new client
                        SocketChannel clientChannel = serverChannel.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("Client connected: " + clientChannel.getRemoteAddress());
                    } 
                    else if (key.isReadable()) {  // Read file data
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        FileChannel fileChannel = FileChannel.open(Paths.get(OUTPUT_FILE),
                                StandardOpenOption.CREATE, StandardOpenOption.WRITE);

                        while (clientChannel.read(buffer) > 0) {
                            buffer.flip();
                            fileChannel.write(buffer);
                            buffer.clear();
                        }

                        System.out.println("File received successfully.");
                        fileChannel.close();
                        clientChannel.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*

How It Works:
Run FileServer.java first → It waits for client connections.
Run FileClient.java → It sends testfile.txt to the server.
The server receives and saves the file as received_file.txt.
This demonstrates:

Buffers for handling data in chunks.
Channels (FileChannel, SocketChannel) for file and network communication.
Selector for handling multiple clients asynchronously.

*/