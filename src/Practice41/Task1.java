package Practice41;

import java.util.Scanner;
import java.util.Random;
public class Task1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row, column;
        System.out.println("Введите размер матрицы");
        System.out.print("Число строк: ");
        row = s.nextInt();
        System.out.print("Число столбцов: ");
        column = s.nextInt();
        Matrix matrix = new Matrix(row,column);
        Matrix newMatrix = new Matrix(row, column);

        System.out.println("Матрица #1:");
        matrix.showMatrix();
        System.out.println("Матрица #2:");
        newMatrix.showMatrix();
        System.out.println("Результат сложения матриц #1 и #2:");
        matrix.sumMatrix(newMatrix);
        Random rand = new Random();
        int digit = rand.nextInt(0, 6);
        System.out.printf("Результат умножения матрицы #1 на число %d:\n", digit);
        matrix.multByNumber(digit);
        System.out.println("Результат умножения матрицы #1 на матрицу #2:");
        matrix.multMatrix(newMatrix);
    }
}

class Matrix {
    private int[][] values;
    private int row;
    private int column;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        values = new int[row][column];
        Random rand = new Random();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                values[i][j] = rand.nextInt(0, 6);
            }
        }
    }

    public void sumMatrix(Matrix m) {
        if(this.row == m.row && this.column == m.column) {
            Matrix matrixTmp = new Matrix(row, column);
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < column; j++) {
                    matrixTmp.values[i][j] = values[i][j] + m.values[i][j];
                }
            }
            matrixTmp.showMatrix();
        }
        else {
            System.out.println("Ошибка! Матрицы должны быть одного размера");
        }
    }

    public void multByNumber(int digit) {
        Matrix matrixTmp = new Matrix(row, column);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                matrixTmp.values[i][j] = values[i][j] * digit;
            }
        }
        matrixTmp.showMatrix();
    }

    public void multMatrix(Matrix m) {
        if(this.column == m.row) {
            Matrix matrixTmp = new Matrix(row, m.column);
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < m.column; j++) {
                    int tmp = 0;
                    for(int k = 0; k < column; k++) {
                        tmp += values[i][k] * m.values[k][j];
                    }
                    matrixTmp.values[i][j] = tmp;
                }
            }
            matrixTmp.showMatrix();
        }
        else {
            System.out.println("Ошибка умножения матриц");
        }
    }

    public void showMatrix() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(j < column - 1) System.out.printf("%d\t\t", values[i][j]);
                else System.out.printf("%d\n", values[i][j]);
            }
        }
    }
}
