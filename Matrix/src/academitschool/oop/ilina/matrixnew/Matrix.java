package academitschool.oop.ilina.matrixnew;

import academitschool.oop.ilina.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsAmount, int columnsAmount) {
        if (rowsAmount <= 0) {
            throw new IllegalArgumentException("Передан rowsAmount = " + rowsAmount + ". Нельзя создать матрицу такого размера!");
        }

        if (columnsAmount <= 0) {
            throw new IllegalArgumentException("Передан  columnsAmount = " + columnsAmount + ". Нельзя создать матрицу такого размера!");
        }

        rows = new Vector[rowsAmount];

        for (int i = 0; i < rowsAmount; i++) {
            rows[i] = new Vector(columnsAmount);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.getRowsAmount()];

        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("В качестве аргумента передан null!");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Нельзя создавать пустую матрицу!");
        }

        rows = new Vector[array.length];

        int maxRowLength = 0;

        for (double[] e : array) {
            maxRowLength = Math.max(maxRowLength, e.length);
        }

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxRowLength, array[i]);
        }
    }

    public Matrix(Vector[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Нельзя создавать пустую матрицу!");
        }

        int maxVectorSize = 0;

        for (Vector e : array) {
            maxVectorSize = Math.max(maxVectorSize, e.getSize());
        }

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxVectorSize);
            rows[i].add(array[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (Vector e : rows) {
            stringBuilder.append(e);
            stringBuilder.append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.append("}").toString();
    }

    private void validateIndex(int index, int maxIndex) {
        if (index < 0 || index > maxIndex) {
            throw new IndexOutOfBoundsException("Переданный индекс " + index + " выходит за пределы диапазона от 0 до " + maxIndex + "!");
        }
    }

    private static void validateMatrixSize(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsAmount() != matrix2.getColumnsAmount() || matrix1.getRowsAmount() != matrix2.getRowsAmount()) {
            throw new IllegalArgumentException("Размерности матриц не соответствуют друг другу. Размер первой матрицы " +
                    matrix1.getRowsAmount() + " X " + matrix1.getColumnsAmount() +
                    ", размер второй матрицы " + matrix2.getRowsAmount() + " X " + matrix2.getColumnsAmount());
        }
    }

    public int getRowsAmount() {
        return rows.length;
    }

    public int getColumnsAmount() {
        return rows[0].getSize();
    }

    public Vector getRowByIndex(int index) {
        validateIndex(index, getRowsAmount() - 1);

        return new Vector(rows[index]);
    }

    public void setRowByIndex(int index, Vector vector) {
        validateIndex(index, getRowsAmount() - 1);

        if (vector.getSize() != getColumnsAmount()) {
            throw new IllegalArgumentException("Размерность переданного вектора равна " + vector.getSize() + ", что не соответствует количеству строк матрицы, которое равно " + getColumnsAmount());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        validateIndex(index, getColumnsAmount() - 1);

        double[] column = new double[getRowsAmount()];

        for (int i = 0; i < getRowsAmount(); i++) {
            column[i] = rows[i].getComponentByIndex(index);
        }

        return new Vector(column);
    }

    public void transpose() {
        Vector[] newRows = new Vector[getColumnsAmount()];

        for (int i = 0; i < getColumnsAmount(); i++) {
            newRows[i] = getColumnByIndex(i);
        }

        rows = newRows;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector v : rows) {
            v.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (getColumnsAmount() != getRowsAmount()) {
            throw new UnsupportedOperationException("Невозможно посчитать определитель для неквадратной матрицы: " + getRowsAmount() + " x " + getColumnsAmount());
        }

        if (getColumnsAmount() == 1) {
            return rows[0].getComponentByIndex(0);
        }

        return getDeterminantRecursively(rows);
    }

    private static double getDeterminantRecursively(Vector[] vectors) {
        double determinant = 0;

        if (vectors.length == 2) {
            return vectors[0].getComponentByIndex(0) * vectors[1].getComponentByIndex(1) - vectors[1].getComponentByIndex(0) * vectors[0].getComponentByIndex(1);
        }

        for (int i = 0; i < vectors.length; i++) {
            int coefficient;

            if (i % 2 == 1) {
                coefficient = -1;
            } else {
                coefficient = 1;
            }

            determinant += coefficient * vectors[0].getComponentByIndex(i) * getDeterminantRecursively(getMinor(vectors, i));
        }

        return determinant;
    }

    private static Vector[] getMinor(Vector[] matrixVectors, int columnIndex) {
        int size = matrixVectors.length - 1;

        Vector[] minor = new Vector[size];

        for (int i = 0; i < size; i++) {
            minor[i] = new Vector(size);
        }

        int dI = 0;

        for (int i = 0; i <= size; i++) {
            int dJ = 0;

            for (int j = 0; j <= size; j++) {
                if (i == 0) {
                    dI = 1;
                } else {
                    if (j == columnIndex) {
                        dJ = 1;
                    } else {
                        minor[i - dI].setComponentByIndex(j - dJ, matrixVectors[i].getComponentByIndex(j));
                    }
                }
            }
        }

        return minor;
    }

    public Vector multiplyByVector(Vector vector) {
        if (getColumnsAmount() != vector.getSize()) {
            throw new IllegalArgumentException("Размерность переданного вектора равна " + vector.getSize() +
                    ", что не соответствует количеству столбцов в матрице, которое равно " + getColumnsAmount());
        }

        double[] array = new double[getRowsAmount()];

        for (int i = 0; i < getRowsAmount(); i++) {
            array[i] = Vector.getScalarMultiply(rows[i], vector);
        }

        return new Vector(array);
    }

    public void sum(Matrix matrix) {
        validateMatrixSize(this, matrix);

        for (int i = 0; i < getRowsAmount(); i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        validateMatrixSize(this, matrix);

        for (int i = 0; i < getRowsAmount(); i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        validateMatrixSize(matrix1, matrix2);

        Matrix resultMatrix = new Matrix(matrix1);

        resultMatrix.sum(matrix2);
        return resultMatrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        validateMatrixSize(matrix1, matrix2);

        Matrix resultMatrix = new Matrix(matrix1);

        resultMatrix.subtract(matrix2);
        return resultMatrix;
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsAmount() != matrix2.getRowsAmount()) {
            throw new IllegalArgumentException("Не совпадает количество столбцов в первой матрице " + matrix1.getColumnsAmount()
                    + " и количество строк во второй матрице " + matrix2.getRowsAmount());
        }

        double[][] resultArray = new double[matrix1.getRowsAmount()][matrix2.getColumnsAmount()];

        for (int i = 0; i < matrix1.getRowsAmount(); i++) {
            for (int j = 0; j < matrix2.getColumnsAmount(); j++) {
                for (int k = 0; k < matrix2.getRowsAmount(); k++) {
                    resultArray[i][j] += matrix1.rows[i].getComponentByIndex(k) * matrix2.rows[k].getComponentByIndex(j);
                }
            }
        }

        return new Matrix(resultArray);
    }
}
