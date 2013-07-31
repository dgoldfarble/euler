#!/usr/bin/ruby
print "Hello World\n"


grid = File.open("./gridfor11.csv").read
matrix = Array.new(20){Array.new(20)}

# fill matrix
for i in 0..19
	for j in 0..19
		matrix[i][j] = grid[3*j+60*i..3*j+2+60*i].to_i()
	end
end

def horizontal(row, column, matrix) #multiply first element and three elements to the right
	return matrix[row][column]*matrix[row][column+1]*matrix[row][column+2]*matrix[row][column+3]
end

def vertical(row, column, matrix) #multiply first element and three elements down
	return matrix[row][column]*matrix[row+1][column]*matrix[row+2][column]*matrix[row+3][column]
end

def diagonal(row, column, matrix) #multiply first element and three elements diagonally down-right
	return matrix[row][column]*matrix[row+1][column+1]*matrix[row+2][column+2]*matrix[row+3][column+3]
end

def diagonalright(row, column, matrix) #reverse diagonal direction
		return matrix[row][column]*matrix[row-1][column+1]*matrix[row-2][column+2]*matrix[row-3][column+3]
end

result = 0
for i in 0..19
	for j in 0..16
		if horizontal(i,j,matrix) > result  #test horizontal
			result = horizontal(i,j,matrix)
		end
	end
end
for i in 0..16
	for j in 0..19
		if vertical(i,j,matrix) > result  #test vertical
			result = vertical(i,j,matrix)
		end
	end
end
for i in 0..16
	for j in 0..16
		if diagonal(i,j,matrix) > result  #test diagonal 1
			result = diagonal(i,j,matrix)
		end
	end
end
for i in 3..19
	for j in 0..16
		if diagonalright(i,j,matrix) > result  #test diagonal 2.
			result = diagonalright(i,j,matrix)
		end
	end
end

print result
