package shashank.corejava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class threadsync {
    // https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/

    int count = 0;

    void increment() {
        count = count + 1;
    }

    synchronized void incrementSync() {
        count = count + 1;
    }

    public static void main(String[] args) {
        // new threadsync().problem();
        new threadsync().syncProblemSolution();
    }

    public void problem() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::increment));

        stop(executor);
        System.out.println(count);  // 9965 - this should have been 10000, but because of sync problem it will not show 10000
    }


    public void syncProblemSolution() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::incrementSync));

        stop(executor);

        System.out.println(count);  // 10000
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


}
