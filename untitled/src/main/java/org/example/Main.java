package org.example;

import matrix_services.MatrixServices;
import thread.MyThread;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // make the first matrix
        Scanner mat1Scanner = new Scanner(System.in);
        System.out.println("Enter Matrix1 Rows Number");
        int mat1RowsNumber = mat1Scanner.nextInt();
        System.out.println("Enter Matrix1 Cols Number");
        int mat1ColsNumber = mat1Scanner.nextInt();
        int mat1Size = mat1RowsNumber * mat1ColsNumber;
        List<Integer> matNumbers = new ArrayList<>();
        System.out.println("Enter Matrix1 Number");
        for (int i = 0; i < mat1Size; i++) {
            matNumbers.add(mat1Scanner.nextInt());
        }

        MatrixServices matrix1 = new MatrixServices(mat1RowsNumber, mat1ColsNumber, matNumbers);
        matrix1.addToMatrix();

        System.out.println("===================");

//      make the second matrix
        Scanner mat2Scanner = new Scanner(System.in);
        System.out.println("Enter Matrix2 Rows Number");
        int mat2RowsNumber = mat2Scanner.nextInt();
        System.out.println("Enter Matrix2 Cols Number");
        int mat2ColsNumber = mat2Scanner.nextInt();
        int mat2Size = mat2RowsNumber * mat2ColsNumber;
        List<Integer> mat2Numbers = new ArrayList<>();
        System.out.println("Enter Matrix2 Number");
        for (int i = 0; i < mat2Size; i++) {
            mat2Numbers.add(mat2Scanner.nextInt());
        }
        MatrixServices matrix2 = new MatrixServices(mat2RowsNumber, mat2ColsNumber, mat2Numbers);
        matrix2.addToMatrix();

        // make the final matrix
        int finalMatrixSize = mat1RowsNumber * mat2ColsNumber;
        List<Integer> finalMatrixNumbers = new ArrayList<>();
        List<Integer> syschorisedList = Collections.synchronizedList(finalMatrixNumbers);
        MatrixServices finalMatrix = new MatrixServices(mat1RowsNumber, mat2ColsNumber, syschorisedList);

        MyThread threadOne = new MyThread(matrix1, matrix2, finalMatrix);
        threadOne.start();
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        finalMatrix.addToMatrix();
        System.out.println(Arrays.deepToString(finalMatrix.matrix));
    }
}