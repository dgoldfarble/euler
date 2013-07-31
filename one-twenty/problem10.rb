#!/usr/bin/ruby
print "Hello World\n"

primes = Array.new() << 2 << 3 << 5

def checkprime(m, prime_array) #returns 1 if m is_prime
	i = 0
	temp = 0
	while prime_array[i] < Math.sqrt(m) + 1
		if m % prime_array[i] == 0
			temp = 1
		end
		i += 1
	end
	if temp == 1
		return 0
	else return 1
	end
end

def findnextprime(prime_array)
	i = prime_array[-1] + 2
	while checkprime(i, prime_array) == 0
		i += 2
	end
	return i
end

i = 0

while i < 2000000
	primes << findnextprime(primes)
	i = primes[-1]
	puts i
end

sum = 0
primes.each {|i| sum += i}
puts sum - primes[-1]
