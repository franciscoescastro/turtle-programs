package tests;

import edu.sdsu.command.CommandListManager;
import edu.sdsu.command.CommandProcessor;
import edu.sdsu.parse.Parser;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Block;
import edu.sdsu.visitor.CommandVisitor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExecuteTest {
    @Test
    public void execute1() {
        String code = "penDown\nmove 10\nturn 90\nmove 20\nturn -60\nmove 15\npenUp";
        Parser parser = new Parser();
        Turtle turtle1 = new Turtle();
        Context context1 = new Context();
        Block block = parser.parse(code);
        block.interpret(turtle1, context1);
        Turtle turtle2 = new Turtle();
        Context context2 = new Context();
        CommandVisitor visitor = new CommandVisitor(turtle2, context2);
        block.accept(visitor);
        CommandListManager commandListManager = visitor.getCommandListManager();

        while (commandListManager.hasNext()) {
            CommandProcessor.getInstance().execute(commandListManager.next());
        }

        assertTrue(turtle1.isPenUp());
        assertEquals(30, turtle1.direction());
        assertEquals(new Double(22.99), turtle1.location().getX());
        assertEquals(new Double(27.5), turtle1.location().getY());
        assertEquals(turtle1.direction(), turtle2.direction());
        assertEquals(turtle1.location().getX(), turtle2.location().getX());
        assertEquals(turtle1.location().getY(), turtle2.location().getY());
        assertEquals(turtle1.isPenUp(), turtle2.isPenUp());
    }

    @Test
    public void execute2() {
        String code = "penDown\n"
                + "turn 50\n"
                + "$key = 2\n"
                + "repeat 3\n"
                + " move 2\n"
                + " repeat $key\n"
                + " turn 45\n"
                + " move 20\n"
                + " end\n"
                + " $key = 3\n"
                + "end";
        Parser parser = new Parser();
        Turtle turtle1 = new Turtle();
        Context context1 = new Context();
        Block block = parser.parse(code);
        block.interpret(turtle1, context1);
        Turtle turtle2 = new Turtle();
        Context context2 = new Context();
        CommandVisitor visitor = new CommandVisitor(turtle2, context2);
        block.accept(visitor);
        CommandListManager commandListManager = visitor.getCommandListManager();
        while (commandListManager.hasNext()) {
            CommandProcessor.getInstance().execute(commandListManager.next());
        }
        assertFalse(turtle1.isPenUp());
        assertEquals(410, turtle1.direction());
        assertEquals(new Double(-0.07), turtle1.location().getX());
        assertEquals(new Double(0.83), turtle1.location().getY());
        assertEquals(turtle1.direction(), turtle2.direction());
        assertEquals(turtle1.location().getX(), turtle2.location().getX());
        assertEquals(turtle1.location().getY(), turtle2.location().getY());
        assertEquals(turtle1.isPenUp(), turtle2.isPenUp());
    }

    @Test
    public void testExecute3() {
        String code = "penDown\n"
                + "$key = 2\n"
                + "repeat $key\n"
                + " move 10\n"
                + " turn 60\n"
                + " $key = 5\n"
                + "end";
        Parser parser = new Parser();
        Turtle turtle1 = new Turtle();
        Context context1 = new Context();
        Block block = parser.parse(code);
        block.interpret(turtle1, context1);
        Turtle turtle2 = new Turtle();
        Context context2 = new Context();
        CommandVisitor visitor = new CommandVisitor(turtle2, context2);
        block.accept(visitor);
        CommandListManager commandListManager = visitor.getCommandListManager();
        while (commandListManager.hasNext()) {
            CommandProcessor.getInstance().execute(commandListManager.next());
        }
        assertFalse(turtle1.isPenUp());
        assertEquals(300, turtle1.direction());
        assertEquals(new Double(-5.0), turtle1.location().getX());
        assertEquals(new Double(8.66), turtle1.location().getY());
        assertEquals(turtle1.direction(), turtle2.direction());
        assertEquals(turtle1.location().getX(), turtle2.location().getX());
        assertEquals(turtle1.location().getY(), turtle2.location().getY());
        assertEquals(turtle1.isPenUp(), turtle2.isPenUp());
        System.out.println(turtle2);
    }
}
