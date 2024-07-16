#include <stdio.h>

int add(int, int);


int main(){
  int a = 10;
  int b = 30;
  int sum;

  sum = add(a, b);
  printf("The sum is: %d", sum);


  return 0;
}

int add(int a, int b){
  return a + b;
}