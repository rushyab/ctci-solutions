package Q1_8_Zero_Matrix;

/**
 * Zero Matrix: Write an algorithm such that if an element in a MxN matrix is 0,
 * its entire row an d column are set to 0.
 */

public class QuestionA {

    public static void setZeros(int[][] matrix) {

        boolean[] row =  new boolean[matrix.length];
        boolean[] column =  new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < matrix.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        // Nullify columns
        for (int j = 0; j < matrix[0].length; j++) {
            if (column[j]) nullifyColumn(matrix, j);
        }

    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 3}, {4, 5, 6}, {7, 8, 0}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print("matrix["+i+"]["+j+"]: " + matrix[i][j] + " | ");
            System.out.println();
        }

        System.out.println();
        setZeros(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print("matrix["+i+"]["+j+"]: " + matrix[i][j] + " | ");
            System.out.println();
        }
    }
}
