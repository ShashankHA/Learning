package shashank.corejava;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {

        /**
         * public interface Predicate<T> {
         *    boolean test(T t);
         * }
         */

        Predicate<String> p = s -> s == "shashank";    // predicate to check whether a string is equal to "shashank"
        System.out.println(p.test("shashank"));  // true
        System.out.println(p.and(s -> s.length() > 5).test("shashank"));  // true


        /**
         *   public interface Function<T, R> {
         *             R apply(T t);
         *   }
         */

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));  // 123

        /**
         * public interface Supplier<T> {
         *  T get();
         * }
         */
        Supplier<String> supplier = () -> new String("Shashank");
        System.out.println(supplier.get());  // prints shashank


        /**
         * public interface Consumer<T> {
         *     void accept(T t);
         * }
         */

        Consumer<String> greeter = s -> System.out.println("Hello, " + s);
        greeter.accept("shashank");  // prints Hello shashank
    }

}
