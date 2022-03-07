import java.util.ArrayList;

public class ListWithoutRetry {
    public static void main(String[] args) throws IndexOutOfBoundsException, NullPointerException{
        ArrayList<Integer> list = new ArrayList<>(6);

        list.add(5);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);

        ArrayList<Integer> listWithoutRetry = new ArrayList<>();

        try {
            listWithoutRetry.add(list.get(0));

            for (int i = 1; i < list.size(); i++) {
                if (!listWithoutRetry.contains(list.get(i))) {
                    listWithoutRetry.add(list.get(i));
                }
            }

            System.out.println(list);
            System.out.println(listWithoutRetry);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Пустой список!");
        } catch (NullPointerException e) {
            System.out.println("В списке есть пустой элемент!");
        }
    }
}
