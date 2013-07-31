#!/usr/bin/ruby
print "Problem 20:\n"

def factorial(n)
	temp = n
	result = 1
	while temp > 1
		result = result*temp
		temp = temp-1
	end
	return result
end

two_to_the = factorial(100)
sum_of_digits = 0
print two_to_the, "\n"

while two_to_the.to_s().length > 1
	print
	sum_of_digits += two_to_the % 10
	two_to_the /= 10
end

sum_of_digits += two_to_the % 10
print sum_of_digits
