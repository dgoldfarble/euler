package com.euler;

import java.io.File;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class problem27 {

    public static void main(String[] args) {
        new problem27();
    }

    public problem27() {
        int a;
        int b;
        int run;
        int saved_a = 0;
        int saved_b = 0;
        int longest_run = 0;
        System.out.println("Building Prime array...");
        int [] prime_array = build_prime_array(750*750);
        //System.out.println(Arrays.toString(prime_array));
        System.out.println("Done");
        System.out.println(calc_run(1,41,prime_array));
        //System.out.println(calc_run(0,19,prime_array));
        //System.out.println(calc_run(-79,1601,prime_array));
        for (a = -1000; a < 1000; a++) {
            //System.out.println("a=" + a);
            for (b = -1000; b < 1000; b++) {
                //System.out.println("b=" + b);
                run = calc_run(a, b, prime_array);
                if (run > longest_run) {
                    longest_run = run;
                    saved_a = a;
                    saved_b = b;
                    System.out.format("n*n + %d*n + %d produces a run of %d primes, a*b=%d\n", a, b, run, a*b);
                }
            }
        }
        System.out.println(saved_a*saved_b + " a: " + saved_a + " b: " + saved_b);
    }

    public int calc_run(int a, int b, int[] prime_array) {
   //     System.out.format("n*n + %d*n + %d\n", a, b);
        int n = 0;
        while (isprime(n*n + a*n + b, prime_array)) {
 //           System.out.format("%d\n", n*n + n*a + b);
            n++;
        }
        return n;
    }

    public boolean isprime(int number, int[] prime_array) {
        int i = 0;
        if (number < 0) {
            return false;
        }
        boolean temp = true;
        while (prime_array[i]*prime_array[i] <= number) {
            if (number % prime_array[i] == 0)
                temp = false;
            i++;
        }
        return temp;
    }

    public int[] build_prime_array(int max) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(5));
        int i = 7;
        while (i < max) {
            if (isprime(i, convertIntegers(list))) {
                list.add(new Integer(i));
                //System.out.println(i);
            }
            i = i + 2;
        }
        return convertIntegers(list);
    }

    public int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}