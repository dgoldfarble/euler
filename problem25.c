# include <stdio.h>
#include <string.h>
#include <gmp.h>

int main()
{
	printf("Problem 25\n");
	mpz_t Fn, Fnm1, Fnm2, temp, ten_to_1000;
	int n = 3;
	
	// initialize multiple precision integers (Z)
	mpz_init_set_ui(Fn,2); 
	mpz_init_set_ui(Fnm1,1);
	mpz_init_set_ui(Fnm2,1);
	mpz_init(temp);
	mpz_init_set_ui(ten_to_1000, 10);
	mpz_pow_ui(ten_to_1000, ten_to_1000, 999);
	
	//for(n = 4; n < 20; n++)
	while(mpz_cmp(Fn, ten_to_1000) < 0)
	{
		n++;
		
		// general fibonacci procudure. swaps could be used in place of sets
		mpz_set(temp, Fnm1);
		mpz_set(Fnm1, Fn);
		mpz_set(Fnm2, temp);
		mpz_add(Fn, Fnm1, Fnm2);
		printf("\n%d ", n);
		mpz_out_str(stdout,10,Fn);
	}
	//printf("n=%d\n", n);
	
	mpz_clear(Fn);
	mpz_clear(Fnm1);
	mpz_clear(Fnm2);
	mpz_clear(temp);
	mpz_clear(ten_to_1000);


	return 0;
}
