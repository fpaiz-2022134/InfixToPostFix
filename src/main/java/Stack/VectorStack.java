package Stack;

import ADT.Stack;
import java.util.Vector;

public class VectorStack<T> implements Stack<T> {

    private Vector<T> vector = new Vector<>();

    @Override
    public void push(T item) {
        vector.add(item);
    }

    @Override
    public T pop() {
        return vector.remove(vector.size() - 1);
    }

    @Override
    public T peek() {
        return vector.lastElement();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }
}
