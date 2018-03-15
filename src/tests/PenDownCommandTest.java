package tests;

import edu.sdsu.command.Command;
import edu.sdsu.command.PenDownCommand;
import edu.sdsu.program.Turtle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PenDownCommandTest {
    private Turtle turtle;
    private Command command;

    @Before
    public void setUp() {
        turtle = new Turtle();
        command = new PenDownCommand(turtle, null);
    }

    @Test
    public void testExecute() {
        command.execute();
        assertFalse(turtle.isPenUp());
    }

    @Test
    public void testUndo() {
        command.execute();
        command.undo();
        assertTrue(turtle.isPenUp());

        turtle.penDown();
        Command penDownCommand = new PenDownCommand(turtle, null);
        penDownCommand.execute();
        penDownCommand.undo();
        assertFalse(turtle.isPenUp());
    }
}
