package tests;

import edu.sdsu.command.CommandListManager;
import edu.sdsu.command.PenDownCommand;
import edu.sdsu.command.PenUpCommand;
import edu.sdsu.parse.Parser;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Block;
import edu.sdsu.visitor.CommandVisitor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandListManagerTest {
    @Test
    public void testAdd() {
        CommandListManager commandListManager = new CommandListManager();
        assertTrue(commandListManager.add(new PenDownCommand(new Turtle(), null)));
    }

    @Test
    public void testAddAll() {
        CommandListManager commandListManager = new CommandListManager();
        CommandListManager commandListManagerAppend = new CommandListManager();

        Turtle turtle = new Turtle();
        commandListManagerAppend.add(new PenDownCommand(turtle, null));
        commandListManagerAppend.add(new PenUpCommand(turtle, null));
        assertTrue(commandListManager.addAll(commandListManagerAppend));
    }

    @Test
    public void testSize() {
        CommandListManager commandListManager = new CommandListManager();

        Turtle turtle = new Turtle();
        commandListManager.add(new PenDownCommand(turtle, null));
        commandListManager.add(new PenUpCommand(turtle, null));
        assertEquals(2, commandListManager.size());
    }

    @Test
    public void testHasNext() {
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
        Turtle turtle = new Turtle();
        Context context = new Context();
        Block block = parser.parse(code);
        CommandVisitor commandVisitor = new CommandVisitor(turtle, context);
        block.accept(commandVisitor);

        CommandListManager commandListManager = commandVisitor.getCommandListManager();

        int numberOfCommands = 0;
        while (commandListManager.hasNext()) {
            numberOfCommands++;
            commandListManager.next().execute();
        }

        assertEquals(29, numberOfCommands);
        assertEquals(29, commandListManager.size());
    }
}
