package Factory;

import ADT.ListADT;
import List.DoublyLinkedList;
import List.SinglyLinkedList;

/**
 * Factory para crear implementaciones de ListADT.
 *
 * Opciones disponibles:
 *   1 - SinglyLinkedList (Lista simplemente encadenada)
 *   2 - DoublyLinkedList (Lista doblemente encadenada)
 */
public class ListFactory {

    public static <T> ListADT<T> createList(int option) {
        switch (option) {
            case 1:
                return new SinglyLinkedList<>();
            case 2:
                return new DoublyLinkedList<>();
            default:
                throw new IllegalArgumentException("Opción de lista inválida: " + option);
        }
    }
}
