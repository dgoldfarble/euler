'''
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
'''


import os, sys
from itertools import permutations
import csv

def main():

    fourDigitPrimes = []
    for prime in generatePrimes(9999):
        if (prime > 1000):
            fourDigitPrimes.append(prime)

    for prime in fourDigitPrimes:
        if prime > 3333:
            break

        for i in range(1, 3333):
            if prime + i in fourDigitPrimes:
                if prime + 2 * i in fourDigitPrimes:
                    if testPermutation(prime, i):
                        print str(prime) + " " + str(prime + i) + " " + str(prime + 2 * i)


def testPermutation(prime, i):
    perms = [''.join(p) for p in permutations(str(prime))]
    if (str(prime + i) in perms) and (str(prime + 2 * i) in perms):
        return True
    return False


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
    sys.exit(main())
