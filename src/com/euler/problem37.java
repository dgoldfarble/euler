package com.euler;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/6/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem37 {
    public static void main(String[] args) {
        new Problem37();
        Prime new_prime = new Prime();
        File file = new File("/Users/dgoldfarb/work/euler/primes1.txt");


        //System.out.println("Truncatable: " + truncatable(3797, prime_array));

        int sum = 0;
        /*for (Integer i : prime_array) {
            if (truncatable(i, prime_array)) {
                System.out.println(i);
                sum = sum + i;
            }
        } */
        System.out.println((sum - (2 + 3 + 5 + 7)));
    }

    public Problem37() {

    }

    public static boolean truncatable(int i, int[] primes) {
        boolean a = right_truncatable(i, primes);
        String x = new StringBuilder(Integer.toString(i)).reverse().toString();
        boolean b = right_truncatable(Integer.valueOf(x), primes);
        return (a && b);
    }

    public static boolean right_truncatable(int i, int[] primes) {
        Prime newprime = new Prime();
        boolean still_prime = true;
        int n = i;
        while (n > 0) {
            n = n/10;
            if (!newprime.isprime(n, primes)) still_prime = false;
        }
        return still_prime;
    }
}
