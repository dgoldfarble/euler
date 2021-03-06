#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// from previous data: 5163 names

int main()
{
	char names[5163][15] = {0};
	char temp[15];
	int c, i, j, commas, marks;
	int sorted;
	int sum[5163] = {0};
	int total = 0;
	FILE * file;
	file = fopen("names.txt", "r");
	commas = 0;
	marks = 0;
	i = 0;
	
	// read the names in
	if(file)
	{
		while((c = getc(file)) != EOF)
		{
			if(c == ',')
			{
				commas = commas + 1;
				i = 0;
				// printf("%d\n", commas);
			}
			else if(c == '\"')
			{
				marks = marks + 1; // pretty useless
			}
			else
			{
				names[commas][i] = c;
				i = i+1;
			}
		}
	}
	fclose(file);
	
	// Bubble sort the names
	sorted = 0;
	while(sorted != 1)
	{
		sorted = 1;
//		printf("While loop\n");
		for(i = 0; i < 5162; i=i+1)
		{	
//			printf("For loop\n");
			if(strcmp(names[i], names[i+1]) > 0)
			{
				sorted = 0;
				strcpy(temp, names[i]);
				strcpy(names[i], names[i+1]);
				strcpy(names[i+1], temp);
			}
		}
	} 
		
	// sum the values of each letter
	for(i = 0; i < 5163; i=i+1)
	{
		strlen(names[i]);
		for(j = 0; j < strlen(names[i]); j=j+1)
			sum[i] = sum[i] + names[i][j] - 64;
		total = total + sum[i] * (i + 1);
	}
	
//	printf("1st name: %s\n", names[0]);
//	printf("2nd name: %s\n", names[1]);
//	printf("947th name: %s\n", names[936]);
	printf("948th name: %s, value: %d\n", names[937], sum[937]);
//	printf("949th name: %s\n", names[938]);
	printf("Counter: %d\n", commas);
	printf("Total: %d\n", total);
	return 0;
}
