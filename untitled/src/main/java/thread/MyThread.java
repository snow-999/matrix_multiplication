package thread;

import matrix_services.MatrixServices;

import java.util.List;

public class MyThread extends Thread{

    private List<Integer> rows;
    private MatrixServices matrix;
    private MatrixServices result;

    public MyThread(List<Integer> rows, MatrixServices matrix, MatrixServices result) {
        this.rows = rows;
        this.matrix = matrix;
        this.result = result;
    }

    @Override
    public void run() {

    }
}
