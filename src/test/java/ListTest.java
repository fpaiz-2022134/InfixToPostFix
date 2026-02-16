import ADT.ListADT;
import List.DoublyLinkedList;
import List.SinglyLinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    void testSinglyLinkedList() {
        ListADT<Object> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);

        assertEquals(2, list.removeLast());
    }

    @Test
    void testDoublyLinkedList() {
        ListADT<Object> list = new DoublyLinkedList<>();
        list.add("A");
        list.add("B");

        assertEquals("B", list.getLast());
    }
}