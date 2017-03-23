package Q1_8_Zero_Matrix;

public class QuestionB {

    public static void setZeros(int[][] matrix) {

        boolean rowHasZero = false;
        boolean columnHasZero = false;

        // Check if first column has a zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        // Check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Nullify rows based on values in first column
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0)  nullifyRow(matrix, i);
        }

        // Nullify columns based on values in first row
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0)  nullifyColumn(matrix,  j);
        }

        // Nullify first row
        if (rowHasZero){
            nullifyRow(matrix, 0);
        }

        // Nullify first column
        if (columnHasZero) {
            nullifyColumn(matrix, 0);
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
