package com.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 10/4/13
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int den) {
        if (den == 0) {
            numerator = 0;
            denominator = 1;
        }
        else {
            numerator = num;
            denominator = den;
        }
    }

    public Fraction simplify() {
        int a = gcd(this.numerator, this.denominator);
        return new Fraction(this.numerator/a, this.denominator/a);
    }

    public int gcd(int a, int b) {
        if ( b == 0 ) return a;
        return gcd(b,a%b);
    }

    public Fraction fake_simplify() {
        Integer[] num_dig = extract_digits(this.numerator).toArray(new Integer[2]);
        Integer[] den_dig = extract_digits(this.denominator).toArray(new Integer[2]);
        if (num_dig[0] == den_dig[0] && den_dig[0] != 0) return new Fraction(num_dig[1], den_dig[1]);
        if (num_dig[1] == den_dig[1] && den_dig[1] != 0) return new Fraction(num_dig[0], den_dig[0]);
        if (num_dig[0] == den_dig[1] && den_dig[1] != 0) return new Fraction(num_dig[1], den_dig[0]);
        if (num_dig[1] == den_dig[0] && den_dig[0] != 0) return new Fraction(num_dig[0], den_dig[1]);
        return this;
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

    public String toString() {
        return new String(this.numerator + "/" + this.denominator);
    }

    public Boolean equals(Fraction x) {
        return (this.denominator == x.denominator && this.numerator == x.numerator);
    }

    public Fraction times(Fraction x) {
        return new Fraction(x.numerator*this.numerator, x.denominator*this.denominator);
    }
}
