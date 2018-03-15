package tests;

import edu.sdsu.syntaxTree.Constant;
import edu.sdsu.syntaxTree.RepeatEnd;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepeatEndTest {
    @Test
    public void testEvaluate() {
        RepeatEnd repeat = new RepeatEnd(new Constant(10), null);
        assertEquals(10, repeat.getTimes().evaluate(null).intValue());
    }
}
