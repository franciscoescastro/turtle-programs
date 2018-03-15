package tests;

import edu.sdsu.syntaxTree.Constant;
import edu.sdsu.syntaxTree.IntegerExpression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstantTest {
    @Test
    public void testEvaluate() {
        IntegerExpression constant = new Constant(10);
        assertEquals(10, constant.evaluate(null).intValue());
    }
}
