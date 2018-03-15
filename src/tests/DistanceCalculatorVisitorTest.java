package tests;

import edu.sdsu.parse.Parser;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Block;
import edu.sdsu.visitor.DistanceCalculatorVisitor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceCalculatorVisitorTest {
    @Test
    public void testGetTotalDistance() {
        String code = "move 10\nturn 90\nmove 20\nturn -60\nmove 15";
        Parser parser = new Parser();
        Turtle turtle = new Turtle();
        Block block = parser.parse(code);
        Context context = new Context();
        DistanceCalculatorVisitor visitor = new DistanceCalculatorVisitor(turtle, context);
        block.accept(visitor);

        assertEquals(45, visitor.getTotalDistance());
    }
}
