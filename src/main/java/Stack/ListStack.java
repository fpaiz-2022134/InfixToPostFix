package Stack;

import ADT.ListADT;
import ADT.Stack;

public class ListStack<T> implements Stack<T> {

    private ListADT<T> list;

    public ListStack(ListADT<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        return list.removeLast();
    }

    @Override
    public T peek() {
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
