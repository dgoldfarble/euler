#!/usr/bin/ruby
print "Hello World\n"

def checkdivisor(m, n)
	if m % n == 0
		return 1
	else
		return 0
	end
end

def lcm(m, n)
	test = 0
	i = 2
	until test == 1
		if checkdivisor(i, m) == checkdivisor(i, n) && checkdivisor(i, m) == 1
			test = 1
		end
		i = i + 1
	end
	return i - 1
end

temp = 2
for i in 2..20
	temp = lcm(i, temp)
	puts temp
end

