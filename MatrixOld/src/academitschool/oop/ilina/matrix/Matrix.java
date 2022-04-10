package academitschool.oop.ilina.matrix;

import academitschool.oop.ilina.vector.Vector;
import java.util.Arrays;

public class Matrix {
    private Vector[] arrayVectors;

    public Vector[] getArrayVectors() {
        return arrayVectors;
    }

    public Matrix(int n, int m) {
        arrayVectors = new Vector[m];

        for (int i = 0; i < m; i++) {
            arrayVectors[i] = new Vector(n);
        }
    }

    public Matrix(Matrix matrix) {
        this.arrayVectors = matrix.arrayVectors;
    }

    public Matrix(double[][] array) {
        arrayVectors = new Vector[array.length];

        int rowLength = array[0].length;

        for (int i = 0; i < rowLength; i++) {
            arrayVectors[i] = new Vector(Arrays.copyOf(array[i], rowLength));
        }
    }

    public Matrix(Vector[] array) {
        arrayVectors = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayVectors[i] = new Vector(array[i]);
        }
    }

    public int[] getSize() {
        return new int[]{arrayVectors.length, arrayVectors[0].getSize()};
    }

    /*public Vector getVectorByIndex(int index) {
        return arrayVectors[index];
    }

    public void setVectorByIndex(Vector vector, int index) {
        if (vector.getSize() != n) {
            throw new IllegalArgumentException("Некорректная размерность матрицы");
        }

        arrayVectors[index] = new Vector(Arrays.copyOf(vector.getComponents(), n));
    }

    public Vector getColumnByIndex(int index) {
        if (index >= n) {
            throw new IllegalArgumentException("Некорректная размерность матрицы");
        }

        double[] column = new double[m];

        for (int i = 0; i < m; i++) {
            column[i] = arrayVectors[i].getComponentByIndex(index);
        }

        return new Vector(column);
    }

    public void transposeMatrix() {
        Vector[] vectors = new Vector[n];

        for (int i = 0; i < n; i++) {
            vectors[i] = this.getColumnByIndex(i);
        }

        int e = n;
        n = m;
        m = e;
        arrayVectors = vectors;
    }

    public void increaseByScalar(int s) {
        for (Vector v : arrayVectors) {
            v.multiplyByScalar(s);
        }
    }

    public double getDeterminant() {
        if (m != n || m <= 1) {
            throw new IllegalArgumentException("Невозможно посчитать определитель для неквадратной матрицы.");
        }

        return getDeterminantRecursion(arrayVectors);
    }

    private double getDeterminantRecursion(Vector[] vectors) {
        double determinant = 0;

        if (vectors.length == 2) {
            return vectors[0].getComponentByIndex(0) * vectors[1].getComponentByIndex(1) - vectors[1].getComponentByIndex(0) * vectors[0].getComponentByIndex(1);
        }

        int k;
        for (int i = 0; i < vectors.length; i++) {
            if (i % 2 == 1) {
                k = -1;
            } else {
                k = 1;
            }

            determinant = determinant + k * vectors[0].getComponentByIndex(i) * this.getDeterminantRecursion(this.getMinor(vectors, i));
        }

        return determinant;
    }

    private Vector[] getMinor(Vector[] matrixVectors, int column) {
        int row = 0;
        int minorLength = matrixVectors.length - 1;

        Vector[] minor = new Vector[minorLength];

        for (int i = 0; i < minorLength; i++) {
            minor[i] = new Vector(minorLength);
        }

        int dI = 0;
        int dJ;

        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor[i - dI].setComponentByIndex(j - dJ, matrixVectors[i].getComponentByIndex(j));
                    }
                }
            }
        }

        return minor;
    }

    @Override
    public String toString() {
        if (arrayVectors == null) {
            return "null";
        }

        int iMax = arrayVectors.length - 1;

        if (iMax == -1) {
            return "{}";
        }

        StringBuilder b = new StringBuilder();
        b.append('{');

        for (int i = 0; ; i++) {
            b.append(arrayVectors[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(", ");
        }
    }

    public void increaseByVector(Vector vector) {
        if (n != vector.getSize()) {
            throw new IllegalArgumentException("Некорректная размерность матрицы");
        }

        for (int i = 0; i < m; i++) {
            arrayVectors[i] = Vector.getScalarResult(arrayVectors[i], vector);
        }
    }

    public void getUnion(Matrix matrix) {
        if (n != matrix.n || m != matrix.m) {
            throw new IllegalArgumentException("Некорректная размерность матрицы");
        }

        for (int i = 0; i < m; i++) {
            arrayVectors[i] = Vector.getSum(arrayVectors[i], matrix.arrayVectors[i]);
        }
    }

    public void getDifference(Matrix matrix) {
        if (n != matrix.n || m != matrix.m) {
            throw new IllegalArgumentException("Некорректная размерность матрицы");
        }

        for (int i = 0; i < m; i++) {
            arrayVectors[i] = Vector.getDifference(arrayVectors[i], matrix.arrayVectors[i]);
        }
    }

    public static Matrix getUnion(Matrix matrix1, Matrix matrix2) {
        if (matrix1.n != matrix2.n || matrix1.m != matrix2.m) {
            throw new IllegalArgumentException("Некорректная размерность матрицы");
        }

        Matrix newMatrix = new Matrix(matrix1);

        newMatrix.getUnion(matrix2);
        return newMatrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.n != matrix2.n || matrix1.m != matrix2.m) {
            throw new IllegalArgumentException("Некорректная размерность матрицы");
        }

        Matrix newMatrix = new Matrix(matrix1);

        newMatrix.getDifference(matrix2);
        return newMatrix;
    }

    public static Matrix getIncreaseOfMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.n != matrix2.n || matrix1.m != matrix2.m) {
            throw new IllegalArgumentException("Некорректная размерность матрицы");
        }

        Matrix newMatrix = new Matrix(matrix1.n, matrix1.m);

        for (int i = 0; i < newMatrix.m; i++) {
            newMatrix.arrayVectors[i] = Vector.getScalarResult(matrix1.getVectorByIndex(i), matrix2.getVectorByIndex(i));
        }

        return newMatrix;
    }*/
}