package com.euler;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/4/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class problem32 {
    public static List<Integer> pandigital = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) {
        new problem32();
    }

    public problem32(){
        Set<Integer> set_of_pandigital = new HashSet<Integer>();
        for (int i = 1; i < 100000; i++) {
            int j = 1;
            while(Integer.toString(i).length() + Integer.toString(j).length() + Integer.toString(i*j).length() < 10) {
                j++;
                if (isPanDigital(extract_digits(i), extract_digits(j), extract_digits(i*j))) {
                    set_of_pandigital.add(i*j);
                }
            }
        }
        System.out.println(set_of_pandigital.size());
        int sum = 0;
        for (Integer LOL : set_of_pandigital) {
            sum = sum + LOL;
        }
        System.out.println(sum);
    }

    public Boolean isPanDigital(List<Integer> m1, List<Integer> m2, List<Integer> m3) {
        List<Integer> newlist = new ArrayList<Integer>();
        newlist.addAll(m1);
        newlist.addAll(m2);
        newlist.addAll(m3);
        Collections.sort(newlist);
        return newlist.equals(pandigital);
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
}
