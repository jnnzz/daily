
#include <stdio.h>

int main(){
    int jan = 918374;
    int even, eNum = 0, odd, oNum = 0;
    int placeEven = 1, placeOdd = 1;

    int check;
    while(jan > 0){
      check = jan % 10;
      if(check % 2 == 0){
        even = check * placeEven;
        eNum += even;
        placeEven *= 10;
      } else{
        odd = check * placeOdd;
        oNum += odd;
        placeOdd *= 10;
      }
      jan /= 10;
    }
    printf("Even numbers: %d\n", eNum);
    printf("Odd numbers: %d", oNum);


	return 0;
}