#!/usr/bin/ruby
print "Hello World\n"

def test_triplet(trip) # return 1 if valid triplet
	if (trip[0]**2 + trip[1]**2 == trip[2]**2)
		return 1
	else
		return 0
	end
end
#ex: 
#puts test_triplet([1, 2, 3]) # => return 0
#puts test_triplet([3, 4, 5]) # => return 1
#puts test_triplet([6, 8, 10])# => return 1

tripletarray = Array.new

for i in 1..1000
	for j in 1..1000
		c = 1000 - i - j
		if c >= 0 && c > i && c > j
			if test_triplet([i, j, c]) == 1
				tripletarray << [i, j, c]
				print tripletarray[-1], "\n"
			end
		end
	end
end

puts tripletarray[0][0]*tripletarray[0][1]*tripletarray[0][2]
