package academitschool.oop.ilina.shape;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        return width == ((Rectangle) o).width && height == ((Rectangle) o).height;
    }

    @Override
    public int hashCode() {
        return (int) getArea();
    }

    @Override
    public String toString() {
        return "Прямоугольник шириной " + width + " и высотой " + height;
    }
}
