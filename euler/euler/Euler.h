//
//  Euler.h
//  euler
//
//  Created by David Goldfarb on 10/30/14.
//  Copyright (c) 2014 David. All rights reserved.
//

#ifndef __euler__Euler__
#define __euler__Euler__

#include <stdio.h>
#include <vector>


using namespace std;

class Euler {
public:
public:
    Euler();
    bool is_prime(int, vector<int>*);
    int find_next_prime(vector<int>*);
};

#endif /* defined(__euler__math__) */
