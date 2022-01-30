package academitschool.courseoop.ilina.main;

import academitschool.courseoop.ilina.range.Range;

public class MainHardRange {
    public static void main(String[] args) {
        Range range1 = new Range(-4, 8);
        Range range2 = new Range(-6, 10);

        System.out.println("Координаты пересечения диапазонов: X = " + range1.getIntersectionRanges(range2).getFrom() +
                ", Y = " + range1.getIntersectionRanges(range2).getTo());
    }
}
