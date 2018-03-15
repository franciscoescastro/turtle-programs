package tests;

import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.PenUp;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PenUpTest {
    @Test
    public void testInterpret() {
        Turtle turtle = new Turtle();
        turtle.penDown();
        PenUp penUp = new PenUp();
        penUp.interpret(turtle, null);
        assertTrue(turtle.isPenUp());
    }
}
