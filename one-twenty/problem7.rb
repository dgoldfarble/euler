#!/usr/bin/ruby
print "Hello World\n"

primes = Array.new() << 2

def checkdivisor(m, n)
	if m % n == 0
		return 1
	else
		return 0
	end
end

def checkprime(m) #returns 1 if m is prime
	temp = 0
	for i in 2..(m-1)
		if checkdivisor(m, i) == 1
			temp = 1
		end
	end
	if temp == 0
		return 1
	else
		return 0
	end
end

def findnextprime(prime_array)
	i = prime_array[-1] + 1
	while checkprime(i) == 0
		i += 1	
	end
	return i
end

puts primes[-1]
puts checkprime(2)
puts checkprime(3)
puts checkprime(4)

for i in 1..10000
	primes << findnextprime(primes)
	print i+1, " ", primes[-1], "\n"
end

