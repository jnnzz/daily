#include <stdio.h>

int main(){
  int arr;
  int index;

  printf("Enter array size: ");
  scanf("%d", &arr);

  int elem[arr];
  printf("Enter elements of array:\n");
  for(int i=0; i<arr; i++){
    scanf("%d", &elem[i]);
  }

  printf("\n");

  printf("Enter an index: ");
  scanf("%d", &index);
  index = elem[index];
  printf("%d", index);

  return 0;
}