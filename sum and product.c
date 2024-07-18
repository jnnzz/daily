#include <stdio.h>

int main(){
  int firstArr, secondArr;

  printf("Enter size of the first array: ");
  scanf("%d", &firstArr);

  int elem1[firstArr];

  printf("Enter the elements of the first array:\n");
    for (int i = 0; i < firstArr; i++) {
        printf("Element %d: ", i + 1);
        scanf("%d", &elem1[i]);
    }

//secondddd
  printf("\n");

  printf("Enter size of the second array: ");
  scanf("%d", &secondArr );

  int elem2[secondArr];

  printf("Enter the elements of the second array:\n");
    for(int i=0; i<secondArr; i++){
      printf("Element %d: ", i + 1);
      scanf("%d", &elem2[i]);
    }

  printf("\n");

  int sum = elem1[0] + elem2[secondArr - 1];
  printf("Sum of first and last: %d", sum);

  printf("\n");

  int product = elem1[1] * elem2[secondArr - 2];
  printf("Product of second and second of the last: %d", product);

  return 0;
}