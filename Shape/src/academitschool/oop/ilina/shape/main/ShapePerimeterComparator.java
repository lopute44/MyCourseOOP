package academitschool.oop.ilina.shape.main;

import academitschool.oop.ilina.shape.Shape;

import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.getPerimeter(), s2.getPerimeter());
    }
}
