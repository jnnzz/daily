import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

class LarocoActivity10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int col = 0;
        char choice = 'n';

        System.out.println("\n\033[1;36m*-----------SemiFinal-Lab Act#10 - 2D Arrays---------------*");
        System.out.println("    *--------------LAROCO, JAN LORENZ L.--------------*\033[0m");

        do {
            row = inputRow(scanner);
            col = inputCol(scanner);
            int[][] arr = new int[row][col];
            int dispRow = 0;
            int dispCol = 0;

            inputElements(row, col, arr, scanner);

            int max = displayMaximum(row, col, arr);

            displayElements(row, col, arr, max);
            System.out.printf("\033[1;33mThe maximum number is: %d\033[0m", max);

            displayRowCol(max, row, col, dispCol, dispRow, arr);

            System.out.print("\n\033[1;32mDo you want to try again? (y/n): \033[0m");
            choice = scanner.next().charAt(0);
            
        } while (choice == 'y' || choice == 'Y');

        System.out.println("\n\033[1;32mTHANK YOU!\033[0m");
        printRandomQuote();
        scanner.close();
    }
  //FUNCTIONS
    //inputRows
    static int inputRow(Scanner scanner) {
        int row = 0;
        while (true) {
            try {
                System.out.print("\n\033[1;34mEnter number of rows: \033[0m");
                row = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("\033[1;31mPlease enter a valid integer for rows: \033[0m");
                scanner.next();
            }
        }
        return row;
    }

    //inputColumns
    static int inputCol(Scanner scanner) {
        int col = 0;
        while (true) {
            try {
                System.out.print("\033[1;34mEnter number of columns: \033[0m");
                col = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("\033[1;31mPlease enter a valid integer for columns: \n\033[0m");
                scanner.next();
            }
        }
        return col;
    }

    //inputElements
    static void inputElements(int row, int col, int[][] arr, Scanner scanner) {
        System.out.println("\n\033[1;35mEnter values for rows and columns (between 1-100 only)\033[0m");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("\033[1;34mFor row %d, col %d: \033[0m", i + 1, j + 1);
                try {
                    arr[i][j] = scanner.nextInt();
                    if (arr[i][j] > 100 || arr[i][j] < 1) {
                        System.out.println("\033[1;31mOUT OF RANGE. ENTER BETWEEN 1-100 ONLY. PLEASE TRY AGAIN!\033[0m");
                        j--;
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\033[1;31mPlease enter a valid integer. Try again.\033[0m");
                    scanner.next();
                    j--;
                }
            }
        }
    }

    //displayElements
    static void displayElements(int row, int col, int[][] arr, int max) {
        System.out.println();
        System.out.printf("\033[1;35m<----------------------------------->\n\033[0m");
        System.out.println("\n\033[1;36mElements of the array:\033[0m");
        System.out.println();
        System.out.printf("      ");

        for (int j = 0; j < arr[0].length; j++) {
            System.out.printf("\033[1;34mCol%-3d  \033[0m", j + 1);
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.println();
            System.out.printf("\033[1;34mRow%-4d\033[0m", i + 1);
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == max) {
                    System.out.printf("\033[1;33m%-8d\033[0m", arr[i][j]);
                } else {
                    System.out.printf("%-8d", arr[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.printf("\033[1;35m<----------------------------------->\n\033[0m");
        System.out.println();
    }

    //displayMax
    static int displayMaximum(int row, int col, int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    //displayROW-COL
    static void displayRowCol(int max, int row, int col, int dispCol, int dispRow, int[][] arr) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max == arr[i][j]) {
                    dispRow = i;
                    dispCol = j;
                }
            }
        }
        System.out.printf("\n\033[1;33mLocated at row %d, column %d.\033[0m", dispRow + 1, dispCol + 1);
        System.out.println();
    }

    //QUOTE
    static void printRandomQuote() {
        String[] quotes = {
                "The only way to do great work is to love what you do. - Steve Jobs",
                "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
                "The road to success and the road to failure are almost exactly the same.- Colin R. Davis",
                "Success usually comes to those who are too busy to be looking for it. - Henry David Thoreau",
                "Opportunities don't happen. You create them. - Chris Grosser"
        };

        Random rand = new Random();
        int index = rand.nextInt(quotes.length);
        String[] colors = {"\033[1;31m", "\033[1;32m", "\033[1;33m", "\033[1;34m", "\033[1;35m", "\033[1;36m"};
        int colorIndex = rand.nextInt(colors.length);
        System.out.printf("\n%s%s\033[0m\n", colors[colorIndex], quotes[index]);
    }
}
