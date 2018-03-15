package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.visitor.AbstractTurtleVisitor;

public class PenDown implements Statement {
    @Override
    public void interpret(Turtle turtle, Context context) {
        turtle.penDown();
    }

    @Override
    public void accept(AbstractTurtleVisitor visitor) {
        visitor.visit(this);
    }
}