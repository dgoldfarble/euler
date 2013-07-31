#!/usr/bin/ruby
print "Problem 19:\n"

normal_year = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
leap_year = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
month = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"]

def leap(year)
	if year % 400 == 0
		return true
	elsif year % 100 == 0
		return false
	elsif year % 4 == 0
		return true
	else
		return false
	end
end

year_is = 1900
days = 1 # Monday

for i in 0..11 # twelve months later...
	if leap(year_is)
		days = days + leap_year[i]
		if days % 7 == 0
			print month[i], " ", year_is, "\n"
		end
	else
		days = days + normal_year[i]
	end
end
print days, "\n" #days = 366
print (days % 7), "\n" # it's a tuesday (=2)
year_is += 1

successes = 0
for i in 1..100
	# test year
	if leap(year_is)
		for j in 0..11
			if days % 7 == 0
				successes += 1
				print month[j], " ", year_is, "\n"
			end			
			days += leap_year[j] #add months by leap year
		end
	# otherwise
	else
		for j in 0..11
			if days % 7 == 0
				successes += 1
				print month[j], " ", year_is, "\n"
			end
			days += normal_year[j] #add months by normal year
		end
	end
	year_is += 1
end

print successes, "\n"
