#include <stdio.h>
#include <stdlib.h>

int main()
{
	int every_number[28123], sum_of_divisors[28123], abundant[28123]; // amiable numbers
	int i, j;			// for loops and number of primes
	int sum = 0;

	printf("Start\n");
	for(i = 0; i < 28123; i = i+1)
	{
		every_number[i] = i;
		sum_of_divisors[i] = 1;
		for(j = 2; j < i; j = j+1)
		{
			if(i % j == 0)
				sum_of_divisors[i] = sum_of_divisors[i] + j;
		}
		if(sum_of_divisors[i] > i)
			abundant[i] = 1;
		else
			abundant[i] = 0;
	}
	for(i = 1; i < 28123; i = i+1)
	{	
		if(abundant[i])
		{
			for(j = i; j < 28123; j = j+1)
			{
				if(abundant[j] && (i + j) < 28123)
					every_number[i+j] = 0;
			}
		}
	}
	printf("Number\tAbundant?\tSum of Abundant?\n");
	for(i = 1; i < 25; i=i+1)
	{
		printf("%d\t\t%d\t\t%d\n", i, abundant[i], every_number[i]);
	}
	for(i = 0; i < 28123; i=i+1)
	{
		sum = sum + every_number[i];
	}
	printf("Sum of numbers that can't be written as the sum of two abundant numbers: %d\n", sum);	
	return 0;
}
