package tests;

import edu.sdsu.parse.Parser;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Block;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    private final double EPSILON = 0.01;

    @Test
    public void testParse() {
        String code =
                "$length = 5\n"
                        + "move 10\n"
                        + "turn 90\n"
                        + "move 20\n"
                        + "turn -60\n"
                        + "penDown\n"
                        + "move 15\n"
                        + "$number = 4\n"
                        + "repeat $number\n"
                        + " turn 10\n"
                        + "end\n"
                        + "penUp\n"
                        + "move $length";
        Parser parser = new Parser();
        Turtle turtle = new Turtle();
        Context context = new Context();

        Block block = parser.parse(code);
        assertNotNull(block);

        block.interpret(turtle, context);
        assertEquals(24.7, turtle.location().getX(), EPSILON);
        assertEquals(32.2, turtle.location().getY(), EPSILON);
        assertEquals(70, turtle.direction());
        assertTrue(turtle.isPenUp());
    }
}
