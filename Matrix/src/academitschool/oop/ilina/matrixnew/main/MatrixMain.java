package academitschool.oop.ilina.matrixnew.main;

import academitschool.oop.ilina.matrixnew.Matrix;
import academitschool.oop.ilina.vector.Vector;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(8, 2);

        System.out.println("Матрица с нулями: ");
        System.out.println(matrix1);

        Matrix matrix2 = new Matrix(matrix1);

        System.out.println("Матрица из другой матрицы");
        System.out.println(matrix2);

        double[][] array1 = {
                {1, 2, 3},
                {3, 4, 5, 6},
                {8, 9, 8, 10, 11, 12},
                {8}
        };

        System.out.println("Матрица из двумерного массива вещественных чисел");
        Matrix matrix3 = new Matrix(array1);
        System.out.println(matrix3);

        Vector vector1 = new Vector(5, new double[]{1, 2, 3, 4, 5});
        Vector vector2 = new Vector(3, new double[]{10, 20, 30});
        Vector vector3 = new Vector(1, new double[]{10});

        Vector[] vectorsArray = {vector1, vector2, vector3};

        System.out.println("Матрица из массива векторов");
        Matrix matrix4 = new Matrix(vectorsArray);
        System.out.println(matrix4);

        System.out.println("Размер матрицы: " + matrix3.getRowsAmount() + ", " + matrix4.getColumnsAmount());

        System.out.println("Вектор из матрицы с индексом 1: " + matrix4.getRowByIndex(1));

        System.out.println("Матрица после замены вектора с индексом 1:");
        matrix4.setVectorByIndex(1, vector1);
        System.out.println(matrix4);

        System.out.println("Вектор из столбца по индексу 1: " + matrix4.getColumnByIndex(1));

        System.out.println();

        System.out.println("Матрица после транспонирования:");
        matrix4.transpose();
        System.out.println(matrix4);

        System.out.println("Матрица после умножения на скаляр равный 3:");
        matrix4.multiplyByScalar(3);
        System.out.println(matrix4);

        double[][] array2 = {
                {1, 2, 3},
                {3, 4, 5},
                {8, 9, 8}
        };

        Matrix matrix5 = new Matrix(array2);

        System.out.println("Значение определителя матрицы:");
        System.out.println(matrix5.getDeterminant());

        System.out.println("Результат умножения матрицы на вектор: " + matrix5.multiplyByVector(vector2));

        Matrix matrix6 = new Matrix(array2);
        Matrix matrix7 = new Matrix(array2);

        System.out.println("Матрица после сложения:");
        matrix6.sum(matrix7);
        System.out.println(matrix6);

        System.out.println("Матрица после вычитания:");
        matrix6.subtract(matrix7);
        System.out.println(matrix6);

        System.out.println("Сложение двух матриц с помощью статического метода:");
        Matrix matrix8 = Matrix.getSum(matrix6, matrix7);
        System.out.println(matrix8);

        System.out.println("Вычитание двух матриц с помощью статического метода:");
        Matrix matrix9 = Matrix.getSubtract(matrix8, matrix7);
        System.out.println(matrix9);

        double[][] array3 = {
                {1, 2, 3, 6},
                {3, 4, 5, 2},
                {8, 9, 8, 5}
        };

        double[][] array4 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };

        Matrix matrix10 = new Matrix(array3);

        Matrix matrix11 = new Matrix(array4);

        System.out.println("Результат умножения двух матриц с помощью статического метода:");
        Matrix matrix12 = Matrix.getMultiplication(matrix10, matrix11);
        System.out.println(matrix12);
    }
}
