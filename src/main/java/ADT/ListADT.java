package ADT;

public interface ListADT<T> {
    void add(T item);
    T removeLast();
    T getLast();
    boolean isEmpty();
}
