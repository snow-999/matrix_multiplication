package matrix_services;

import java.util.ArrayList;
import java.util.List;

public class MatrixServices {

    private final int rows;
    private final int cols;
    public final List<Integer> numbers;
    public int[][] matrix;

    public MatrixServices(int rows, int cols, List<Integer> numbers) {
        this.rows = rows;
        this.cols = cols;
        this.numbers = numbers;
        this.matrix = new int[rows][cols];
    }

    public void addToMatrix() {
        boolean wrongConditionMakingMatrix = numbers.size()!= rows * cols;
        if (wrongConditionMakingMatrix) {
            throw new IndexOutOfBoundsException("out of matrix size");
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

    public List<Integer> getRow(int rowNumber) {
        boolean wrongConditions = rowNumber <= 0 || rowNumber > rows;
        if (wrongConditions) {
            throw new ArrayIndexOutOfBoundsException("out of matrix size");
        }
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            row.add(matrix[rowNumber - 1][i]);
        }
        return row;
    }

    public List<Integer> getCol(int colNumber) {
        boolean wrongConditions = colNumber <= 0 || colNumber > cols;
        if (wrongConditions) {
            throw new ArrayIndexOutOfBoundsException("out of matrix size");
        }
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            col.add(matrix[i][colNumber - 1]);
        }
        return col;
    }
}
