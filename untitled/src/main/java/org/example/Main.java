package org.example;

import matrix_services.MatrixServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
//        mat1Scanner.close();
        MatrixServices matrix1 = new MatrixServices(mat1RowsNumber, mat1ColsNumber, matNumbers);
        matrix1.addToMatrix();
        matrix1.printMatrix();

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
        matrix2.printMatrix();

        // final matrix (result)
//        int finalMatRows= 2;
//        int finalMatCols= 3;
//        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
//        MatrixMaker finalMat = new MatrixMaker(finalMatRows, finalMatCols, synchronizedList);
//        finalMat.addToMatrix();

        System.out.println("=======================");
        List<Integer> row = matrix1.getRow(1);
        List<Integer> col = matrix1.getCol(1);
        System.out.println(col);


//        MyThread th1 = new MyThread(row, matrix2, finalMat);







    }
}