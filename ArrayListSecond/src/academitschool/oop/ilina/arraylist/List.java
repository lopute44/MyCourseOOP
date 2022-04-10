package academitschool.oop.ilina.arraylist;

public interface List<T> {
    int size();
    boolean isEmpty();
    T get(int Index);
    void set(int index, T element);
    void add(T element);
    void remove (int index);
    void add(int index, T element);
}
