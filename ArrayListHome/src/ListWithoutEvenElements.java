import java.util.ArrayList;
import java.util.Random;

public class ListWithoutEvenElements {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }

        System.out.println("Список до удаления четных элементов: " + list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        System.out.println("Список после удаления четных элементов: " + list);
    }
}
