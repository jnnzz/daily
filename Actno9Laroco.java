/*NAME: JAN LORENZ L. LAROCO
  DATE: 4/7/24
  DESCRIPTION: ARRAY OF OBJECTS
*/

import java.util.Scanner;

class Student{
    String name;
    int[] grades;
    int sum;
    int size;
	  double average;
    
    String getName(){
        return name;
    }
    
    double getAverage(){
        sum = 0;
        for (int i = 0; i<grades.length; i++){
            sum += grades[i];
        }
    	average = (double) sum/size;
		return average;
    }
    
    int getMin(){
        int min=grades[0];
          for(int i=0; i<grades.length; i++){
            if(grades[i] < min)
              min = grades[i];
          }
        return min;
  }
}


//MAIN
class Actno9Laroco
{
	public static void main(String[] args) {
	    Scanner scanner= new Scanner(System.in);
	    String choice = "";
        int size;
        int sizeGrade;
        
        do{
            System.out.printf("-------------");
            System.out.printf("\nStudent size: ");
            size = scanner.nextInt();
            System.out.printf("Enter number of grades to calculate: ");
            sizeGrade = scanner.nextInt();
            Student[] student = new Student[size];                            //1. Declaration  and 2. Array object

          //INITIALIZE
    	    for(int i=0; i<student.length; i++){                                //3. Initialize each elements
    	        student[i] = new Student();
    	        student[i].grades = new int[sizeGrade];
    	        student[i].size = sizeGrade;
    	        System.out.printf("\n");
    			System.out.printf("Name of student #%d: ", i+1);
    			student[i].name = scanner.next();
    
        	        for(int j=0; j<sizeGrade; j++){
        	            System.out.printf("Enter grade #%d: ", j+1);
        	            student[i].grades[j] = scanner.nextInt();
        	        }
    			scanner.nextLine();
    	    }

          //ORIGINAL-ARR
          System.out.printf("\n");
    	    System.out.printf("----------Original array----------");
    	    for(int i=0; i<student.length; i++){
    	        System.out.printf("\nName: %s     Average: %.2f   Min: %d", student[i].name, student[i].getAverage(), student[i].getMin());
    	    }
    	    System.out.printf("\n");
    	    
    	    //forSORTING
    	    for(int i=0; i<student.length-1; i++){
    	        for(int j=0; j<student.length-i-1; j++){
    	            if (student[j].getAverage() < student[j + 1].getAverage()) {
                        Student temp = student[j];
                        student[j] = student[j + 1];
                        student[j + 1] = temp;
                    }
    	        }
    	    }

          //DISPLAY
    	    System.out.printf("\n");
    	    System.out.printf("Students sorted from highest average to lowest.");
    	    for(int i=0; i<student.length; i++){
    	        System.out.printf("\nName: %s     Average: %.2f   Min: %d", student[i].name, student[i].getAverage(), student[i].getMin());
    	    }
    	    
          //CHOICE
    	    System.out.println("\n");
    	    System.out.printf("--------------------------------------------\n");
    	    System.out.printf("Do you want to calculate again? (yes or no): ");
    	    choice = scanner.nextLine();

        }while(choice.equals("yes"));

			scanner.close();
	}
}