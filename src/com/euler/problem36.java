package com.euler;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/6/13
 * Time: 6:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class problem36 {
    public static void main(String[] args) {
        new problem36();
    }

    public problem36(){
        int sum = 0;
        String baseten;
        String basetwo;
        String basetenrev;
        String basetworev;
        for (int i = 1; i < 1000000; i++) {
            baseten = new String(Integer.toString(i));
            basetwo = new String(Integer.toBinaryString(i));
            basetenrev = new StringBuilder(baseten).reverse().toString();
            basetworev = new StringBuilder(basetwo).reverse().toString();
            if (baseten.equals(basetenrev) && basetwo.equals(basetworev)) {
                System.out.println(baseten + " " + basetwo);
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}
