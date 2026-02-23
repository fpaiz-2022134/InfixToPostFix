package Factory;

import ADT.Stack;
import Stack.ArrayListStack;
import Stack.ListStack;
import Stack.VectorStack;

/**
 * Factory para crear implementaciones de Stack.
 *
 * Opciones de pila disponibles:
 *   1 - ArrayListStack (basado en ArrayList)
 *   2 - VectorStack    (basado en Vector)
 *   3 - ListStack      (basado en una lista propia; requiere listOption)
 *
 * Cuando stackOption == 3, se delega a ListFactory para crear
 * la implementación de lista interna según listOption:
 *   1 - SinglyLinkedList
 *   2 - DoublyLinkedList
 */
public class StackFactory {

    public static <T> Stack<T> createStack(int stackOption, int listOption) {
        switch (stackOption) {
            case 1:
                return new ArrayListStack<T>();
            case 2:
                return new VectorStack<T>();
            case 3:
                return new ListStack<T>(ListFactory.createList(listOption));
            default:
                throw new IllegalArgumentException("Opción de pila inválida: " + stackOption);
        }
    }
}
