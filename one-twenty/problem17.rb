#!/usr/bin/ruby
print "Problem 17:\n"


def write_word(n)
	ones = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen', 'twenty']
	tens = ['', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']
	
	if n < 21
		return ones[n]
	elsif n < 100
		return tens[n / 10] + ones[n % 10]
	elsif n < 1000
		if n % 100 == 0
			return ones[n/100] + 'hundred'
		end
		return ones[n/100] + 'hundredand' + write_word(n%100)
	else n == 1000
		return ones[n/1000] + 'thousand'
	end
end

sum = 0
for i in 1..1000
	sum = sum + write_word(i).length
end
print sum
