package tests;

import edu.sdsu.syntaxTree.Constant;
import edu.sdsu.syntaxTree.Turn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnTest {
    @Test
    public void testEvaluate() {
        Turn turn = new Turn(new Constant(10));
        assertEquals(10, turn.getDegrees().evaluate(null).intValue());
    }
}
