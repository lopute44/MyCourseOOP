import java.util.ArrayList;

public class ListWithoutRetry {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(5);
        list.add(7);

        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(list.get(0));

        boolean flag = false;

        for (int i = 1; i < list.size(); i++) {
            for (Integer integer : newList) {
                if (list.get(i).equals(integer)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                newList.add(list.get(i));
            }

            flag = false;
        }

        System.out.println(list);
        System.out.println(newList);
    }
}
