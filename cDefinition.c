#include <stdio.h>

int add(int, int);

int main(){
  int a;
  int b;
  int sum;

  printf("Enter first number: ");
  scanf("%d", &a);
  printf("Enter second number: ");
  scanf("%d", &b);

  sum = add(a, b);
  printf("The sum is: %d", sum);


  return 0;
}

int add(int a, int b){
  return a + b;
}