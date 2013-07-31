#Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
#If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.

#For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

#Evaluate the sum of all the amicable numbers under 10000.

#!/usr/bin/ruby
print "Problem 21:\n"

# create array sum_of_divisors
length = 10000
sum_of_divisors = Array.new(length) 
# define create_prime_array()
def create_prime_array(n) # n is prime array largest number less than
	primes = Array.new() << 2 << 3
	while primes[-1] < n
		i = primes[-1] + 2
		prime = true
		for j in primes
			if i % j == 0
				prime = false
			end
		end
		if prime
			primes << i
		end
	end
	return primes
end
print "Generating prime array\n"
primes = create_prime_array(Math.sqrt(n))
# define calculate_divisors
def calculate_divisors(n,array)
	# find all divisors
	divisors = Array.new(1) << 1
	for i in 0..array.length
		if n % i == 0
			divisors << i
		end
	end
	powers = divisors.dup
	# find prime power
	for i in 1..powers.length
		temp = n / divisors[i]
		powers[i] = 1
		while temp % divisors[i] == 0
			powers[i] += 1
			temp = temp/divisors[i]
		end
	end
	sum = 1
	#
	def fill_divisors(divisors,powers)
		# use this guide while generating loops
		#	outside step: 
		return true_array
	end
	for i in 1...length
		sum += [i]
		# for each 
			
	
end
# given a prime array, how to calculate ALL proper divisors?
# EITHER
# 	check every number to see if it's a divisor
# OR
#	find the prime factorization and add up every iteration
print "Summing proper divisors
for i in 0..length
	sum_of_divisors[i] = calculate_divisors(i,primes)
end

