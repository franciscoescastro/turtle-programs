package tests;

import edu.sdsu.command.Command;
import edu.sdsu.command.TurnCommand;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Constant;
import edu.sdsu.syntaxTree.Turn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnCommandTest {
    private Turtle turtle;
    private Command command;
    private Context context;

    @Before
    public void setUp() {
        turtle = new Turtle();
        context = new Context();
        command = new TurnCommand(turtle, context, new Turn(new Constant(30)));
    }

    @Test
    public void testExecute() {
        command.execute();
        assertEquals(30, turtle.direction());
    }

    @Test
    public void testUndo() {
        command.execute();
        command.undo();
        assertEquals(0, turtle.direction());
    }
}
