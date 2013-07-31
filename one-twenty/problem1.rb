#!/usr/bin/ruby
print "Hello World\n"


temp = 0

for i in 0..999
	if (i % 3 == 0 || i % 5 == 0)
		temp = temp + i
	end
end

puts temp

