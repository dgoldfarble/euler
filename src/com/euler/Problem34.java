package com.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/4/13
 * Time: 8:42 PM
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem34 {
    public static void main(String[] args) {
        new Problem34(1000000);

    }

    public Problem34(int max){
        System.out.println(extract_digits(145));
        System.out.println(factorial(5));
        System.out.println(factorial(4));
        int sum = 0;
        for (int i = 3; i < max; i++) {
            if (i == sumOfFactorial(extract_digits(i))) {
                sum = sum + i;
                System.out.println(i);
            }
        }
        System.out.println(sum);
    }

    public List<Integer> extract_digits(int num){
        List<Integer> digits = new ArrayList<Integer>();
        int remainder = num;
        while(remainder > 0) {
            digits.add(remainder % 10);
            remainder = remainder/10;
        }
        return digits;
    }

    public int sumOfFactorial(List<Integer> digits) {
        int sum = 0;
        for (Integer x : digits) {
            sum = sum + factorial(x);
        }
        return sum;
    }

    public int factorial(int n) {
        int result = 1;
        for (int i = 2; i < n+1; i++) {
            result = result*i;
        }
        return result;
    }
}
