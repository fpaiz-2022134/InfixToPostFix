

import ADT.ListADT;
import ADT.Stack;
import List.DoublyLinkedList;
import List.SinglyLinkedList;
import Stack.ArrayListStack;
import Stack.ListStack;
import Stack.VectorStack;
import utils.InfixToPostfix;
import utils.PostfixEvaluator;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" CALCULADORA INFIX → POSTFIX ");
        System.out.println("=================================\n");

        System.out.println("Seleccione la implementación de la PILA:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista (Implementación propia)");

        int opcionStack = input.nextInt();

        Stack<Object> stackChar;
        Stack<Object> stackInt;

        switch (opcionStack) {

            case 1:
                stackChar = new ArrayListStack<>();
                stackInt = new ArrayListStack<>();
                break;

            case 2:
                stackChar = new VectorStack<>();
                stackInt = new VectorStack<>();
                break;

            case 3:
                System.out.println("\nSeleccione la implementación de LISTA:");
                System.out.println("1. Simplemente Encadenada");
                System.out.println("2. Doblemente Encadenada");

                int opcionLista = input.nextInt();

                ListADT<Object> listChar;
                ListADT<Object> listInt;

                if (opcionLista == 1) {
                    listChar = new SinglyLinkedList<>();
                    listInt = new SinglyLinkedList<>();
                } else {
                    listChar = new DoublyLinkedList<>();
                    listInt = new DoublyLinkedList<>();
                }

                stackChar = new ListStack<>(listChar);
                stackInt = new ListStack<>(listInt);
                break;

            default:
                System.out.println("Opción inválida. Se usará ArrayList por defecto.");
                stackChar = new ArrayListStack<>();
                stackInt = new ArrayListStack<>();
        }

        // Leer expresión desde archivo
        InputStream input1 = Main.class.getClassLoader().getResourceAsStream("datos.txt");
        Scanner file = new Scanner(input1);
        String expression = file.nextLine();

        System.out.println("\nExpresión Infix leída: " + expression);

        // Conversión
        String postfix = InfixToPostfix.convert(expression, stackChar);
        System.out.println("Expresión Postfix: " + postfix);

        // Evaluación
        int result = PostfixEvaluator.evaluate(postfix, stackInt);
        System.out.println("Resultado final: " + result);

        input.close();
        file.close();
    }
}
