package academitschool.oop.ilina.shape;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class AreaShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.getHeight() == o2.getArea()) {
            return 0;
        }
        return (o1.getHeight() > o2.getArea() ? 1 : -1);
    }
}
