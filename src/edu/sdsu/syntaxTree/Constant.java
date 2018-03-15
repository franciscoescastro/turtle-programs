package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;

public class Constant implements IntegerExpression {
    private Integer value;

    public Constant(Integer value) {
        this.value = value;
    }

    @Override
    public Integer evaluate(Context context) {
        return value;
    }
}
