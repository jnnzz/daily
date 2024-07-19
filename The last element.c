#include <stdio.h>

int main(){
  int arr;
  
  printf("Enter array size: ");
  scanf("%d", &arr);

  int elem[arr];
  printf("Enter elements of array:\n ");
  for(int i=0; i < arr; i++){
    scanf("%d", &elem[i]);
  }

  printf("\n");
  printf("Last Element:%d", elem[arr-1]);
  
  return 0;
}