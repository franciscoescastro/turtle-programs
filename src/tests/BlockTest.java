package tests;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BlockTest {
    @Test
    public void testInterpret() {
        Turtle turtle = new Turtle();
        Context context = new Context();
        List<Statement> statementList = new ArrayList<Statement>();
        statementList.add(new PenDown());
        statementList.add(new Assign("$key", new Constant(10)));
        statementList.add(new Move(new Variable("$key")));
        statementList.add(new Turn(new Constant(45)));
        statementList.add(new PenUp());

        Block block = new Block(statementList);
        block.interpret(turtle, context);

        assertEquals(new Double(10), turtle.location().getX());
        assertEquals(new Double(0), turtle.location().getY());
        assertEquals(45, turtle.direction());
        assertTrue(turtle.isPenUp());
    }
}
