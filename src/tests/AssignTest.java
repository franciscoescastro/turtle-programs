package tests;

import edu.sdsu.program.Context;
import edu.sdsu.syntaxTree.Assign;
import edu.sdsu.syntaxTree.Variable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssignTest {
    @Test
    public void testInterpret() {
        Context context = new Context();
        context.put("$length", 10);
        Assign assign = new Assign("$key", new Variable("$length"));
        assign.interpret(null, context);

        assertEquals(10, context.get(assign.getIdentifier()).intValue());
    }
}
