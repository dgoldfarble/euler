//
//  Problem39.cpp
//  euler
//
//  Created by David Goldfarb on 11/3/14.
//  Copyright (c) 2014 David. All rights reserved.
//

#include "Problem39.h"

#include <vector>

#include "Euler.h"



Problem29::Problem29() {
    prime_list.push_back(2);
    prime_list.push_back(3);
    prime_list.push_back(5);
    prime_list.push_back(7);
}

bool Problem29::is_truncatable(int prime, vector<int> prime_list) {
    vector<int> truncated_1 = truncate_small_to_large(prime);
    for (vector<int>::iterator prime_candidate = truncated_1.begin(); prime_candidate != truncated_1.end(); prime_candidate++) {
        if (!std::binary_search (prime_list.begin(), prime_list.end(), *prime_candidate)) {
            return false;
        }
    }
    
    vector<int> truncated_2 = truncate_large_to_small(prime);
    for (vector<int>::iterator prime_candidate = truncated_2.begin(); prime_candidate != truncated_2.end(); prime_candidate++) {
        if (!std::binary_search (prime_list.begin(), prime_list.end(), *prime_candidate)) {
            return false;
        }
    }
    
    return true;
}

vector<int> Problem29::truncate_large_to_small(int prime) {
    vector<int> return_val;
    return_val.push_back(prime);
    std::string s = std::to_string(prime);
    for (int i = 1; i < s.size(); i++) {
        std::string substring = s.substr(i);
        return_val.push_back(atoi(substring.c_str()));
    }
    return return_val;
}

vector<int> Problem29::truncate_small_to_large(int prime) {
    vector<int> return_val;
    return_val.push_back(prime);
    int ones_digit_removed = prime/10;
    while (ones_digit_removed > 0) {
        return_val.push_back(ones_digit_removed);
        ones_digit_removed /= 10;
    }
    return return_val;
}

void Problem29::run() {
    int count = 0;
    vector<int> truncatable;
    while (count < 11) {
        int prime = bueler->find_next_prime(&prime_list);
        prime_list.push_back(prime);
        if (is_truncatable(prime, prime_list)) {
            truncatable.push_back(prime);
            printf("truncatable number: %d\n", prime);
            count++;
        }
    }
    int sum = 0;
    for (vector<int>::iterator number = truncatable.begin(); number != truncatable.end(); number++) {
        sum += *number;
    }
    printf("sum: %d\n", sum);
}

