package com.euler;

import java.util.*;
import java.lang.Math;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 9/27/13
 * Time: 9:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Problem29 {
    public static void main(String[] args) {
        new Problem29();
    }

    public Problem29(){
        Set<Double> list = new HashSet<Double>();
        List<Integer> list1 = new ArrayList<Integer>();
        int counter = 0;
        int ismember = 0;
        int notmember = 0;
        int i, j;
        double power;
        for(i = 2; i <= 100; i++) {
            for(j = 2; j <= 100; j++) {
                power = Math.pow((double)i, (double)j);
                if(!list.contains(power)) { list.add(power); notmember++; }
                else { System.out.println(power + " already a member"); ismember++; }
                counter++;
            }
        }
        System.out.println("Final: " + list.size());
        /* for(int iter : list)
        {
            list1.add(iter);
        }
        Collections.sort(list1); */
        System.out.println("Added: " + notmember + " duplicate: " + ismember + " Total: " + counter);
        /*for(int iter : list1)
        {
            System.out.println(iter);
        } */
    }
}
