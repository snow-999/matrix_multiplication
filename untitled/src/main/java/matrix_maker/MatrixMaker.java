package matrix_maker;

import java.util.List;

public class MatrixMaker {

    private final int rows;
    private final int cols;
    public int[][] matrix;

    public MatrixMaker(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public void addToMatrix(List<Integer> numbers) {
        boolean checkForCorrectMatrix = numbers.size() > rows * cols || numbers.size() < rows * cols;
        if (checkForCorrectMatrix) {
            throw new ArrayIndexOutOfBoundsException("out of matrix size");
        }

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = numbers.get(index++);
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
