package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.visitor.AbstractTurtleVisitor;

public class Assign implements Statement {
    private String identifier;
    private IntegerExpression value;

    public Assign(String identifier, IntegerExpression value) {
        this.identifier = identifier;
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public IntegerExpression getValue() {
        return value;
    }

    @Override
    public void interpret(Turtle turtle, Context context) {
        context.put(identifier, value.evaluate(context));
    }

    @Override
    public void accept(AbstractTurtleVisitor visitor) {
        visitor.visit(this);
    }
}
