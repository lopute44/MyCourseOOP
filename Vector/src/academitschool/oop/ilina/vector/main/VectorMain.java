package academitschool.oop.ilina.vector.main;

import academitschool.oop.ilina.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5, new double[]{1, 2, 3, 4, 5});
        Vector vector2 = new Vector(3, new double[]{10, 20, 30});

        System.out.println("Начальные данные векторов:");
        System.out.println("первый вектор: " + vector1);
        System.out.println("второй вектор: " + vector2);

        System.out.println();

        Vector vector3 = Vector.getUnion(vector1, vector2);
        System.out.println("Результат сложения, вычисленного с помощью статического метода: " + vector3);

        vector3 = Vector.getDifference(vector1, vector2);

        System.out.println("Результат вычитания второго вектора из первого, вычисленного с помощью статического метода: " + vector3);

        vector1.getUnion(vector2);
        System.out.println("Результат сложения, вычисленного с помощью нестатического метода: " + vector1);

        vector1.setComponentByIndex(vector2.getComponentByIndex(2), 2);
        System.out.println("В первом векторе заменили компоненту с индексом 2, на компоненты с тем же индексом второго вектора: " + vector1);

        vector1.increaseByScalar(25);
        System.out.println("Первый ветор умножили на скаляр, равный 25: " + vector1);

        vector2.inverse();
        System.out.println("Второй вектор, после разворота: " + vector2);

        System.out.println("Длина первого вектора: " + vector1.getLength());

        System.out.println("Результат сравнения векторов после преобразований: " + vector1.equals(vector2));

        vector2.getDifference(vector1);
        System.out.println("Результат вычитания первого вектора из второго, вычисленного с помощью нестатического метода: " + vector2);

        System.out.println("Вектора после всех преобразований:");
        System.out.println("первый вектор: " + vector1);
        System.out.println("второй вектор: " + vector2);
    }
}
