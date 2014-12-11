// Playground - noun: a place where people can play

import Cocoa

var temp : Double = 2 / (pow(8, 8))

func is_prime(prime_to_test : Int, prime_list : [Int]) -> Bool{
    for divisor in prime_list {
        if prime_to_test % divisor == 0 {
            return false
        }
    }
    return true
}

func truncate_small_to_large(num : Int) -> [Int] {
    var return_var : [Int] = [num]
    var ones_digit_removed: Int = num / 10
    while (ones_digit_removed > 0) {
        return_var.append(ones_digit_removed)
        ones_digit_removed /= 10
    }
    return return_var
}

var three : Int = 2984

/*func truncate_large_to_small(num : Int) -> [Int] {
var return_var : [Int] = [num]
var num_as_double : Double = Double(num)
var first_digit_power_double : Double = log10(num_as_double)
var temp : Double = pow(10, floor(first_digit_power_double))
let temp_let : Int = Int(temp)
var first_digit_value : Int = num / temp_let
return return_var
}*/
func truncate_large_to_small(num : Int) -> [Int] {
    var return_var : [Int] = [num]
    var num_string : String = String(num)
    var num_length : Int = countElements(num_string)
    for index in 2...num_length {
        var substring : String = num_string.substringWithRange(Range<String.Index>(start: advance(num_string.startIndex, index), end: num_string.endIndex))
        var strtoi : Int? = substring.toInt()
        return_var.append(strtoi!)
    }
    return return_var
}
println(truncate_large_to_small(three))

println(truncate_large_to_small(three))

func is_truncatable(num : Int, prime_list : [Int]) -> Bool {
    var truncated_1 : [Int] = truncate_small_to_large(num)
    for element in truncated_1 {
        if (!is_prime(element, prime_list)) {
            return false
        }
    }
    var truncated_2 : [Int] = truncate_large_to_small(num)
    
    return true
}


func find_next_prime(prime_list : [Int]) -> Int {
    var potential_prime_number: Int = prime_list.last!
    potential_prime_number = potential_prime_number + 2
    while (!is_prime(potential_prime_number, prime_list)) {
        potential_prime_number = potential_prime_number + 2
    }
    return potential_prime_number
}

var truncatable = 0
var prime_list: [Int] = [2, 3, 5, 7]
println(prime_list)
while (truncatable < 11) {
    let prime = find_next_prime(prime_list)
    prime_list.append(prime)
    if is_truncatable(prime, prime_list) {
        truncatable++
        println("prime")
    }
}
