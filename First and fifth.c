#include <stdio.h>

int main(){
  int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  float product = arr[0] * arr[4];
  printf("%.2f", product);

  return 0;
}