package com.matrix3;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class Matrix {
    public double arr[][];
    public int rows, cols;


    public Matrix (int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        arr = new double[rows][cols];
    }

    public Matrix(JSpinner arr[][]) {
        rows = arr.length;
        cols = arr[0].length;
        this.arr = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                this.arr[i][j] = (double)arr[i][j].getValue();
        }
    }

    public static void Add(Matrix m1, Matrix m2) {
        if (m1.rows == m2.rows &&
                m1.cols == m2.cols) {
            for (int i = 0; i < m1.rows; i++) {
                for (int j = 0; j < m1.cols; j++) {
                    m1.arr[i][j] += m2.arr[i][j];
                }
            }
            JOptionPane.showMessageDialog(null, m1.print());
        } else {
            JOptionPane.showMessageDialog(null, "Количество строк и столбцов не совпадает");
        }



    }

    public static void Sub(Matrix m1, Matrix m2) {
        if (m1.rows == m2.rows &&
                m1.cols == m2.cols) {
            for (int i = 0; i < m1.rows; i++) {
                for (int j = 0; j < m1.cols; j++) {
                    m1.arr[i][j] -= m2.arr[i][j];
                }
            }
            JOptionPane.showMessageDialog(null, m1.print());
        } else {
            JOptionPane.showMessageDialog(null, "Количество строк и столбцов не совпадает");
        }

    }

    public static void Mul(Matrix m1, Matrix m2) {
        Matrix res = new Matrix(m1.rows, m2.cols);
        if (m1.cols == m2.rows) {
            for (int i = 0; i < m1.rows; i++) {
                for (int j = 0; j < m2.cols; j++) {
                    for(int k=0; k < m2.rows; k++) {
                        res.arr[i][j] += m1.arr[i][k]*m2.arr[k][j];
                    }
                }
            }
            JOptionPane.showMessageDialog(null, res.print());
        } else {
            JOptionPane.showMessageDialog(null, "Количество строк и столбцов не совпадает");
        }
    }

    public String print() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                str += String.valueOf(arr[i][j]) + " ";
            }
            str += '\n';
        }
        return str;
    }

}
