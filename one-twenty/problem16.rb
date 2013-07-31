#!/usr/bin/ruby
print "Problem 16:\n"

two_to_the = 2**1000
sum_of_digits = 0
print two_to_the, "\n"

while two_to_the.to_s().length > 1
	print
	sum_of_digits += two_to_the % 10
	two_to_the /= 10
end

sum_of_digits += two_to_the % 10
print sum_of_digits
