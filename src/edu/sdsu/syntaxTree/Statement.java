package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.visitor.AbstractTurtleVisitor;

public interface Statement {
    public void interpret(Turtle turtle, Context context);

    public void accept(AbstractTurtleVisitor visitor);
}
