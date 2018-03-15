package tests;

import edu.sdsu.syntaxTree.Constant;
import edu.sdsu.syntaxTree.Move;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveTest {
    @Test
    public void testEvaluate() {
        Move move = new Move(new Constant(10));
        assertEquals(10, move.getDistance().evaluate(null).intValue());
    }
}
