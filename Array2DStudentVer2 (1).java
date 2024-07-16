class Student
{
   String name;
   int grade;
}

class Array2DStudentVer2
{
   public static void main(String[] args)
   {
      int sections = 2, NoOfStuds=3;
      
      Student[][] student = new Student[sections][NoOfStuds];
      String[] section = {"Section 1","Section 2"};
      
      for (int i=0; i<student.length; i++)
         for (int j=0; j<student[0].length; j++)
            student[i][j] = new Student();
      // Section 1
      student[0][0].name = "Amanda";
      student[0][0].grade = 82;
      student[0][1].name = "Nicole";
      student[0][1].grade = 90;
      student[0][2].name = "Arthur";
      student[0][2].grade = 77;
      
      // Section 2
      student[1][0].name = "Steve";
      student[1][0].grade = 89;
      student[1][1].name = "Wanda";
      student[1][1].grade = 80;
      student[1][2].name = "Jarvis";
      student[1][2].grade = 100;

      displayArray(student,section);
      for (int k=0; k<sections; k++)
         for (int i=0; i<NoOfStuds-1; i++)
            for (int j=i+1; j<NoOfStuds; j++)
            {
               if (student[k][i].grade<student[k][j].grade)
               {
                  Student temp = student[k][i];
                  student[k][i] = student[k][j];
                  student[k][j] = temp;
               }
            }
      displayArray(student,section);
      for(int i=0; i<student.length-1; i++)
         for (int j=i+1; j<student.length; j++)
            if (student[i][0].grade<student[j][0].grade)
            {
               Student[] temp = student[i];
               student[i] = student[j];
               student[j] = temp;
               
               String tmpSect = section[i];
               section[i] = section[j];
               section[j] = tmpSect;
            }
      
      displayArray(student,section);
   }
   static void displayArray(Student[][] studAr, String[] sec)
   {
      System.out.println();
      for (int x=0; x<studAr.length; x++)
      {
         System.out.printf("%-15s => ",sec[x]);
         for(int y=0; y<studAr[0].length; y++)
         {
            System.out.printf("%-10s(%3d)  ||  ",studAr[x][y].name,studAr[x][y].grade);
         }
         System.out.println();
      }  
   }
}