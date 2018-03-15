package tests;

import edu.sdsu.command.AssignCommand;
import edu.sdsu.command.CommandListManager;
import edu.sdsu.command.MoveCommand;
import edu.sdsu.command.TurnCommand;
import edu.sdsu.parse.Parser;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Block;
import edu.sdsu.visitor.CommandVisitor;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandVisitorTest {
    @Test
    public void testGetCommandList() {
        String code = "$length = 10\nmove $length\nturn 90\nmove 20\nturn -60\nmove 15\n$length = 5\nmove $length";
        Parser parser = new Parser();
        Turtle turtle = new Turtle();
        Context context = new Context();
        Block block = parser.parse(code);
        CommandVisitor visitor = new CommandVisitor(turtle, context);
        block.accept(visitor);

        CommandListManager commandList = visitor.getCommandListManager();
        assertNotNull(commandList);
        assertEquals(8, commandList.size());
        assertTrue(commandList.next() instanceof AssignCommand);
        assertTrue(commandList.next() instanceof MoveCommand);
        assertTrue(commandList.next() instanceof TurnCommand);
        assertTrue(commandList.next() instanceof MoveCommand);
        assertTrue(commandList.next() instanceof TurnCommand);
        assertTrue(commandList.next() instanceof MoveCommand);
        assertTrue(commandList.next() instanceof AssignCommand);
        assertTrue(commandList.next() instanceof MoveCommand);
    }
}
