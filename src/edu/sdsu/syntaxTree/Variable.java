package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;

public class Variable implements IntegerExpression {
    private String identifier;

    public Variable(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public Integer evaluate(Context context) {
        return context.get(identifier);
    }
}
