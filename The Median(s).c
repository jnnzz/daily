#include <stdio.h>

int main(){
  int arr;
  

  printf("Enter array size: ");
  scanf("%d", &arr);

  int elem[arr];
  printf("Enter elements of the array: \n");
  for(int i=0; i<arr; i++){
    scanf("%d", &elem[i]);
  }
  
  int num = arr/2;
  int median;
  median = elem[num];

  printf("Median(s):%d ", median);



  return 0;
}