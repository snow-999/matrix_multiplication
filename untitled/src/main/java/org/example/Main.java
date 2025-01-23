package org.example;

import matrix_services.MatrixServices;
import thread.MyThread;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // make the first matrix
        Scanner mat1Scanner = new Scanner(System.in);
        System.out.println("Enter First Matrix Rows Number");
        int mat1RowsNumber = mat1Scanner.nextInt();
        System.out.println("Enter First Matrix Cols Number");
        int mat1ColsNumber = mat1Scanner.nextInt();
        int mat1Size = mat1RowsNumber * mat1ColsNumber;
        List<Integer> mat1Numbers = new ArrayList<>();
        System.out.println("Enter First Matrix Number (Your Matrix Should Contain )" + mat1Size);
        for (int i = 0; i < mat1Size; i++) {
            mat1Numbers.add(mat1Scanner.nextInt());
        }

        MatrixServices matrix1 = new MatrixServices(mat1RowsNumber, mat1ColsNumber, mat1Numbers);
        matrix1.addToMatrix();

        System.out.println();

        System.out.println("===================");

//      make the second matrix
        Scanner mat2Scanner = new Scanner(System.in);
        System.out.println("Enter Second Matrix Rows Number");
        int mat2RowsNumber = mat2Scanner.nextInt();
        System.out.println("Enter Second Matrix Cols Number");
        int mat2ColsNumber = mat2Scanner.nextInt();
        int mat2Size = mat2RowsNumber * mat2ColsNumber;
        List<Integer> mat2Numbers = new ArrayList<>();
        System.out.println("Enter Second Matrix Number (Your Matrix Should Contain )" + mat2Size);
        for (int i = 0; i < mat2Size; i++) {
            mat2Numbers.add(mat2Scanner.nextInt());
        }

        MatrixServices matrix2 = new MatrixServices(mat2RowsNumber, mat2ColsNumber, mat2Numbers);
        matrix2.addToMatrix();

        // make the final matrix
        List<Integer> finalMatrixNumbers = new ArrayList<>();
        List<Integer> syschorisedList = Collections.synchronizedList(finalMatrixNumbers);
        MatrixServices finalMatrix = new MatrixServices(mat1RowsNumber, mat2ColsNumber, syschorisedList);

        for (int i = 0; i < mat1RowsNumber; i++) {
            MyThread thread = new MyThread(matrix1.getRow(i), matrix2, finalMatrix);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        finalMatrix.addToMatrix();
        System.out.println("Here Is The Result of Multiplication Two Matrices");
        finalMatrix.printMatrix();
    }
}