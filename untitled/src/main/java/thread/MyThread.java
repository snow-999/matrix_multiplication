package thread;

import matrix_services.MatrixServices;

import java.util.List;

public class MyThread extends Thread{

    private MatrixServices matrixOne;
    private MatrixServices matrixTwo;
    private MatrixServices finalMatrix;

    public MyThread(MatrixServices matrixOne, MatrixServices matrixTwo, MatrixServices finalMatrix) {
        this.matrixOne = matrixOne;
        this.matrixTwo = matrixTwo;
        this.finalMatrix = finalMatrix;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < matrixOne.rows) {
            List<Integer> row = matrixOne.getRow(i);
            for (int j = 0; j < matrixTwo.cols; j++) {
                int temp = 0;
                List<Integer> col = matrixTwo.getCol(j);
                for (int k = 0; k < row.size(); k++) {
                    temp += row.get(k) * col.get(k);
                }
                finalMatrix.numbers.add(temp);
            }
            i++;
        }
    }
}
