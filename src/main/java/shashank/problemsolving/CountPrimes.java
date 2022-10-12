package shashank.problemsolving;

import java.util.Arrays;

public class CountPrimes {

    // leetcode 204
    // This algo is also called Sieve of erathosthenes - return all the primes less than n

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        if (n <= 2) return 1;
        boolean prime[] = new boolean[n];

        Arrays.fill(prime, true);

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i; j * i < n; j++) {
                    prime[j * i] = false;
                }
            }
        }
        int result = 0;
        for(int i = 2; i < n; i++) {
            if(prime[i])
                result++;
        }
        return result;
    }


}
