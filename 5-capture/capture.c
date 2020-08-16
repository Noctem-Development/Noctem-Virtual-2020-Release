#include<stdio.h>
#include<stdlib.h>

int n, x, y, a, b;
int ar[1000][2];
int i, j;
int max = 0;
int thing[200][200];

int test_pos(int xp, int yp){
  int m = 1000, i, j;

  for(i = 0; i < a; i++)
    for(j = 0; j < b; j++)
      m = (m > thing[i + xp][j + yp]) ? thing[i + xp][j + yp] : m;

  return m;
}

int min_dist(int r, int c){
  int m = 1000, i, tmp;

  for(i = 0; i < n; i++) {
    tmp = abs(r - ar[i][0]) + abs(c - ar[i][1]);
    if(tmp < m) m = tmp;
  }
  
  return m;
}

int main(){
  FILE *fin = fopen("capture.in", "r");
  FILE *fout = fopen("capture.out", "w");

  fscanf(fin, "%d %d %d %d %d", &n, &x, &y, &a, &b);
  for(i = 0; i < n; i++) fscanf(fin, "%d %d", &ar[i][0], &ar[i][1]);

  for(i = 0; i < x; i++)
    for(j = 0; j < y; j++)
      thing[i][j] = min_dist(i, j);

  int tmp;
  for(i = 0; i < x - a + 1; i++) {
    for(j = 0; j < y - b + 1; j++) {
      tmp = test_pos(i, j);
      max = (tmp > max) ? tmp : max;
    }
  }

  fprintf(fout, "%d\n", max);

  fclose(fin);
  fclose(fout);

  exit(0);
}
