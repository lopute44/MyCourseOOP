package academitschool.oop.ilina.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;
    private int n;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        this.n = n;
        components = new double[n];
    }

    public Vector(Vector vector) {
        n = vector.n;
        components = vector.components;
    }

    public Vector(double[] array) {
        n = array.length;
        components = Arrays.copyOf(array, n);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        this.n = n;
        components = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return n;
    }

    @Override
    public String toString() {
        if (components == null)
            return "null";
        int iMax = components.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(components[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(", ");
        }
    }

    public void getUnion(Vector vector) {
        Vector[] vectors = transformVectors(this, vector);

        n = vectors[0].n;
        components = new double[n];

        for (int i = 0; i < vectors[0].n; i++) {
            components[i] = vectors[0].components[i] + vectors[1].components[i];
        }
    }

    public void getDifference(Vector vector) {
        Vector[] vectors = transformVectors(this, vector);

        n = vectors[0].n;
        components = new double[n];

        for (int i = 0; i < vectors[0].n; i++) {
            components[i] = vectors[0].components[i] - vectors[1].components[i];
        }
    }

    public void increaseByScalar(int s) {
        for (int i = 0; i < n; i++) {
            components[i] = components[i] * s;
        }
    }

    public void inverse() {
        for (int i = 0; i < n; i++) {
            components[i] = components[i] * -1;
        }
    }

    public double getLength() {
        double s = 0;

        for (double e: components) {
            s = s + Math.pow(e, 2);
        }

        return Math.sqrt(s);
    }

    public double getComponentByIndex(int index) {
        return components[index];
    }

    public void setComponentByIndex(double component, int index) {
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

        if (n != vector.n) {
            return false;
        }

        for (int i = 0; i < n; i++) {
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

        hash = prime * hash + Double.hashCode(n);

        for (double e: components) {
            hash = prime * hash + Double.hashCode(e);
        }

        return hash;
    }

    public static Vector getUnion(Vector vector1, Vector vector2) {
        Vector[] vectors = transformVectors(vector1, vector2);

        Vector unionVector = new Vector(new double[vectors[0].n]);

        for (int i = 0; i < vectors[0].n; i++) {
            unionVector.components[i] = vectors[0].components[i] + vectors[1].components[i];
        }

        return unionVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector[] vectors = transformVectors(vector1, vector2);

        Vector differenceVector = new Vector(new double[vectors[0].n]);

        for (int i = 0; i < vectors[0].n; i++) {
            differenceVector.components[i] = vectors[0].components[i] - vectors[1].components[i];
        }

        return differenceVector;
    }

    private static Vector[] transformVectors(Vector vector1, Vector vector2) {
        if (vector1.n == vector2.n) {
            return new Vector[]{vector1, vector2};
        }

        if (vector1.n > vector2.n) {
            Vector newVector1 = new Vector(vector1.components);
            Vector newVector2 = new Vector(Arrays.copyOf(vector2.components, vector1.n));
            return new Vector[]{newVector1, newVector2};
        }

        Vector newVector1 = new Vector(Arrays.copyOf(vector1.components, vector2.n));
        Vector newVector2 = new Vector(vector2.components);
        return new Vector[]{newVector1, newVector2};
    }
}
