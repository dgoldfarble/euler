package com.euler;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/6/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class problem35 {
    public static void main(String[] args) {
        new problem35();
        Prime new_prime = new Prime();
        char[] chars;
        System.out.println("Building prime array, this may take a minute...");
        int[] prime_array = new_prime.build_prime_array(1000000);
        System.out.println("Done building array");

        int num_circular = 0;

        for (Integer i : prime_array) {
            chars = ("" + i).toCharArray();
            boolean circular = true;
            for(int j = 0; j < chars.length; j++) {
                chars = rotate(chars);
                if (!new_prime.isprime(Integer.valueOf(new String(chars)), prime_array)) {
                    circular = false;
                }
            }
            if (circular) {
                num_circular++;
                //System.out.println(i);
            }
        }
        System.out.println(num_circular);
    }

    public problem35() {

    }

    public static char[] rotate(char[] input) {
        int length = input.length;
        char first = input[0];
        char[] ret = new char[length];
        for(int i = 0; i < length-1; i++) {
            ret[i] = input[i+1];
        }
        ret[length-1] = first;
        return ret;
    }
}
