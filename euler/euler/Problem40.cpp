//
//  problem40.cpp
//  euler
//
//  Created by David Goldfarb on 11/3/14.
//  Copyright (c) 2014 David. All rights reserved.
//

#include "Problem40.h"
#include <iostream>
#include <sstream>

using namespace std;

void Problem40::run() {
    int multiplier = 1;
    int start = 1;
    int end = 1;
    int prev_string_length = 0;
    
    // append i to a string in a loop
    ostringstream converter;
    int number_to_string = 1;
    while (end < 1000000) {
        start = end;
        converter << number_to_string;
        
        const std::string tmp = converter.str();
        string cstr = tmp.c_str();
        end += cstr.length();
        
        converter.str(std::string());
        
        
        if (start <= 1 && end > 1) {
            multiplier *= get_digit(cstr, start, 1);
        }
        if (start <= 10 && end > 10) {
            multiplier *= get_digit(cstr, start, 10);
        }
        if (start <= 100 && end > 100) {
            multiplier *= get_digit(cstr, start, 100);
        }
        if (start <= 1000 && end > 1000) {
            multiplier *= get_digit(cstr, start, 1000);
        }
        if (start <= 10000 && end > 10000) {
            multiplier *= get_digit(cstr, start, 10000);
        }
        if (start <= 100000 && end > 100000) {
            multiplier *= get_digit(cstr, start, 100000);
        }
        if (start <= 1000000 && end > 1000000) {
            multiplier *= get_digit(cstr, start, 1000000);
        }
        
        number_to_string++;
        prev_string_length = cstr.length();
    }
    
    cout << multiplier << endl;
}

int Problem40::get_digit(string cstr, int start, int target) {
    string oeua = cstr.substr(target - start, 1);
    int digit = atoi((char*)oeua.c_str());
    return digit;
}

Problem40::Problem40() {
    
}