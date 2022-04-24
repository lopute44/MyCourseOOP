package academitschool.oop.ilina.lambda.main;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class SquaresMain {
    public static void main(String[] args) {
        DoubleStream squares = DoubleStream.iterate(0, x -> x + 1).map(Math::sqrt);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов потока корней чисел:");
        int amount = scanner.nextInt();

        System.out.println("Первые " + amount + " элементов потока корней чисел:");
        squares.limit(amount).forEach(System.out::println);
    }
}
