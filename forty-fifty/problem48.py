'''
The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
'''


import sys

def main(args):
    result = 0
    for i in range(1, int(args[0]) + 1):
        print i
        result += (pow(i, i) % 10000000000)
        result = result % 10000000000
    print result




if __name__ == '__main__':
    sys.exit(main(sys.argv[1:]))
