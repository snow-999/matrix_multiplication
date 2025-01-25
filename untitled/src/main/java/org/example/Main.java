package org.example;

import matrix_services.MatrixService;
import thread.MyThread;

import java.util.*;

public class Main {

    public static MatrixService scanMatrix() {
        Scanner matScanner = new Scanner(System.in);
        System.out.println("Enter Matrix Rows Number");
        int matRowsNumber = matScanner.nextInt();
        System.out.println("Enter Matrix Cols Number");
        int matColsNumber = matScanner.nextInt();
        int matSize = matRowsNumber * matColsNumber;
        List<Integer> matNumbers = new ArrayList<>();
        System.out.println("Enter Matrix Number (Your Matrix Should Contain " + matSize +")");
        for (int i = 0; i < matSize; i++) {
            matNumbers.add(matScanner.nextInt());
        }
        MatrixService matrix = new MatrixService(matRowsNumber, matColsNumber, matNumbers);
        matrix.addToMatrix();
        return matrix;
    }

    public static void main(String[] args) {

        // make the first matrix
        /*
         * 2 3 1
         * 2 -7 4
         */
        MatrixService firstMatrix = scanMatrix();

        System.out.println();
        System.out.println("===================");

//      make the second matrix
        /*
         * 3 4 5
         * 1 1 4
         * 2 1 4
         **/
        MatrixService secondMatrix = scanMatrix();

        // check if two matrices could be multiplied
        if (firstMatrix.cols != secondMatrix.rows) {
            System.out.println("Can't Multiplication These Matrix");
            return;
        }

        int finalMatrixSize = firstMatrix.cols * secondMatrix.rows;
        List<Integer> syschorisedList = Collections.synchronizedList(new ArrayList<>(finalMatrixSize));

        // make final matrix
        MatrixService finalMatrix = new MatrixService(firstMatrix.rows, secondMatrix.cols, syschorisedList);

        List<MyThread> threads = new ArrayList<>();
        for (int i = 0; i < firstMatrix.rows; i++) {
            for (int j = 0; j < secondMatrix.cols; j++) {
                threads.add(new MyThread(firstMatrix.getRow(i), secondMatrix.getCol(j), finalMatrix, i, j));
            }
        }

        for (MyThread myThread : threads) {
            myThread.start();
        }

        for (MyThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Here Is The Result of Multiplication Two Matrices");
        finalMatrix.printMatrix();
    }
}