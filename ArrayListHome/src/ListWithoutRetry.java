import java.util.ArrayList;

public class ListWithoutRetry {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(6);

        list.add(5);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);

        ArrayList<Integer> listWithoutRetry = new ArrayList<>(6);

        if (list.size() != 0) {
            listWithoutRetry.add(list.get(0));

            for (Integer e : list) {
                if (!listWithoutRetry.contains(e)) {
                    listWithoutRetry.add(e);
                }
            }
        }

        System.out.println("Список: " + list);
        System.out.println("Список без повторений: " + listWithoutRetry);
    }
}
