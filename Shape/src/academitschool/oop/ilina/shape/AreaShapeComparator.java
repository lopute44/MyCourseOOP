package academitschool.oop.ilina.shape;

import java.util.Comparator;

public class AreaShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.getArea() == o2.getArea()) {
            return 0;
        }

        return (o1.getArea() > o2.getArea() ? 1 : -1);
    }
}
