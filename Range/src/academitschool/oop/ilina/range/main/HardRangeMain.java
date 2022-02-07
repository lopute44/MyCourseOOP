package academitschool.oop.ilina.range.main;

import academitschool.oop.ilina.range.range.Range;

public class HardRangeMain {
    public static void main(String[] args) {
        Range range1 = new Range(1, 7);
        Range range2 = new Range(6, 8);

        Range intersectionRange = range1.getIntersectionRange(range2);

        if (intersectionRange == null) {
            System.out.println("У диапазонов нет пересечения!");
        } else System.out.println("Координаты пересечения диапазонов: " + intersectionRange);

        Range[] combiningRanges = range1.getCombiningRanges(range2);

        for (Range range : combiningRanges) {
            System.out.println("Диапазон объединения: " + range);
        }

        Range[] subtractionRanges = range2.getSubtractionRanges(range1);

        if (subtractionRanges == null) {
            System.out.println("Диапазоны равны!");
        } else {
            for (Range range : subtractionRanges) {
                System.out.println("Диапазон разности: " + range);
            }
        }
    }
}