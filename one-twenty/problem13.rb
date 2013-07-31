#!/usr/bin/ruby
print "Hello World\n"

file = File.open("./numbersfor13.txt")
grid = file.readlines

sum = 0

for i in 0..99
	sum += Integer(grid[i][0..19])
end

puts sum
puts sum.to_s().length
puts sum / 10**(sum.to_s().length-10)
