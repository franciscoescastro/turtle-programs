package tests;

import edu.sdsu.command.AssignCommand;
import edu.sdsu.command.Command;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Assign;
import edu.sdsu.syntaxTree.Constant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class AssignCommandTest {
    private Turtle turtle;
    private Command command;
    private Context context;

    @Before
    public void setUp() {
        turtle = new Turtle();
        context = new Context();
        command = new AssignCommand(turtle, context, new Assign("$key", new Constant(20)));
    }

    @Test
    public void testExecute() {
        command.execute();
        assertEquals(new Integer(20), context.get("$key"));
    }

    @Test
    public void testUndo() {
        command.execute();

        Command assignCommand = new AssignCommand(turtle, context, new Assign("$key", new Constant(10)));
        assignCommand.execute();
        assertEquals(new Integer(10), context.get("$key"));

        assignCommand.undo();
        assertEquals(new Integer(20), context.get("$key"));

        command.undo();
        assertNull(context.get("$key"));
    }
}
