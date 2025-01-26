package matrix_services;

import java.util.ArrayList;
import java.util.List;

public class MatrixService {

    public final int rows;
    public final int cols;
    public int[][] matrix;

    public MatrixService(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            if (i != rows - 1) {
                System.out.println();
            }
        }
    }

    public List<Integer> getRow(int rowNumber) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            row.add(matrix[rowNumber][i]);
        }
        return row;
    }

    public List<Integer> getCol(int colNumber) {
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            col.add(matrix[i][colNumber]);
        }
        return col;
    }
}
