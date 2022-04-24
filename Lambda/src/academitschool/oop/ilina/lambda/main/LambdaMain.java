package academitschool.oop.ilina.lambda.main;

import academitschool.oop.ilina.lambda.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaMain {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Иван", 30));
        list.add(new Person("Иван", 30));
        list.add(new Person("Мария", 25));
        list.add(new Person("Константин", 19));
        list.add(new Person("Михаил", 40));
        list.add(new Person("Петр", 15));
        list.add(new Person("Лукреция", 31));
        list.add(new Person("Кира", 17));
        list.add(new Person("Евтсатий", 39));
        list.add(new Person("Евтсатий", 1));

        System.out.println("Список людей: " + list);

        // А) получить список уникальных имен

        System.out.println("Список уникальных имен: "
                + list
                .stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ")) + ".");

        //В) получить список людей младше 18, посчитать для них средний возраст
        List<Person> youngerPersonList = list
                .stream()
                .filter(x -> x.getAge() < 18)
                .collect(Collectors
                        .toList());
        System.out.println("Список людей с возрастом меньше 18 лет: " + youngerPersonList);

        System.out.println("Средний возрасть людей младше 18 лет равен " + youngerPersonList
                .stream()
                .mapToDouble(Person::getAge)
                .average());

        //Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        Map<String, List<Person>> mapPerson = list
                .stream()
                .collect(Collectors
                        .groupingBy(Person::getName));

        Map<String, Double> mapPersonWithAverageAge = mapPerson
                .entrySet()
                .stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey, v -> v.getValue()
                                .stream()
                                .mapToDouble(Person::getAge)
                                .average()
                                .orElseThrow(IllegalArgumentException::new)));

        System.out.println("Коллекция среднего возраста людей: " + mapPersonWithAverageAge);

        //Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста

        List<String> listPerson = list
                .stream()
                .sorted((x1, x2) -> x2.getAge() - x1.getAge())
                .filter(x -> x.getAge() >= 20)
                .filter(x -> x.getAge() <= 45)
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Люди в возрасте от 20 до 45: " + listPerson);
    }
}
