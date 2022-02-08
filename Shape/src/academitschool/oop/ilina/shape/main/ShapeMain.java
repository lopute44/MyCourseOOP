package academitschool.oop.ilina.shape.main;

import academitschool.oop.ilina.shape.*;

import java.util.Arrays;

public class ShapeMain {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];

        shapes[0] = new Square(4.5);
        shapes[1] = new Triangle(1, 2, 4, 8, 9, 1);
        shapes[2] = new Rectangle(4, 8);
        shapes[3] = new Circle(1);
        shapes[4] = new Square(10.5);
        shapes[5] = new Triangle(3, 2, 4, 10, 9, -1);
        shapes[6] = new Rectangle(1, 5);
        shapes[7] = new Circle(3);
        shapes[8] = new Square(2.5);
        shapes[9] = new Triangle(0, 0, 0, 8, 9, 0);

        for (Shape e : shapes) {
            System.out.println("Площадь фигуры равна: " + e.getArea());
        }

        Shape shapeMaxArea = getShapeWithMaxArea(shapes);
        System.out.println("Наибольшую площадь имеет фигура " + shapeMaxArea + ", площадь равна " + shapeMaxArea.getArea());

        Shape shapeMaxSecondPerimeter = getShapeWithMaxSecondPerimeter(shapes);
        System.out.println("Второй по величине периметр имеет фигура " + shapeMaxSecondPerimeter + ", периметр равен " + shapeMaxSecondPerimeter.getPerimeter());
    }

    public static Shape getShapeWithMaxArea(Shape[] shapes) {
        AreaShapeComparator areaShapeComparator = new AreaShapeComparator();
        Arrays.sort(shapes, areaShapeComparator);

        return shapes[shapes.length - 1];
    }

    public static Shape getShapeWithMaxSecondPerimeter(Shape[] shapes) {
        PerimeterShapeComparator perimeterShapeComparator = new PerimeterShapeComparator();
        Arrays.sort(shapes, perimeterShapeComparator);

        return shapes[shapes.length - 2];
    }
}
