#include<stdio.h>
#include<stdlib.h>

#define MAX 1000000000 

int n, k;
int i, j;
int *d;

int best[2] = {MAX, MAX};

int main(){
  FILE *fin = fopen("nfc.in", "r");
  FILE *fout = fopen("nfc.out", "w");

  fscanf(fin, "%d %d", &n, &k);

  d = (int *) malloc(n * sizeof(int));

  for(i = 0; i < n; i++)fscanf(fin, "%d", &d[i]);

  for(i = 0; i < n - 1; i++)
    for(j = i + 1; j < n; j++)
      if(d[i] + d[j] == k && i + j + 2 < best[0] + best[1])
	best[0] = i + 1, best[1] = j + 1;

  fprintf(fout, "%d %d\n", best[0], best[1]);

  fclose(fin);
  fclose(fout);

  return 0;
}
