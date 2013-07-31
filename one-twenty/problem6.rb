#!/usr/bin/ruby
print "Hello World\n"

hundred = Array.new(100){|i| i+1}
squares = Array.new(100){|i| (i+1)*(i+1)}

sum_of_squares = 0
squares.each { |i| sum_of_squares+= i}

square_of_sum = 0
hundred.each {|i| square_of_sum+= i}

puts(square_of_sum*square_of_sum - sum_of_squares)
