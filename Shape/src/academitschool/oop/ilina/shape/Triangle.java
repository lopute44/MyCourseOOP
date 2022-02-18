package academitschool.oop.ilina.shape;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return getMax(x1, x2, x3) - getMin(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getMax(y1, y2, y3) - getMin(y1, y2, y3);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    @Override
    public double getPerimeter() {
        return getSideOfTriangle(x1, y1, x2, y2) + getSideOfTriangle(x1, y1, x3, y3) + getSideOfTriangle(x2, y2, x3, y3);
    }

    private static double getMax(double number1, double number2, double number3) {
        return Math.max(Math.max(number1, number2), number3);
    }

    private static double getMin(double number1, double number2, double number3) {
        return Math.min(Math.min(number1, number2), number3);
    }

    private double getSideOfTriangle(double coordinateX1, double coordinateY1, double coordinateX2, double coordinateY2) {
        return Math.sqrt(Math.pow(coordinateX1 - coordinateX2, 2) + Math.pow(coordinateY1 - coordinateY2, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        return (x1 == triangle.x1) && (y1 == triangle.y1)
                && (x2 == triangle.x2) && (y2 == triangle.y2)
                && (x3 == triangle.x3) && (y3 == triangle.y3);
    }

    @Override
    public int hashCode() {
        final int prime = 10;
        int hash = 1;

        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);

        return hash;
    }

    @Override
    public String toString() {
        return "Треугольник с координатами вершин (" + x1 + "; " + y1 + "), (" + x2 + "; " + y2 + "), (" + x3 + "; " + y3 + ")";
    }
}
