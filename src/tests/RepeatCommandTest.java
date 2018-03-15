package tests;

import edu.sdsu.command.CommandListManager;
import edu.sdsu.command.EndCommand;
import edu.sdsu.command.RepeatCommand;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RepeatCommandTest {
    @Test
    public void testExecute() {
        Turtle turtle = new Turtle();
        Context context = new Context();
        String key = "$k";
        context.put(key, 2);

        List<Statement> statementList = new ArrayList<Statement>();
        statementList.add(new Move(new Constant(10)));
        statementList.add(new Turn(new Constant(60)));
        statementList.add(new Assign(key, new Constant(5)));

        Block block = new Block(statementList);

        RepeatEnd repeat = new RepeatEnd(new Variable(key), block);

        RepeatCommand repeatCommand = new RepeatCommand(turtle, context, repeat);
        CommandListManager commandListManager = new CommandListManager();
        commandListManager.add(repeatCommand);
        commandListManager.add(new EndCommand(null, null));

        while (commandListManager.hasNext()) {
            commandListManager.next().execute();
        }
        assertEquals(16, commandListManager.size());
    }
}
