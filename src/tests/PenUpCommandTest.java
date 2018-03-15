package tests;

import edu.sdsu.command.Command;
import edu.sdsu.command.PenUpCommand;
import edu.sdsu.program.Turtle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PenUpCommandTest {
    private Turtle turtle;
    private Command command;

    @Before
    public void setUp() {
        turtle = new Turtle();
        turtle.penDown();
        command = new PenUpCommand(turtle, null);
    }

    @Test
    public void testExecute() {
        command.execute();
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void testUndo() {
        command.execute();
        command.undo();
        assertFalse(turtle.isPenUp());

        turtle.penUp();
        Command penUpCommand = new PenUpCommand(turtle, null);
        penUpCommand.execute();
        penUpCommand.undo();
        assertTrue(turtle.isPenUp());
    }
}
