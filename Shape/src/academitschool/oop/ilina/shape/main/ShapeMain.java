package academitschool.oop.ilina.shape.main;

import academitschool.oop.ilina.shape.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ShapeMain {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Square(4.5));
        shapes.add(new Triangle(1, 2, 4, 8, 9, 1));
        shapes.add(new Rectangle(4,8));
        shapes.add(new Circle(1));

        for (Shape e: shapes) {
            System.out.println("Площадь фигуры равна: " + e.getArea());
        }

AreaShapeComparator areaShapeComparator = new AreaShapeComparator();
        Arrays.sort(shapes, areaShapeComparator);
    }
}
