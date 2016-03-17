'''
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
'''


import os
import sys
import argparse
import csv


def main(arguments):
    '''
    parser = argparse.ArgumentParser()
    parser.add_argument('infile', help="Input file", type=argparse.FileType('r'))
    parser.add_argument('-o', '--outfile', help="Output file",
                        default=sys.stdout, type=argparse.FileType('w'))

    args = parser.parse_args(arguments)
    '''

    # part6 contains the last prime under 1,000,000,000, let's work down
    fileList = ['2T_part6.txt',
        '2T_part5.txt',
        '2T_part4.txt',
        '2T_part3.txt',
        '2T_part2.txt',
        '2T_part1.txt']

    found = False
    while (not found):
        for file in fileList:
            print(file)
            for line in reverse_readline(os.path.join('primes', file)):
                primes = line.split('\t')
                for prime in reversed(primes):
                    if (int(prime) < 1000000000):
                        if (isPandigital(int(prime))):
                            found = True
                            print(prime)
                            return


def isPandigital(number):
    numStr = str(number)
    for i in range(len(numStr)):
        if (str(i + 1) not in numStr):
            return False
    return True

# googled
def reverse_readline(filename, buf_size=8192):
    """a generator that returns the lines of a file in reverse order"""
    with open(filename) as fh:
        segment = None
        offset = 0
        fh.seek(0, os.SEEK_END)
        file_size = total_size = remaining_size = fh.tell()
        while remaining_size > 0:
            offset = min(total_size, offset + buf_size)
            fh.seek(total_size - offset)
            buffer = fh.read(min(remaining_size, buf_size))
            remaining_size -= buf_size
            lines = buffer.split('\n')
            # the first line of the buffer is probably not a complete line so
            # we'll save it and append it to the last line of the next buffer
            # we read
            if segment is not None:
                # if the previous chunk starts right from the beginning of line
                # do not concact the segment to the last line of new chunk
                # instead, yield the segment first
                if buffer[-1] is not '\n':
                    lines[-1] += segment
                else:
                    yield segment
            segment = lines[0]
            for index in range(len(lines) - 1, 0, -1):
                if len(lines[index]):
                    yield lines[index]
        # Don't yield None if the file was empty
        if segment is not None:
            yield segment

if __name__ == '__main__':
    sys.exit(main(sys.argv[1:]))
