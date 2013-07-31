#!/usr/bin/ruby
print "Hello World\n"

def sequence(n)
	result = Array.new << n
	while n != 1
		if n % 2 == 0
			n = n/2
		else
			n = 3*n + 1
		end
		result << n
	end
	return result
end

length = 0
for i in 1..1000000
	if sequence(i).length > length
		length = sequence(i).length
		print i, "\n"
	end
end
