// Problem 26.
// Reciprocal Cycles
// The decimal representation of rational numbers is either terminating (infinite zeros at the end) or repeating. 
// For d = 1:1000, find the longest repeating cycle.

#include <stdio.h>
#include <string.h>


int main()
{
	printf("Problem 26\n");
	
	int i, j, k;
	int length_of_cycle[1000] = {0};
	int temp[2000];
	int quotient, remainder;
	int biggest = 0;
	int index = 0;
	
	printf("Starting cycle\n");
	
	for(i = 10; i < 20; i++){
		memset(temp, 0, 2000*sizeof(int));
		remainder = 10;
		printf("%d\t", i);
		for(j = 0; j < 1999; j++){
			temp[j] = remainder/i;
			remainder = remainder % i;
			remainder = remainder*10;
			if(remainder == 0){
			temp[j+1] = 0;
			length_of_cycle[i] = 0;
			printf(" terminating cycle\n");
			break;
			}
		}
		if(remainder != 0){
			//printf(" repeating cycle\n");
			k = 0;
			while(memcmp(&temp[20], &temp[20+k+1], sizeof(int)*(k+1)) != 0)
				k++;
			length_of_cycle[i] = k;
			printf(" repeating cycle: %d\n", k+1);
			if(k+1 > biggest){
				printf("Biggest so far: %d repeating cycle (%d)\n", k+1, i);
				biggest = k+1;
				index = i;
			}
		}
	}
	printf("\n\n");
	printf("%d, %d\n", biggest, index);
	
	return 0;
}
