package Q1_7_Rotate_Matrix;

/**
 * Rotate Matrix: Given a image represented in NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class QuestionA {

    // function to rotate the matrix Clockwise by 90 degrees
    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square

        int n = matrix.length;
        for (int first = 0; first < n/2; first++) {
            int last = n - 1 - first;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
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
