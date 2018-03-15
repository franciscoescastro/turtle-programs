package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.visitor.AbstractTurtleVisitor;

public class Turn implements Statement {
    private IntegerExpression degrees;

    public Turn(IntegerExpression degrees) {
        this.degrees = degrees;
    }

    public IntegerExpression getDegrees() {
        return degrees;
    }

    @Override
    public void interpret(Turtle turtle, Context context) {
        turtle.turn(degrees.evaluate(context));
    }

    @Override
    public void accept(AbstractTurtleVisitor visitor) {
        visitor.visit(this);
    }
}
