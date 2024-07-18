#include <stdio.h>

int main() {
  int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  int sum = 0;

  // int sum = arr[2] + arr[5] + arr[9];
  // printf("The sum is %d", sum);

  for(int i=0; i < 10; i++){
    sum += arr[i];
   
  }
  
  printf("%d", sum);
  
  return 0; 
}