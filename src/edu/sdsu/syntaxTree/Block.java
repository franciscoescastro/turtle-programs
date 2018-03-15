package edu.sdsu.syntaxTree;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.visitor.AbstractTurtleVisitor;

import java.util.Iterator;
import java.util.List;

public class Block implements Statement, Iterable<Statement> {
    private List<Statement> statementList;

    public Block(List<Statement> statementList) {
        this.statementList = statementList;
    }

    public void accept(AbstractTurtleVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Iterator<Statement> iterator() {
        return statementList.iterator();
    }

    @Override
    public void interpret(Turtle turtle, Context context) {
        for (Statement statement : statementList) {
            statement.interpret(turtle, context);
        }
    }
}
