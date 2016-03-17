# -*- coding: utf-8 -*-
'''
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
'''

import sys
import os
import csv

def main(arguments):
    primes = []
    for i in generatePrimes(1000000):
        primes.append(i)
    found = False
    i = 0
    while (found is False):
        i += 1
        array = [i, i + 1, i + 2, i + 3]
        factorSet = set()
        for j in array:
            jfactors = uniquePrimeFactors(j, primes)
            if (len(jfactors) != 4):
                break
            else:
                for prime in jfactors:
                    factorSet.add(pow(prime, jfactors[prime]))
        if len(factorSet) == 16:
            print(i)
            return



def uniquePrimeFactors(i, primeArray):
    factors = {}
    for prime in primeArray:
        if (prime > i / 2):
            break
        elif i % prime == 0:
            count = 1
            dupNumber = i / prime
            while (dupNumber % prime == 0):
                count += 1
                dupNumber = dupNumber / prime
            factors[prime] = count
    return factors



def generatePrimes(maximum):
    fileList = [['2T_part1.txt', 2, 179424673],
        ['2T_part2.txt', 179424691, 373587883],
        ['2T_part3.txt', 373587911, 573259391],
        ['2T_part4.txt', 573259433, 776531401],
        ['2T_part5.txt', 776531419, 982451653],
        ['2T_part6.txt', 982451707, 1190494759]]
    for file, minValue, maxValue in fileList:
        if (minValue > maximum):
            return
        else:
            with open(os.path.join('primes', file)) as csvfile:
                primeReader = csv.reader(csvfile, delimiter = '\t')
                for row in primeReader:
                    for prime in row:
                        prime = int(prime)
                        if prime <= maximum:
                            yield prime
                        else:
                            return



if __name__ == '__main__':
    sys.exit(main(sys.argv[1:]))