package edu.sdsu.visitor;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.*;

import java.util.Iterator;

public abstract class AbstractTurtleVisitor {
    protected final Turtle turtle;
    protected final Context context;

    public AbstractTurtleVisitor(Turtle turtle, Context context) {
        this.turtle = turtle;
        this.context = context;
    }

    public void visit(Block block) {
        Iterator<Statement> iterator = block.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(this);
        }
    }

    public abstract void visit(RepeatEnd repeat);

    public abstract void visit(Assign assign);

    public abstract void visit(PenUp penUp);

    public abstract void visit(PenDown penDown);

    public abstract void visit(Move move);

    public abstract void visit(Turn turn);
}