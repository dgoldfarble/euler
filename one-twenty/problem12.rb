#!/usr/bin/ruby
print "Hello World\n"

def count_divisors(n)
	count = 0
	for i in 1..Math.sqrt(n) + 1
		if n % i == 0
			count += 1
		end
	end
	return count*2
end

print count_divisors(6), "\n"

counter = 0
sum = 0
while 1 == 1
	counter += 1
	sum += counter
	print counter, " ", sum, " ", count_divisors(sum), "\n"
	if count_divisors(sum) > 500
		break
	end
end
