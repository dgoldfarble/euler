#!/usr/bin/ruby

# array of length number of steps
# put one into leftmost spot
# 	perform action
# put one into next spot
# 	perform action
# keep moving until the condition fails
# the condition is that when putting a one down plus the number of ones left in the stack is less than the number of spots there are left
def recursive_create(steps, onesleft)
	if onesleft == 1
		return steps
	end
	if onesleft == 0
		return 0
	end
	if steps == 0
		return 0
	end
		
	sum = 0;
	for i in 1..(steps+1-onesleft)
#		print "Called with ", steps," steps, ", onesleft, " onesleft.\n"
#		print "Calling ", steps-i, " steps-i, ", onesleft-1, " onesleft-1\n"
		sum = sum + recursive_create(steps-i,onesleft-1)
	end
	return sum
end

puts recursive_create(40,20)
