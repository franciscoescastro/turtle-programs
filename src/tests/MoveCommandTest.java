package tests;

import edu.sdsu.Point;
import edu.sdsu.command.Command;
import edu.sdsu.command.MoveCommand;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Constant;
import edu.sdsu.syntaxTree.Move;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveCommandTest {
    private Turtle turtle;
    private Command command;
    private Context context;

    @Before
    public void setUp() {
        turtle = new Turtle();
        command = new MoveCommand(turtle, context, new Move(new Constant(20)));
    }

    @Test
    public void testExecute() {
        command.execute();
        Point expectedLocation = new Point(20.0, 0.0);
        assertEquals(expectedLocation.getX(), turtle.location().getX());
        assertEquals(expectedLocation.getY(), turtle.location().getY());
    }

    @Test
    public void testUndo() {
        command.execute();
        command.undo();
        Point expectedLocation = new Point(0.0, 0.0);
        assertEquals(expectedLocation.getX(), turtle.location().getX());
        assertEquals(expectedLocation.getY(), turtle.location().getY());
    }
}
