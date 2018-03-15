package tests;

import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.PenDown;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class PenDownTest {
    @Test
    public void testInterpret() {
        Turtle turtle = new Turtle();
        PenDown penDown = new PenDown();
        penDown.interpret(turtle, null);
        assertFalse(turtle.isPenUp());
    }
}
