//
//  euler.cpp
//  euler
//
//  Created by David Goldfarb on 10/30/14.
//  Copyright (c) 2014 David. All rights reserved.
//

#include "Euler.h"

Euler::Euler() {
    
}

bool Euler::is_prime (int prime_to_test, vector<int>* y) {
    if (prime_to_test == 1) {
        return true;
    }
    if (prime_to_test > y->back()) {
        for (vector<int>::iterator divisor = y->begin(); divisor != y->end(); divisor++) {
            if (prime_to_test % *divisor == 0) {
                return false;
            }
        }
        return true;
    } else {
        if (std::binary_search (y->begin(), y->end(), prime_to_test)) {
            return true;
        }
        return false;
    }
}

int Euler::find_next_prime (vector<int> *prime_list) {
    int potential_prime_number = prime_list->back() + 2;
    while(!is_prime(potential_prime_number, prime_list)) {
        potential_prime_number += 2;
    }
    return potential_prime_number;
}
