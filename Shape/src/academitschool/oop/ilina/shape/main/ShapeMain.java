package academitschool.oop.ilina.shape.main;

import academitschool.oop.ilina.shape.*;

import java.util.Arrays;

public class ShapeMain {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(4.5),
                new Triangle(1, 2, 4, 8, 9, 1),
                new Rectangle(4, 8),
                new Circle(1),
                new Square(10.5),
                new Triangle(3, 2, 4, 10, 9, -1),
                new Rectangle(1, 5),
                new Circle(3),
                new Square(2.5),
                new Triangle(0, 0, 0, 8, 9, 0),
        };

        for (Shape e : shapes) {
            System.out.println("Площадь фигуры равна: " + e.getArea());
        }

        Shape shapeWithMaxArea = getShapeWithMaxArea(shapes);
        System.out.println("Наибольшую площадь имеет фигура " + shapeWithMaxArea + ", площадь равна " + shapeWithMaxArea.getArea());

        Shape shapeWithMaxSecondPerimeter = getShapeWithMaxSecondPerimeter(shapes);
        System.out.println("Второй по величине периметр имеет фигура " + shapeWithMaxSecondPerimeter + ", периметр равен " + shapeWithMaxSecondPerimeter.getPerimeter());
    }

    public static Shape getShapeWithMaxArea(Shape[] shapes) {
        if (shapes.length == 0) {
            return null;
        }

        Arrays.sort(shapes, new ShapeAreaComparator());

        return shapes[shapes.length - 1];
    }

    public static Shape getShapeWithMaxSecondPerimeter(Shape[] shapes) {
        if (shapes.length <= 1) {
            return null;
        }

        Arrays.sort(shapes, new ShapePerimeterComparator());

        return shapes[shapes.length - 2];
    }
}
