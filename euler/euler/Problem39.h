//
//  Problem39.h
//  euler
//
//  Created by David Goldfarb on 11/3/14.
//  Copyright (c) 2014 David. All rights reserved.
//

#ifndef __euler__Problem39__
#define __euler__Problem39__

#include "Euler.h"
#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Problem29
{
public:
    
    Problem29 ();
    void run();
    bool is_truncatable(int prime, vector<int> prime_list);
    vector<int> truncate_small_to_large(int prime);
    vector<int> truncate_large_to_small(int prime);
    
private:
    bool debug;
    Euler* bueler = new Euler();
    vector<int> prime_list;
};

#endif /* defined(__euler__Problem39__) */
