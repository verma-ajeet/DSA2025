public class DiamondPattern {
    public static void main(String[] args) {
        // Sample input for testing
        String input = "3";

        // Calling the solution method
        solution(input);
    }

    public static void solution(String n) {
        // Convert the input string to an integer
        int num = Integer.parseInt(n);

        printDiamondPattern(num);
    }


    private static void printDiamondPattern(int n) {
    	int rows = n;

        for (int i = 1; i <= rows; i++) {
            // Print leading spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(rows - i + 1);
                }
            }

            System.out.println();
        }

        // Print the bottom half (mirror of the top)
        for (int i = rows - 1; i >= 1; i--) {
            // Print leading spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(rows - i + 1);
                }
            }

            System.out.println();
        }
//        for (int i = 1; i <= n; i++) {
//            printSpaces(n - i);
//            printNumbers(n);
//            printSpaces(n - i);
//            System.out.println();
//        }

//        for (int i = n - 1; i >= 1; i--) {
//            printSpaces(n - i);
//            printNumbers(i);
//            System.out.println();
//        }
    }

	private static void printNumbers(int n) {
//		for(int i=n;)
	}

	private static void printSpaces(int n) {
		for(int i=0;i<n;i++) {
			System.out.print("*");
		}
	}


}
