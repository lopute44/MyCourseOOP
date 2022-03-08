package academitschool.oop.ilina.matrix.main;

import academitschool.oop.ilina.matrix.Matrix;
import academitschool.oop.ilina.vector.Vector;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5,3);

        System.out.println(matrix);

        Matrix matrix1 = new Matrix(matrix);

        System.out.println("Матрица из другой матрицы");
        System.out.println(matrix1);

        double[][] array = {{1, 2, 3},
                {3,4,5,6},
                {8,9,8,10,11,12}};

        System.out.println("Матрица из массива двумерного массива вещественных чисел");
        Matrix matrix2 = new Matrix(array);
        System.out.println(matrix2);

        Vector vector1 = new Vector(5, new double[]{1, 2, 3, 4, 5});
        Vector vector2 = new Vector(3, new double[]{10, 20, 30});
        Vector vector3 = new Vector(3, new double[]{10});

        Vector[] arrayVectors = {vector1, vector2, vector3};

        System.out.println("Матрица из массива векторов");
        Matrix matrix3 = new Matrix(arrayVectors);
        System.out.println(matrix3);

        System.out.println("Размер матрицы: " + matrix3.getSize()[0] + ", " + matrix3.getSize()[1]);

        System.out.println("Вектор из матрицы с индексом 1: " + matrix3.getVectorByIndex(1));

        System.out.println("Матрица после замены вектора с индексом 1:");
        matrix3.setVectorByIndex(vector1, 1);
        System.out.println(matrix3);

        System.out.println("Вектор из столбца по индексу 1: " + matrix3.getColumnByIndex(1));

        System.out.println("Матрица после транспонирования:");
        matrix3.transposeMatrix();
        System.out.println(matrix3);

        System.out.println("Матрица после умножения на скаляр равный 3:");
        matrix3.increaseByScalar(3);
        System.out.println(matrix3);

        System.out.println("Матрица после умножения на вектор:");
        matrix3.increaseByVector(vector2);
        System.out.println(matrix3);

        Matrix matrix4 = new Matrix(matrix3);

        System.out.println("Матрица после сложения:");
        matrix3.getUnion(matrix4);
        System.out.println(matrix3);

        System.out.println("Матрица после вычитания:");
        matrix3.getDifference(matrix4);
        System.out.println(matrix3);

        System.out.println("Сложение двух матриц с помощью статического метода:");
        Matrix matrix5 = Matrix.getUnion(matrix3, matrix4);
        System.out.println(matrix5);

        System.out.println("Вычитание двух матриц с помощью статического метода:");
        Matrix matrix6 = Matrix.getDifference(matrix5, matrix4);
        System.out.println(matrix6);

        System.out.println("Результат умножения двух матриц с помощью статического метода:");
        Matrix matrix7 = Matrix.getIncreaseOfMatrix(matrix3, matrix4);
        System.out.println(matrix7);

        double[][] array1 = {{1, 2, 3},
                {3,4,5},
                {8,9,8}};

        Matrix matrix8 = new Matrix(array1);

        System.out.println("Значение определителя матрицы:");
        System.out.println(matrix8.getDeterminant());
    }
}
