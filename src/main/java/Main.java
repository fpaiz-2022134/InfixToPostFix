import ADT.Stack;
import Factory.StackFactory;
import utils.InfixToPostfix;
import utils.PostfixEvaluator;

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

        int stackOption = input.nextInt();

        int listOption = 0;
        if (stackOption == 3) {
            System.out.println("\nSeleccione la implementación de LISTA:");
            System.out.println("1. Simplemente Encadenada");
            System.out.println("2. Doblemente Encadenada");
            listOption = input.nextInt();
        }

        Stack<Object> stackChar = StackFactory.createStack(stackOption, listOption);
        Stack<Object> stackInt  = StackFactory.createStack(stackOption, listOption);

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
