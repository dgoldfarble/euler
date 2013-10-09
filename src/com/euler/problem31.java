package com.euler;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/1/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class problem31 {
    public static void main(String[] args) {
        new problem31(200);
    }

    public problem31(int max){
        int count = 0;
        for (int i = 0; i < max + 1; i++) {
            if (i == max) { count++; }
            else {
                count = count + tuppence(i, max);
            }
        }
        System.out.println(count + 1);
    }

    public int tuppence(int left, int max) {
        int num_ways = 0;
        for (int i = left; i < max + 1; i = i + 2) {
            if (i == max) { num_ways++; }
            else { num_ways = num_ways + fivep(i, max); }
        }
        return num_ways;
    }

    public int fivep(int left, int max) {
        int num_ways = 0;
        for (int i = left; i < max + 1; i = i + 5) {
            if (i == max) { num_ways++; }
            else { num_ways = num_ways + tenp(i, max); }
        }
        return num_ways;
    }

    public int tenp(int left, int max) {
        int num_ways = 0;
        for (int i = left; i < max + 1; i = i + 10) {
            if (i == max) { num_ways++; }
            else { num_ways = num_ways + twentyp(i, max); }
        }
        return num_ways;
    }

    public int twentyp(int left, int max) {
        int num_ways = 0;
        for (int i = left; i < max + 1; i = i + 20) {
            if (i == max) { num_ways++; }
            else { num_ways = num_ways + fiftyp(i, max); }
        }
        return num_ways;
    }

    public int fiftyp(int left, int max) {
        int num_ways = 0;
        for (int i = left; i < max + 1; i = i + 50) {
            if (i == max) { num_ways++; }
            else { num_ways = num_ways + hundredp(i, max); }
        }
        return num_ways;
    }

    public int hundredp(int left, int max) {
        int num_ways = 0;
        for (int i = left; i < max + 1; i = i + 100) {
            if (i == max) { num_ways++; }
        }
        return num_ways;
    }
}
