import ADT.ListADT;
import ADT.Stack;
import List.SinglyLinkedList;
import Stack.ArrayListStack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Stack.VectorStack;
import Stack.ListStack;

public class StackTest {

    @Test
    void testArrayListStack() {
        Stack<Object> stack = new ArrayListStack<>();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.peek());
    }

    @Test
    void testVectorStack() {
        Stack<Object> stack = new VectorStack<>();
        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.pop());
    }

    @Test
    void testListStack() {
        ListADT<Object> list = new SinglyLinkedList<>();
        Stack<Object> stack = new ListStack<>(list);

        stack.push(5);
        stack.push(8);

        assertEquals(8, stack.pop());
        assertFalse(stack.isEmpty());
    }
}