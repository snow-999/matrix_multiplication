package thread;

import matrix_services.MatrixService;

import java.util.List;

public class MyThread extends Thread{

    private List<Integer> row;
    private List<Integer> col;
    private MatrixService finalMatrix;
    private int rowIndex;
    private int colIndex;

    public MyThread(List<Integer> row, List<Integer> col, MatrixService finalMatrix, int rowIndex, int colIndex) {
        this.row = row;
        this.col = col;
        this.finalMatrix = finalMatrix;
        this.colIndex = colIndex;
        this.rowIndex = rowIndex;
    }

    @Override
    public void run() {
        System.out.println(col);
        int temp = 0;
        for (int j = 0; j < row.size(); j++) {
            temp += row.get(j) * col.get(j);
        }
        finalMatrix.matrix[rowIndex][colIndex] = temp;
    }
}