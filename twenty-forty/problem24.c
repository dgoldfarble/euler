# include <stdio.h>

int fact(int n)
{
	int j;
	int i = 1;
	for(j = 2; j <= n; j=j+1)
	{
		i = i*j;
	}
	return i;
}

int main()
{
	int num, i, j;
	int counter = 1000000;
	int length = 10;
	printf("Problem 24\n");
	printf("Here's how it works: the key here is lexicographic order. The method is to find the digits in order from left to right. Since there are 10 digits in \"0123456789\", there are 10! different orders for the digits to be in. Because we want lexicographic order, the first 9! permutations start with 0. The next 9! permutations start with 1, and the last 9! permutations start with 9. Thus we find each digit iteratively. 1000000 is larger than 1*9!, so the first digit is not 0. 1000000 is larger than 2*9!, so the first digit is not 1. 1000000 is not larger than 3*9!, so the first digit must be 2. In fact, this tells us that the 2*9!+1 = 725761st permutation is 2013456789. Now we perform the same method to find the next digit.\n");
	for(j = 9; j > 0; j--)
	{
		for(i = 1; i*fact(j) < counter; i++){};
		i--;
		printf("Counter = %d is between %d*%d!=%d and %d*%d!=%d\n", counter, i, fact(j), i*fact(j), (i+1), fact(j), (i+1)*fact(j));
		counter = counter - i*fact(j);
	}
	return 0;
}
