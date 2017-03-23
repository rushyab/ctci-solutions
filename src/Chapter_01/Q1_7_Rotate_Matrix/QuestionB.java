package Q1_7_Rotate_Matrix;

public class QuestionB {

    // function to rotate the matrix Anti-clockwise by 90 degrees
    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square

        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for(int j = i; j < n-1-i; j++) {
                int temp = matrix[i][j];

                // move values from right to top
                matrix[i][j] = matrix[j][n-1-i];

                // move values from bottom to right
                matrix[j][n-1-i] = matrix[n-1-i][n-1-j];

                // move values from left to bottom
                matrix[n-1-i][n-1-j] = matrix[n-1-j][i];

                // assign temp to left
                matrix[n-1-j][i] = temp;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print("matrix["+i+"]["+j+"]: " + matrix[i][j] + " | ");
            System.out.println();
        }

        System.out.println();
        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print("matrix["+i+"]["+j+"]: " + matrix[i][j] + " | ");
            System.out.println();
        }
    }
}

