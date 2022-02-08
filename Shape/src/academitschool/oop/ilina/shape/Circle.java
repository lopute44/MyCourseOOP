package academitschool.oop.ilina.shape;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        return radius == ((Circle) o).radius;
    }

    @Override
    public int hashCode() {
        return (int) radius;
    }

    @Override
    public String toString() {
        return "Окружность с радиусом " + radius;
    }
}
