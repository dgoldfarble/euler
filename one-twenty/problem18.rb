#!/usr/bin/ruby
print "Problem 18:\n"

grid = File.open("./gridfor18.csv").read
original = Array.new(15){|i| Array.new(i){0}}

number_placeholder = 0

# fill original
for i in 0..14
	for j in 0..original[i].length
		original[i][j] = grid[number_placeholder..number_placeholder+2].to_i()
		number_placeholder = number_placeholder+3
	end
#	print original[i], "\n"
end


def test_each_pair(row)
	result = Array.new(row.length-1)
#	indexes = Array.new(row.length-1) #if we need to trace the path...
	for i in 0..result.length-1
		result[i] = row[i..i+1].max
	end
	return result
end

for i in 14.downto(1)
	temp = test_each_pair(original[i])
	for j in 0..temp.length-1
		original[i-1][j] = original[i-1][j] + temp[j]
	end
	print original[i-1], "\n"
end

print original[0]
