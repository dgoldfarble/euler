package com.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/6/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Prime {
    public Prime(){

    }

    public boolean isprime(int number, int[] prime_array) {
        int i = 0;
        if (number < 0) {
            return false;
        }
        /*if (number == 1) {
            return false;
        } */
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
