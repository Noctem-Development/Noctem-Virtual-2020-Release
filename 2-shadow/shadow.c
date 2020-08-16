#include<stdio.h>
#include<stdlib.h>

FILE *fin, *fout;

int n;
int i, j[5];
int max_weight = 0, temp_weight = 0;

int main()
{
  fin = fopen("shadow.in", "r");
  fout = fopen("shadow.out", "w");

  fscanf(fin, "%d", &n);

  for(i = 0; i < n; i++){
    temp_weight -= j[i % 5];

    fscanf(fin, "%d", &j[i % 5]);
    temp_weight += j[i % 5];

    if(temp_weight > max_weight) max_weight = temp_weight;
  }

  fprintf(fout, "%d\n", max_weight);

  fclose(fin);
  fclose(fout);

  exit(0);
}
