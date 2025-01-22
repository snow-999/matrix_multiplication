package thread;

import matrix_maker.MatrixMaker;

public class MyThread extends Thread{

    private int[] rows;
    private MatrixMaker matrix;

    public MyThread(int[] rows, MatrixMaker matrix) {
        this.rows = rows;
        this.matrix = matrix;
    }

    @Override
    public void run() {

    }
}
