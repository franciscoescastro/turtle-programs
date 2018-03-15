package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.visitor.AbstractTurtleVisitor;

public class RepeatEnd implements Statement {
    private IntegerExpression times;
    private Block block;

    public RepeatEnd(IntegerExpression times, Block block) {
        this.times = times;
        this.block = block;
    }

    public IntegerExpression getTimes() {
        return times;
    }

    public Block getBlock() {
        return block;
    }

    @Override
    public void interpret(Turtle turtle, Context context) {
        for (int i = 0; i < times.evaluate(context); i++) {
            block.interpret(turtle, context);
        }
    }

    @Override
    public void accept(AbstractTurtleVisitor visitor) {
        visitor.visit(this);
    }
}