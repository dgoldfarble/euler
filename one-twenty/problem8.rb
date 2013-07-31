#!/usr/bin/ruby
print "Hello World\n"

number = File.open("./numberfor8.txt").read

def product(string, position)
	result = 1
	for i in 1..5
		result *= string[position-1+i].to_i
	end
	return result
end

result = 0

for i in 1..number.length
	if product(number, i-1) >= result
		result = product(number, i-1)
		puts result
	end
end
