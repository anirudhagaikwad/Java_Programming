package examples;
/*
📌 Why This is Better Than Thread Class?
✅ Thread Pooling: Prevents creating too many threads, saving system resources
✅ Automatic Thread Management: No need to manually start/join threads
✅ Better Performance: Handles tasks efficiently using Callable and Future
✅ Scalability: Easily change the number of worker threads
✅ Handles Return Values: Callable returns results (unlike Runnable) 
*/

import java.util.concurrent.*;

/*
📌 Real-Time Example: E-Commerce Order Processing
Imagine an E-Commerce System where multiple users place orders simultaneously, and we need to:
1️ Process Payments
2️ Prepare Orders
3️ Dispatch Orders
Each task runs concurrently using ExecutorService (instead of manually managing threads).
 */
class OrderProcessor implements Callable<String> {
    private String orderId;

    public OrderProcessor(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Processing order: " + orderId + " in " + Thread.currentThread().getName());
        Thread.sleep(2000); // Simulate order processing delay
        return "Order " + orderId + " processed successfully!";
    }
}

public class ECommerceSystem_Thread {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Simulating 5 orders
        Future<String> order1 = executor.submit(new OrderProcessor("1001"));
        Future<String> order2 = executor.submit(new OrderProcessor("1002"));
        Future<String> order3 = executor.submit(new OrderProcessor("1003"));
        Future<String> order4 = executor.submit(new OrderProcessor("1004"));
        Future<String> order5 = executor.submit(new OrderProcessor("1005"));

        try {
            // Fetching the results of orders
            System.out.println(order1.get());
            System.out.println(order2.get());
            System.out.println(order3.get());
            System.out.println(order4.get());
            System.out.println(order5.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the executor
        executor.shutdown();
    }
}

