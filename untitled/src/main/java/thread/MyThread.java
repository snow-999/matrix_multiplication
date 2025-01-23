package thread;

import matrix_services.MatrixServices;

import java.util.List;

public class MyThread extends Thread{

    private List<Integer> row;
    private MatrixServices matrixTwo;
    private MatrixServices finalMatrix;

    public MyThread(List<Integer> row, MatrixServices matrixTwo, MatrixServices finalMatrix) {
        this.row = row;
        this.matrixTwo = matrixTwo;
        this.finalMatrix = finalMatrix;
    }

    @Override
    public void run() {
            for (int i = 0; i < matrixTwo.cols; i++) {
                int temp = 0;
                List<Integer> col = matrixTwo.getCol(i);
                for (int j = 0; j < row.size(); j++) {
                    temp += row.get(j) * col.get(j);
                }
                finalMatrix.numbers.add(temp);
            }
    }
}
