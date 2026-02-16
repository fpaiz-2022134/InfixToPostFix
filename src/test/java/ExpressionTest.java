import ADT.Stack;
import Stack.ArrayListStack;
import org.junit.jupiter.api.Test;
import utils.InfixToPostfix;
import utils.PostfixEvaluator;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTest {

    @Test
    void testExpressionEvaluation() {
        Stack<Object> stackChar = new ArrayListStack<>();
        Stack<Object> stackInt = new ArrayListStack<>();

        String postfix = InfixToPostfix.convert("(10+20)*9", stackChar);
        int result = PostfixEvaluator.evaluate(postfix, stackInt);

        assertEquals(270, result);
    }
}