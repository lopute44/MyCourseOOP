package academitschool.oop.ilina.matrixnew;

import academitschool.oop.ilina.vector.Vector;

public class Matrix {
    private Vector[] matrixRows;

    public Matrix(int rowsSize, int columnsSize) {
        if (columnsSize == 0 || rowsSize == 0) {
            throw new IllegalArgumentException("Нельзя создавать пустую матрицу!");
        }

        matrixRows = new Vector[rowsSize];

        for (int i = 0; i < rowsSize; i++) {
            matrixRows[i] = new Vector(columnsSize);
        }
    }

    public Matrix(Matrix matrix) {
        this.matrixRows = matrix.matrixRows;
    }

    public Matrix(double[][] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Нельзя создавать пустую матрицу!");
        }

        matrixRows = new Vector[array.length];

        int maxRow = 0;

        for (double[] e : array) {
            maxRow = Math.max(maxRow, e.length);
        }

        for (int i = 0; i < array.length; i++) {
            matrixRows[i] = new Vector(maxRow, array[i]);
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

        matrixRows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            matrixRows[i] = new Vector(maxVectorSize);
            matrixRows[i].add(array[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (Vector e : matrixRows) {
            stringBuilder.append(e);

            stringBuilder.append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.append("}").toString();
    }

    private void validateIndex(int index, int rangeBoundary) {
        if (index >= rangeBoundary || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Переданный индекс " + index + " выходит за пределы диапазона от 0 до " + rangeBoundary + "!");
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
        return matrixRows.length;
    }

    public int getColumnsAmount() {
        return matrixRows[0].getSize();
    }

    public Vector getRowByIndex(int index) {
        return new Vector(matrixRows[index]);
    }

    public void setVectorByIndex(int index, Vector vector) {
        validateIndex(index, getColumnsAmount());

        if (vector.getSize() != getColumnsAmount()) {
            throw new IllegalArgumentException("Размерность переданного вектора равна " + vector.getSize() + ", что не соответствует размерности матрицы равной " + getColumnsAmount());
        }

        matrixRows[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        validateIndex(index, getColumnsAmount());

        double[] column = new double[getRowsAmount()];

        for (int i = 0; i < getRowsAmount(); i++) {
            column[i] = matrixRows[i].getComponentByIndex(index);
        }

        return new Vector(column);
    }

    public void transpose() {
        Vector[] vectors = new Vector[getColumnsAmount()];

        for (int i = 0; i < getColumnsAmount(); i++) {
            vectors[i] = this.getColumnByIndex(i);
        }

        matrixRows = vectors;
    }

    public void multiplyByScalar(int scalar) {
        for (Vector v : matrixRows) {
            v.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (getColumnsAmount() != getRowsAmount()) {
            throw new UnsupportedOperationException("Невозможно посчитать определитель для неквадратной матрицы: " + getRowsAmount() + " x " + getColumnsAmount());
        }

        if (getColumnsAmount() == 1) {
            return matrixRows[0].getComponentByIndex(0);
        }

        return getDeterminantRecursively(matrixRows);
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
                    ", что не соотвествует количество столбцов в матрице, которое равно " + getColumnsAmount());
        }

        double[] array = new double[getRowsAmount()];

        for (int i = 0; i < getRowsAmount(); i++) {
            array[i] = Vector.getScalarResult(matrixRows[i], vector);
        }

        return new Vector(array);
    }

    public void sum(Matrix matrix) {
        validateMatrixSize(this, matrix);

        for (int i = 0; i < getRowsAmount(); i++) {
            matrixRows[i].add(matrix.matrixRows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        validateMatrixSize(this, matrix);

        for (int i = 0; i < getRowsAmount(); i++) {
            matrixRows[i].subtract(matrix.matrixRows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        validateMatrixSize(matrix1, matrix2);

        Matrix resultMatrix = new Matrix(matrix1);

        resultMatrix.sum(matrix2);
        return resultMatrix;
    }

    public static Matrix getSubtract(Matrix matrix1, Matrix matrix2) {
        validateMatrixSize(matrix1, matrix2);

        Matrix resultMatrix = new Matrix(matrix1);

        resultMatrix.subtract(matrix2);
        return resultMatrix;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsAmount() != matrix2.getRowsAmount()) {
            throw new IllegalArgumentException("Размерности матриц не соответствуют друг другу. Размер первой матрицы " +
                    matrix1.getRowsAmount() + " X " + matrix1.getColumnsAmount() +
                    ", размер второй матрицы " + matrix2.getRowsAmount() + " X " + matrix2.getColumnsAmount());
        }

        double[][] resultArray = new double[matrix1.getRowsAmount()][matrix2.getColumnsAmount()];

        for (int i = 0; i < matrix1.getRowsAmount(); i++) {
            for (int j = 0; j < matrix2.getColumnsAmount(); j++) {
                for (int k = 0; k < matrix2.getRowsAmount(); k++) {
                    resultArray[i][j] += matrix1.matrixRows[i].getComponentByIndex(k) * matrix2.matrixRows[k].getComponentByIndex(j);
                }
            }
        }

        return new Matrix(resultArray);
    }
}
