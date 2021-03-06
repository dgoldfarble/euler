#include <stdio.h>
#include <stdlib.h>

int main()
{
	int every_number[10000], sum_of_divisors[10000]; // amiable numbers
	int i, j;			// for loops and number of primes
	int amiable_sum = 0;

	printf("Start\n");
	for(i = 0; i < 10000; i = i+1)
	{
		every_number[i] = i;
		sum_of_divisors[i] = 1;
		for(j = 2; j < i; j = j+1)
		{
			if(i % j == 0)
				sum_of_divisors[i] = sum_of_divisors[i] + j;
		}
	}
	for(i = 0; i < 10000; i = i+1)
	{	
		if(sum_of_divisors[i] < 10000)
		{
			if(i == sum_of_divisors[sum_of_divisors[i]] && i != sum_of_divisors[i])
			{
				amiable_sum = amiable_sum + i;
				printf("Amicable pair: %d, %d, %d\n", i, sum_of_divisors[i], sum_of_divisors[sum_of_divisors[i]]);
			}
		}
	}
	printf("Amiable numbers under 10000: %d\n", amiable_sum);	
	return 0;
}
