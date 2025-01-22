package org.example;

import matrix_maker.MatrixMaker;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int mat1RowsNumber = 2;
        int mat1ColsNumber = 3;
        MatrixMaker matrix1 = new MatrixMaker(mat1RowsNumber, mat1ColsNumber);
        List<Integer> matNumbers = List.of(2, 3, 1, 2, -7, 4);
        matrix1.addToMatrix(matNumbers);
        matrix1.printMatrix();

        System.out.println("===================");

        int mat2RowsNumber = 3;
        int mat2ColsNumber = 3;
        MatrixMaker matrix2 = new MatrixMaker(mat2RowsNumber, mat2ColsNumber);
        List<Integer> mat2Numbers =List.of(3, 4, 5, 1, 1, 4, 2, 1, 4);
        matrix2.addToMatrix(mat2Numbers);
        matrix2.printMatrix();
    }
}