package Stack;

import ADT.Stack;

import java.util.ArrayList;

public class ArrayListStack<T> implements Stack<T> {

    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
