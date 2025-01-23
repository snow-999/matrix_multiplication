package org.example;

import matrix_services.MatrixServices;
import thread.MyThread;

import java.util.*;

public class Main {

    public static MatrixServices scanMatrix() {
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
        MatrixServices matrix = new MatrixServices(matRowsNumber, matColsNumber, matNumbers);
        matrix.addToMatrix();
        return matrix;
    }

    public static void main(String[] args) {

        // make the first matrix
        MatrixServices firstMatrix = scanMatrix();
        firstMatrix.printMatrix();

        System.out.println();
        System.out.println("===================");

//      make the second matrix
        MatrixServices secondMatrix = scanMatrix();

        // check if two matrices could be multiplied
        if (firstMatrix.cols != secondMatrix.rows) {
            System.out.println("Can't Multiplication These Matrix");
            return;
        }

        List<Integer> syschorisedList = Collections.synchronizedList(new ArrayList<>());

        // make final matrix
        MatrixServices finalMatrix = new MatrixServices(firstMatrix.rows, secondMatrix.cols, syschorisedList);

        List<MyThread> threads = new ArrayList<>(firstMatrix.rows);
        for (int i = 0; i < firstMatrix.rows; i++) {
            threads.add(new MyThread(firstMatrix.getRow(i), secondMatrix, finalMatrix));
            threads.get(i).start();
        }

        for (MyThread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        finalMatrix.addToMatrix();
        System.out.println("Here Is The Result of Multiplication Two Matrices");
        finalMatrix.printMatrix();


    }
}