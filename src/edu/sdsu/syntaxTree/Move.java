package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.visitor.AbstractTurtleVisitor;

public class Move implements Statement {
    private IntegerExpression distance;

    public Move(IntegerExpression distance) {
        this.distance = distance;
    }

    public IntegerExpression getDistance() {
        return distance;
    }

    @Override
    public void interpret(Turtle turtle, Context context) {
        turtle.move(distance.evaluate(context));
    }

    @Override
    public void accept(AbstractTurtleVisitor visitor) {
        visitor.visit(this);
    }
}
