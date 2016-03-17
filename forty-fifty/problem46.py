# -*- coding: utf-8 -*-
'''
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
'''


import os
import sys
import csv
import argparse
from sets import Set

def main(arguments):

    parser = argparse.ArgumentParser()
    parser.add_argument('maximumValue', help="Pick a number that is a safe upper bound for this problem", type = int)
    args = parser.parse_args(arguments)
    testMaxValue = args.maximumValue

    composites = Set()
    for i in range(3, testMaxValue, 2):
        composites.add(i)
    primes = Set()
    for i in generatePrimes(testMaxValue):
        primes.add(i)
    for i in primes:
        composites.discard(i)
    print("Composite set created")
    # so we should have a composites set now
    for i in primes:
        for j in range(testMaxValue):
            candidate = i + 2 * j * j
            if (candidate > testMaxValue):
                break
            else:
                composites.discard(candidate)
    print("Composite set decimated")
    composites = list(composites)
    composites.sort()
    print("composite set sorted")
    print(composites[0])



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
