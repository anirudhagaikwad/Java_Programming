public class ThreadSynchronizationExample {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        
        Thread thread1 = new Thread(new WriterTask(sharedData));
        Thread thread2 = new Thread(new ReaderTask(sharedData));
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SharedData {
    private boolean dataWritten;
    
    public synchronized void writeData() {
        while (dataWritten) {
            try {
                wait(); // Wait until data is read by the reader
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Writing data...");
        // Simulate data writing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        dataWritten = true;
        notify(); // Notify the reader that data is available
    }
    
    public synchronized void readData() {
        while (!dataWritten) {
            try {
                wait(); // Wait until data is written by the writer
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Reading data...");
        // Simulate data reading
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        dataWritten = false;
        notify(); // Notify the writer that data has been read
    }
}

class WriterTask implements Runnable {
    private SharedData sharedData;
    
    public WriterTask(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedData.writeData();
        }
    }
}

class ReaderTask implements Runnable {
    private SharedData sharedData;
    
    public ReaderTask(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedData.readData();
        }
    }
}

/*
In this example, we have a SharedData class that represents a shared data structure. The writeData() method is used by the writer thread to write data, and the readData() method is used by the reader thread to read data. Both methods are marked as synchronized.

The writer thread waits until the data is read by the reader before writing new data. It uses a while loop with the wait() method to wait until the dataWritten flag is false. Once it's safe to write data, it proceeds to write the data, sets the dataWritten flag to true, and notifies the reader thread using the notify() method.

Similarly, the reader thread waits until the data is written by the writer before reading the data. It uses a while loop with the wait() method to wait until the dataWritten flag is true. Once it's safe to read data, it proceeds to read the data, sets the dataWritten flag to false, and notifies the writer thread using the notify() method.

The synchronization ensures that the writer and reader threads take turns in accessing and modifying the shared data, preventing conflicts and ensuring proper coordination.

The output of the program will show the interleaved execution of the writer and reader threads
*/
