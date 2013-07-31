#!/usr/bin/ruby
print "Hello World\n"

init = 1
temp = 1
fib = 0
sum = 0
while fib <= 4000000
	fib = init + temp
	init = temp
	temp = fib
	if (fib % 2 == 0)
		sum = sum + fib
	end
end

puts sum
