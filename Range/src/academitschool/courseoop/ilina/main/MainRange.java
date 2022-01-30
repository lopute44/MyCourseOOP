package academitschool.courseoop.ilina.main;

import academitschool.courseoop.ilina.range.Range;

import java.util.Scanner;

public class MainRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите любое число:");
        double number = scanner.nextDouble();

        academitschool.courseoop.ilina.range.Range range = new academitschool.courseoop.ilina.range.Range(1.7, 67.3);

        if (range.isInside(number)) {
            System.out.println("Диапазон включает введенное число.");
        } else {
            do {
                System.out.println("Вы не попали в диапазон, необходимо ввести диапазон, который будет включать ваше число. Введите начало диапазона:");
                range.setFrom(scanner.nextDouble());

                System.out.println("Введите конец диапазона:");
                range.setTo(scanner.nextDouble());

                if (range.getLength() <= 0) {
                    System.out.println("Вы ввели несуществующий диапазон!");
                }
            } while (!range.isInside(number));

            System.out.println("Ввведнное число пападает в диапазон.");
        }

        // проверка для задачи range
    }
}
