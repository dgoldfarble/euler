package com.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/1/13
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class problem30 {
    public static void main(String[] args) {
        new problem30(1000000);
    }

    public problem30(int max){
        int sum = 0;
        for(int i = 2; i < max; i++) {
            if(i == sum_of_powers(5, extract_digits(i))) {
                System.out.println(i + extract_digits(i).toString());
                sum = sum + i;
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

    public int sum_of_powers(int pow, List<Integer> digits) {
        int sum = 0;
        for(Integer x : digits) {
            sum = sum + (int)Math.pow((double)x, (double)pow);
        }
        return sum;
    }
}