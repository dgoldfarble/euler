#!/usr/bin/ruby
print "Hello World\n"

number = 600851475143
i = 2

def checkpower(m, n)
	if m % n == 0
		return checkpower(m/n, n) + 1
	else
		return 0
	end
end

def checkdivisor(m, n)
	if m % n == 0
		return 1
	else
		return 0
	end
end

def checkprime(m)
	temp = 0
	for i in 2..(m-1)
		if checkdivisor(m, i) == 1
			temp = 1
		end
	end
	if temp == 0
		return 0
	else
		return 1
	end
end

while i**2 < number
	if (checkprime(i) == 0 && checkdivisor(number, i) == 1)
		print i
		print " "
		print checkpower(number, i)
		puts " "
	end
	i = i + 1
end
