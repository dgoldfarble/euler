package com.euler;

/* PROBLEM STATEMENT
Consider a "word" as any sequence of capital letters A-Z (not limited to just "dictionary words"). For any
word with at least two different letters, there are other words composed of the same letters but in a
different order (for instance, STATIONARILY/ANTIROYALIST, which happen to both be dictionary words;
for our purposes "AAIILNORSTTY" is also a "word" composed of the same letters as these two).
We can then assign a number to every word, based on where it falls in an alphabetically sorted list of all
words made up of the same set of letters. One way to do this would be to generate the entire list of
words and find the desired one, but this would be slow if the word is long.
Write a program which takes a word as a command line argument and prints to standard output its
number.
 */

/* SOLUTION

Preamble
    This method depends on being able to quickly count how many permutations of a given string of letters exist.
    For a string of n unique characters, there are n! permutations. For a word W containing an arbitrary number
    of repeated characters, let C = {a, b, c, ...} be the set of unique characters of W, and R = {l, m, n, ...}
    the number of repetitions of C. That is, l is the frequency of occurrence of a, m is the frequency of
    occurence of b, etc. Then the number of permutations of W is
      (l + m + n + ...)! / (l! * m! * n! * ...)

Iterative Method
    Consider "AAIILNORSTTY". How many permutations start with "A"? Exactly the number of permutations of the subword
    "AIILNORSTTY". Therefore the first permutation that starts with "I" can be found by calculating the permutations
    of "AIILNORSTTY" + 1. Likewise, the first permutation that starts with "L" can be found by calculating how many
    permutations start with "I" and adding that to the first result.

A Real Example
    We want to calculate the alphabetical position of STATIONARILY
    The 'cost' of having S as a first letter:
    A + AIILNORSTTY = 11! / (2! * 2!) = 9979200
    I + AAILNORSTTY = 11! / (2! * 2!) = 9979200
    L + AAIINORSTTY = 11! / (2! * 2! * 2!) = 4989600
    N + AAIILORSTTY = 11! / (2! * 2! * 2!) = 4989600
    O + AAIILNRSTTY = 11! / (2! * 2! * 2!) = 4989600
    R + AAIILNOSTTY = 11! / (2! * 2! * 2!) = 4989600

    Plus the cost of having T as the second letter:
    A + AIILNORTTY = 10! / (2! * 2!)
    I + AAILNORTTY = 10! / (2! * 2!)
    L + AAIINORTTY = 10! / (2! * 2! * 2!)
    N + AAIILORTTY =
    O + AAIILNRTTY =
    R + AAIILNOTTY =

    Plus the cost of having A as the third letter, etc.

Example Results
ABAB = 2
AAAB = 1
BAAA = 4
QUESTION = 24572
BOOKKEEPER = 10743
NONINTUITIVENESS = 8,222,334,634
EEIIINNNNOSSTTUV = 1
*/

import java.util.Arrays;

public class PermutationsOfWords {
    public static void main(String[] args) {

        // debugging shows iterations and calculations
        boolean debug = false;
        if (args.length > 1 && args[1].equals("-debug")) {
            debug = true;
        }

        if (debug) {
            System.out.println("TEST METHODS");

            // test quicksort
            char[] testSort = new char[]{'S','T','A','T','I','O','N','A','R','I','L','Y'};
            System.out.print(new String(testSort) + " sorted -> ");
            quicksort(testSort, 0, testSort.length);
            System.out.println(testSort);

            // test frequency count
            int[] freqCount = countCharacters(testSort);
            System.out.println(Arrays.toString(freqCount) + ": Should be [2, 2, 1, 1, 1, 1, 1, 2, 1]");

            // test permutation count
            System.out.println(permutations(freqCount) + ": Should be 59875200");
            System.out.println(permutations(new int[]{1, 3, 4, 1, 2, 2, 1, 1}) + ": Should be 2270268000");
        }

        // Gracefully fail if not enough arguments
        if (args.length < 1) {
            printUsage("One argument required");
            System.exit(1);
        }

        // Fail if word is too long
        if (args[0].length() > 20) {
            printUsage("Input word is too long; maximum is 20 characters.");
            System.exit(1);
        }

        // Fail if non alphabet characters are used
        for (int i = 0; i < args[0].length(); i++) {
            if ((args[0].charAt(i) >= 65 && args[0].charAt(i) <= 90) ||
                    (args[0].charAt(i) >= 97 && args[0].charAt(i) <= 122)) {
                continue;
            } else {
                printUsage(args[0].charAt(i) + ": only alphabet characters allowed");
                System.exit(1);
            }
        }

        String original = args[0].toUpperCase();

        // We'll need a sorted version of the input to calculate the cost
        char[] sorted = original.toCharArray();
        quicksort(sorted, 0, original.length());

        // create a frequency count, since that's all we'll need for permutation calculations
        int[] frequencyCount = countCharacters(sorted);

        // Start the cost calculation
        // Define the index of the fully sorted array = 0
        // Add 1 at the end
        long cost = 0;

        // For each letter we in the original string, we need to
        // 1. Calculate its index in the frequency count
        // 2. Iterate over the indices that come before it,
        //       calculating the number of permutations
        // 3. Remove it from the sorted string
        for (int i = 0; i < original.length(); i++) {
            char letter = original.charAt(i);

            // 1. Find the position of this letter in the frequency count
            int indexIntoFreqCount = 0;
            char prevChar = '\0';
            int indexIntoSorted = 0;
            while (sorted[indexIntoSorted] != letter) {
                if (sorted[indexIntoSorted] != prevChar) {
                    indexIntoFreqCount++;
                }
                prevChar = sorted[indexIntoSorted];
                indexIntoSorted++;
            }

            if (debug) {
                System.out.println("Iteration: " + i);
                System.out.println("Letter: " + letter);
                System.out.println(Arrays.toString(sorted) + " Index in sorted array: " + indexIntoSorted);
                System.out.println(Arrays.toString(frequencyCount) + " Index in frequency count array: " + indexIntoFreqCount);
            }

            // 2. Calculate the number of permutations that come before it
            // Iterate over the unique characters in the sorted array
            // For each one, take one instance out of the uniqueness array, and calculate the permutations
            for (int j = 0; j < indexIntoFreqCount; j++) {
                // if the frequency count is more than one, we can just decrement the frequency count
                if (frequencyCount[j] > 1) {
                    int[] clone = frequencyCount.clone();
                    clone[j]--;
                    cost += permutations(clone);

                    if (debug) {
                        System.out.println(Arrays.toString(clone) + ": cost += " + permutations(clone));
                    }
                // otherwise we need to make a clone
                } else {
                    int[] clone = new int[frequencyCount.length - 1];
                    for (int k = 0; k < j; k++) {
                        clone[k] = frequencyCount[k];
                    }
                    for (int k = j + 1; k < frequencyCount.length; k++) {
                        clone[k - 1] = frequencyCount[k];
                    }
                    cost += permutations(clone);

                    if (debug) {
                        System.out.println(Arrays.toString(clone) + " : cost += " + permutations(clone));
                    }
                }
            }

            // remove the character from the sorted array
            char[] sortedClone = new char[sorted.length - 1];
            for (int k = 0; k < indexIntoSorted; k++) {
                sortedClone[k] = sorted[k];
            }
            for (int j = indexIntoSorted + 1; j < sorted.length; j++) {
                sortedClone[j - 1] = sorted[j];
            }
            sorted = sortedClone;

            // remove the character from the frequency count
            if (frequencyCount[indexIntoFreqCount] > 1) {
                frequencyCount[indexIntoFreqCount]--;
            } else {
                int[] clone = new int[frequencyCount.length - 1];
                for (int k = 0; k < indexIntoFreqCount; k++) {
                    clone[k] = frequencyCount[k];
                }
                for (int k = indexIntoFreqCount + 1; k < frequencyCount.length; k++) {
                    clone[k - 1] = frequencyCount[k];
                }
                frequencyCount = clone;
            }

            if (debug) {
                System.out.println("New sorted array: " + Arrays.toString(sorted));
                System.out.println("New frequency array: " + Arrays.toString(frequencyCount));
            }
        }

        System.out.println("Final cost: " + (cost + 1));
    }

    // input: sorted char array
    // returns: a frequency count of the characters
    private static int[] countCharacters(char[] word) {
        // need to count unique characters because the array will have
        // length equal to that number
        int length = word.length;
        char prevChar = word[0];
        for (int i = 1; i < word.length; i++) {
            if (prevChar == word[i]) {
                length--;
            } else {
                prevChar = word[i];
            }
        }

        // create the return array
        int[] result = new int[length];

        // need two indexes: index into word length, index into unique word
        int indexIntoUniqueWord = 0;

        // initialize prevChar and result[0]
        prevChar = word[0];
        result[indexIntoUniqueWord] = 1;

        // for each iteration, either it's a repeat (prevChar == word[i]), and we increase
        // the frequency count without increasing the unique index,
        // or we increase the unique index and initialize that element in the array
        for (int i = 1; i < word.length; i++) {
            if (prevChar == word[i]) {
                result[indexIntoUniqueWord]++;
            } else {
                prevChar = word[i];
                indexIntoUniqueWord++;
                result[indexIntoUniqueWord] = 1;
            }
        }

        return result;
    }

    // iterate over a frequency count.
    // input: a frequency count representation of a word
    // returns: the number of permutations of the word
    private static long permutations(int[] word) {
        // we need to calculate the total characters.
        int length = 0;

        // divisor will be kept up to date on the fly
        long divisor = 1;

        for (int i = 0; i < word.length; i++) {
            length += word[i];
            if (word[i] > 1) {
                divisor *= factorial(word[i]);
            }
        }

        return factorial(length)/divisor;
    }

    private static void printUsage(String reason) {
        System.out.println(reason);
        System.out.println("Usage: java PermutationsOfWords WORD");
    }

    // ------------------------------------------------------------
    // Utilities
    // ------------------------------------------------------------

    private static long factorial(int n) {
        // Use the iterative (rather than recursive) implementation of factorial,
        // since it's much faster.
        long j;
        long i = 1;
        for(j = 2; j <= n; j=j+1) {
            i = i*j;
        }
        return i;
    }

    private static void quicksort(char[] inputArray, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        char p = chooseMedian(inputArray, left, right);
        int i = left + 1;
        for (int j = left + 1; j < right; j++) {
            if (inputArray[j] < p) {
                char temp = inputArray[j];
                inputArray[j] = inputArray[i];
                inputArray[i] = temp;
                i++;
            }
        }
        char temp = inputArray[i - 1];
        inputArray[i - 1] = p;
        inputArray[left] = temp;
        quicksort(inputArray, left, i - 1);
        quicksort(inputArray, i, right);
    }

    // used by quicksort
    private static char chooseMedian(char[] inputArray, int left, int right) {
        int size = right - left;
        int middleIndex;
        if (size % 2 == 0) {
            middleIndex = size/2 - 1 + left;
        } else {
            middleIndex = (size - 1)/2 + left;
        }

        if ((inputArray[left] > inputArray[middleIndex] && inputArray[left] < inputArray[right - 1]) ||
                inputArray[left] < inputArray[middleIndex] && inputArray[left] > inputArray[right - 1]) {
            // left is median
        } else {
            if (inputArray[left] > inputArray[middleIndex]) { // left is maximum
                if (inputArray[middleIndex] < inputArray[right - 1]) {
                    // right is median
                    char temp = inputArray[right - 1];
                    inputArray[right - 1] = inputArray[left];
                    inputArray[left] = temp;
                } else {
                    // middle is median
                    char temp = inputArray[middleIndex];
                    inputArray[middleIndex] = inputArray[left];
                    inputArray[left] = temp;
                }
            } else { // left is minimum
                if (inputArray[middleIndex] < inputArray[right - 1]) {
                    // middle is median
                    char temp = inputArray[middleIndex];
                    inputArray[middleIndex] = inputArray[left];
                    inputArray[left] = temp;
                } else {
                    // right is median
                    char temp = inputArray[right - 1];
                    inputArray[right - 1] = inputArray[left];
                    inputArray[left] = temp;
                }
            }
        }

        return inputArray[left];
    }
}