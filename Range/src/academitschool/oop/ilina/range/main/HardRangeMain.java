package academitschool.oop.ilina.range.main;

import academitschool.oop.ilina.range.Range;

public class HardRangeMain {
    public static void main(String[] args) {
        Range range1 = new Range(1, 7);
        Range range2 = new Range(-3, -1);

        Range intersectionRange = range1.getIntersection(range2);

        if (intersectionRange == null) {
            System.out.println("У диапазонов нет пересечения!");
        } else {
            System.out.println("Координаты пересечения диапазонов: " + intersectionRange);
        }

        Range[] unionRanges = range1.getUnion(range2);

        for (Range range : unionRanges) {
            System.out.println("Диапазон объединения: " + range);
        }

        Range[] differenceRanges = range1.getDifference(range2);

        if (differenceRanges.length == 0) {
            System.out.println("Результат операции вычитания равен нулю!");
        } else {
            for (Range range : differenceRanges) {
                System.out.println("Диапазон разности: " + range);
            }
        }
    }
}
