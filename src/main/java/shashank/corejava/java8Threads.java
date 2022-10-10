package shashank.corejava;

import java.util.concurrent.*;

public class java8Threads {
    public static void main(String[] args) {
       // threadBasic();
       // executorService();
       // executorService2();
    }

    public static void threadBasic() {
        /**
         * O/P :
         * Foo Thread-1
         * Foo Thread-0
         * Bar Thread-1
         * Bar Thread-0
         */
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();
    }

    public static void executorService() {
        /**
         * Executor service provides a replacement for working with threads directly.
         * Executors are capable of running asynchronous tasks and typically manage a pool of threads,
         * so we don’t have to create new threads manually
         * O/P :
         * Hello pool-1-thread-1
         */

        ExecutorService executor = Executors.newFixedThreadPool(10);
        // Submit a Runnable task for execution
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        executor.shutdown();  // executorservice must be shutdown, otherwise the program wont stop;

    }

    public static void executorService2() {
        /**
         * O/P :
         * Task 0 is being executed by thread pool-1-thread-1
         * Task 3 is being executed by thread pool-1-thread-4
         * Task 1 is being executed by thread pool-1-thread-2
         * Task 4 is being executed by thread pool-1-thread-5
         * Task 2 is being executed by thread pool-1-thread-3
         * Task 3 is finished now by pool-1-thread-4
         * Task 0 is finished now by pool-1-thread-1
         * Task 1 is finished now by pool-1-thread-2
         * Task 4 is finished now by pool-1-thread-5
         * Task 5 is being executed by thread pool-1-thread-4
         * Task 2 is finished now by pool-1-thread-3
         * Task 9 is being executed by thread pool-1-thread-3
         * Task 8 is being executed by thread pool-1-thread-5
         * Task 7 is being executed by thread pool-1-thread-2
         * Task 6 is being executed by thread pool-1-thread-1
         * Task 9 is finished now by pool-1-thread-3
         * Task 6 is finished now by pool-1-thread-1
         * Task 5 is finished now by pool-1-thread-4
         * Task 8 is finished now by pool-1-thread-5
         * Task 7 is finished now by pool-1-thread-2
         */

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++) {
            int taskId = i;
            Runnable runnable = () -> {
                System.out.println("Task "+ taskId + " is being executed by thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task "+ taskId + " is finished now by " + Thread.currentThread().getName());
            };
            executor.execute(runnable); // waits for all tasks to finish and shuts down th executor service
        }
        executor.shutdown();
    }

    public static void callables() throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();   // this blocks the current thread until the execution of executor service is complete

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);
    }


}
