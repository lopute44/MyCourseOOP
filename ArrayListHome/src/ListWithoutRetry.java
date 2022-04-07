import java.util.ArrayList;

public class ListWithoutRetry {
    public static void main(String[] args) {
        int size = 6;
        ArrayList<Integer> list = new ArrayList<>(size);

        list.add(5);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);

        ArrayList<Integer> listWithoutRetry = new ArrayList<>(size);

        if (list.size() != 0) {
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
