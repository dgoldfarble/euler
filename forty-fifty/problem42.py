# -*- coding: utf-8 -*-
'''
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
'''

import csv
import os
import sys

def main(arguments):
    sum = 0
    triangle = [1]
    with open('p042_words.txt') as csvFile:
        wordReader = csv.reader(csvFile, delimiter=',')
        for word in wordReader.next():
            num = word2Value(word)
            while (num > triangle[-1]):
                triangle.append(t(len(triangle) + 1))
            if num in triangle:
                sum = sum + 1
    print(sum)

def t(n):
    return n * (n + 1) / 2

def word2Value(word):
    result = 0
    word = word.lower()
    for letter in word:
        result = result + ord(letter) - 96
    return result

if __name__ == '__main__':
    sys.exit(main(sys.argv[1:]))
