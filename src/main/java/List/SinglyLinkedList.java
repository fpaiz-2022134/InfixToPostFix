package List;

import ADT.ListADT;

public class SinglyLinkedList<T> implements ListADT<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;

    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Lista vacía");
        T value = head.data;
        head = head.next;
        return value;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new RuntimeException("Lista vacía");
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}

