package com.euler;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/4/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 * The Fraction 49/98 is a curious Fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * There are exactly four non-trivial examples of this type of Fraction, less than one in value, and containing two digits in the numerator and denominator.
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class problem33 {
    public static void main(String[] args) {
        new problem33();

        Fraction fract;
        Fraction fract1;
        Fraction fract2;
        boolean equalfracts;
        boolean equal2;
        Fraction multiplicant = new Fraction(1,1);
        for(int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                fract = new Fraction(i, j);
                fract1 = fract.fake_simplify();
                fract2 = fract.simplify();
                equalfracts = fract.equals(fract1);
                equal2 = fract1.simplify().equals(fract2);
                if (!equalfracts && equal2) {
                    System.out.println(fract.toString() + ": \t" + fract1.toString() + " == " + fract2.toString());
                    multiplicant = multiplicant.times(fract);
                }
            }
        }
        System.out.println(multiplicant.simplify().toString());
    }

    public problem33() {
    }

}
