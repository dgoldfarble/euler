'''
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
'''

import os,sys
import csv


def main(args):
    maximum = int(args[0])
    result = [0, 0, 0] # consecutive primes, sum prime

    primes = []
    for prime in generatePrimes(maximum):
        primes.append(prime)

    for index in range(len(primes)):
        consecutive = 1
        sum = primes[index]
        for prime in primes[index + 1:]:
            sum += prime
            consecutive += 1
            if sum > maximum:
                break
            elif sum in primes:
                if consecutive > result[0]:
                    result = [consecutive, primes[index], sum]
                    print result



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