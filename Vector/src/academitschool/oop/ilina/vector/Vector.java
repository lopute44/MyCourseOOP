package academitschool.oop.ilina.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Ошибка размерности вектора! Размерность вектора не может быть равной " + dimension);
        }

        components = new double[dimension];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public Vector(double[] array) {
        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int dimension, double[] array) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Ошибка размерности вектора! Размерность вектора не может быть равной " + dimension);
        }

        components = Arrays.copyOf(array, dimension);
    }

    public double[] getComponents() {
        return components;
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        int count = getSize();

        for (double d : components) {
            stringBuilder.append(d);
            count--;
            if (count != 0) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.append('}').toString();
    }

    public void addVector(Vector vector) {
        if (getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.getSize());
        }

        for (int i = 0; i < vector.getSize(); i++) {
            components[i] = components[i] + vector.components[i];
        }
    }

    public void subtractVector(Vector vector) {
        if (getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.getSize());
        }

        for (int i = 0; i < vector.getSize(); i++) {
            components[i] = components[i] - vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            components[i] *= scalar;
        }
    }

    public void expend() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double squaresOfComponentsSum = 0;

        for (double e : components) {
            squaresOfComponentsSum += e * e;
        }

        return Math.sqrt(squaresOfComponentsSum);
    }

    public double getComponentByIndex(int index) {
        return components[index];
    }

    public void setComponentByIndex(int index, double component) {
        components[index] = component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (getSize() != vector.getSize()) {
            return false;
        }

        for (int i = 0; i < getSize(); i++) {
            if (components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(components);

        return hash;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        if (vector1.getSize() > vector2.getSize()) {
            Vector unionVector = new Vector(vector1);
            unionVector.addVector(vector2);
            return unionVector;
        }

        Vector unionVector = new Vector(vector2);
        unionVector.addVector(vector1);
        return unionVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        if (vector1.getSize() > vector2.getSize()) {
            Vector differenceVector = new Vector(vector1);
            differenceVector.subtractVector(vector2);
            return differenceVector;
        }

        Vector differenceVector = new Vector(vector2);
        differenceVector.subtractVector(vector1);
        return differenceVector;
    }

    public static Vector increaseVectors(Vector vector1, Vector vector2) {
        Vector increaseVector;
        if (vector1.getSize() > vector2.getSize()) {
            increaseVector = new Vector(new double[vector1.getSize()]);
            increaseVector.components = Arrays.copyOf(vector2.components, vector1.getSize());

            for (int i = 0; i < vector1.getSize(); i++) {
                increaseVector.components[i] *= vector1.components[i];
            }
        } else {
            increaseVector = new Vector(new double[vector2.getSize()]);
            increaseVector.components = Arrays.copyOf(vector1.components, vector2.getSize());

            for (int i = 0; i < vector2.getSize(); i++) {
                increaseVector.components[i] *= vector2.components[i];
            }
        }

        return increaseVector;
    }
}
