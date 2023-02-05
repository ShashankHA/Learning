package shashank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayGround {
    public static void main(String[] args) {
         List<Integer> numbers = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                numbers.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                numbers.add(i);
            }
        });

        thread1.start();
        thread2.start();

    }
}
