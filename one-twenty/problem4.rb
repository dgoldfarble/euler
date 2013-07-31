#!/usr/bin/ruby
print "Hello World\n"

def testpalindrome(m)
	if (m.to_s() == m.to_s().reverse)
		return 1
	else
		return 0
	end
end

temp = 0
top = 0

for i in 1..999
	for l in 1..999
		if testpalindrome(i*l) == 1 && i*l >= top
			top = i*l
			puts top
		end
	end
end
