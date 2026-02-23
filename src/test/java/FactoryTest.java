import ADT.ListADT;
import ADT.Stack;
import Factory.ListFactory;
import Factory.StackFactory;
import List.DoublyLinkedList;
import List.SinglyLinkedList;
import Stack.ArrayListStack;
import Stack.ListStack;
import Stack.VectorStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    // ─── StackFactory ────────────────────────────────────────────────────────

    @Test
    void stackFactory_option1_returnsArrayListStack() {
        Stack<Object> stack = StackFactory.createStack(1, 0);
        assertInstanceOf(ArrayListStack.class, stack);
    }

    @Test
    void stackFactory_option2_returnsVectorStack() {
        Stack<Object> stack = StackFactory.createStack(2, 0);
        assertInstanceOf(VectorStack.class, stack);
    }

    @Test
    void stackFactory_option3_listOption1_returnsListStackWithSinglyLinkedList() {
        Stack<Object> stack = StackFactory.createStack(3, 1);
        assertInstanceOf(ListStack.class, stack);
    }

    @Test
    void stackFactory_option3_listOption2_returnsListStackWithDoublyLinkedList() {
        Stack<Object> stack = StackFactory.createStack(3, 2);
        assertInstanceOf(ListStack.class, stack);
    }

    @Test
    void stackFactory_invalidOption_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> StackFactory.createStack(99, 0));
    }

    // ─── ListFactory ─────────────────────────────────────────────────────────

    @Test
    void listFactory_option1_returnsSinglyLinkedList() {
        ListADT<Object> list = ListFactory.createList(1);
        assertInstanceOf(SinglyLinkedList.class, list);
    }

    @Test
    void listFactory_option2_returnsDoublyLinkedList() {
        ListADT<Object> list = ListFactory.createList(2);
        assertInstanceOf(DoublyLinkedList.class, list);
    }

    @Test
    void listFactory_invalidOption_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> ListFactory.createList(99));
    }

    // ─── Comportamiento funcional de los stacks creados ─────────────────────

    @Test
    void stackFactory_arrayListStack_pushAndPop() {
        Stack<Object> stack = StackFactory.createStack(1, 0);
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void stackFactory_vectorStack_pushAndPop() {
        Stack<Object> stack = StackFactory.createStack(2, 0);
        stack.push("X");
        stack.push("Y");
        assertEquals("Y", stack.pop());
        assertFalse(stack.isEmpty());
    }

    @Test
    void stackFactory_listStack_singlyLinkedList_pushAndPop() {
        Stack<Object> stack = StackFactory.createStack(3, 1);
        stack.push(5);
        stack.push(8);
        assertEquals(8, stack.pop());
        assertFalse(stack.isEmpty());
    }

    @Test
    void stackFactory_listStack_doublyLinkedList_pushAndPop() {
        Stack<Object> stack = StackFactory.createStack(3, 2);
        stack.push(100);
        stack.push(200);
        assertEquals(200, stack.pop());
        assertFalse(stack.isEmpty());
    }

    @Test
    void stackFactory_listStack_invalidListOption_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> StackFactory.createStack(3, 99));
    }
}
