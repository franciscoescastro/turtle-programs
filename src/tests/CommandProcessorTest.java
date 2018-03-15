package tests;

import edu.sdsu.command.*;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CommandProcessorTest {
    private final double EPSILON = 0.01;
    private Turtle turtle;
    private Context context;
    private List<Command> commandList;

    @Before
    public void setUp() {
        turtle = new Turtle();
        context = new Context();
        commandList = new ArrayList<Command>();
        commandList.add(new AssignCommand(turtle, context, new Assign("$length", new Constant(10))));
        commandList.add(new MoveCommand(turtle, context, new Move(new Variable("$length"))));
        commandList.add(new TurnCommand(turtle, context, new Turn(new Constant(90))));
        commandList.add(new MoveCommand(turtle, context, new Move(new Constant(20))));
        commandList.add(new TurnCommand(turtle, context, new Turn(new Constant(-60))));
        commandList.add(new AssignCommand(turtle, context, new Assign("$length", new Constant(15))));
        commandList.add(new MoveCommand(turtle, context, new Move(new Variable("$length"))));
    }

    @Test
    public void testDoIt() {
        CommandProcessor.getInstance().execute(commandList.get(0));
        assertEquals(new Integer(10), context.get("$length"));

        CommandProcessor.getInstance().execute(commandList.get(1));
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(0, turtle.location().getY(), EPSILON);
        assertEquals(0, turtle.direction());

        CommandProcessor.getInstance().execute(commandList.get(2));
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(0, turtle.location().getY(), EPSILON);
        assertEquals(90, turtle.direction());

        CommandProcessor.getInstance().execute(commandList.get(3));
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(20, turtle.location().getY(), EPSILON);
        assertEquals(90, turtle.direction());

        CommandProcessor.getInstance().execute(commandList.get(4));
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(20, turtle.location().getY(), EPSILON);
        assertEquals(30, turtle.direction());

        CommandProcessor.getInstance().execute(commandList.get(5));
        assertEquals(new Integer(15), context.get("$length"));
        CommandProcessor.getInstance().execute(commandList.get(6));
        assertEquals(22.99, turtle.location().getX(), EPSILON);
        assertEquals(27.5, turtle.location().getY(), EPSILON);
        assertEquals(30, turtle.direction());
    }

    @Test
    public void undoTest() {
        for (Command command : commandList) {
            CommandProcessor.getInstance().execute(command);
        }

        CommandProcessor.getInstance().undo();
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(20, turtle.location().getY(), EPSILON);
        assertEquals(30, turtle.direction());
        assertEquals(new Integer(15), context.get("$length"));

        CommandProcessor.getInstance().undo();
        assertEquals(new Integer(10), context.get("$length"));

        CommandProcessor.getInstance().undo();
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(20, turtle.location().getY(), EPSILON);
        assertEquals(90, turtle.direction());

        CommandProcessor.getInstance().undo();
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(0, turtle.location().getY(), EPSILON);
        assertEquals(90, turtle.direction());

        CommandProcessor.getInstance().undo();
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(0, turtle.location().getY(), EPSILON);
        assertEquals(0, turtle.direction());

        CommandProcessor.getInstance().undo();
        assertEquals(0, turtle.location().getX(), EPSILON);
        assertEquals(0, turtle.location().getY(), EPSILON);
        assertEquals(0, turtle.direction());
        assertEquals(new Integer(10), context.get("$length"));

        CommandProcessor.getInstance().undo();
        assertNull(context.get("$length"));
    }

    @Test
    public void redoTest() {
        for (Command command : commandList) {
            CommandProcessor.getInstance().execute(command);
        }

        CommandProcessor.getInstance().undo();
        CommandProcessor.getInstance().redo();
        assertEquals(22.99, turtle.location().getX(), EPSILON);
        assertEquals(27.5, turtle.location().getY(), EPSILON);
        assertEquals(30, turtle.direction());

        CommandProcessor.getInstance().undo();
        CommandProcessor.getInstance().undo();
        CommandProcessor.getInstance().undo();
        CommandProcessor.getInstance().redo();
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(20, turtle.location().getY(), EPSILON);
        assertEquals(30, turtle.direction());

        CommandProcessor.getInstance().undo();
        CommandProcessor.getInstance().undo();
        CommandProcessor.getInstance().undo();
        CommandProcessor.getInstance().redo();
        assertEquals(10, turtle.location().getX(), EPSILON);
        assertEquals(0, turtle.location().getY(), EPSILON);
        assertEquals(90, turtle.direction());

        CommandProcessor.getInstance().undo();
        CommandProcessor.getInstance().undo();
        assertEquals(0, turtle.location().getX(), EPSILON);
        assertEquals(0, turtle.location().getY(), EPSILON);
        assertEquals(0, turtle.direction());
    }
}
