package edu.sdsu.syntaxTree;

import java.util.List;

public interface IStatementFactory {
    public PenUp createPenUp();

    public PenDown createPenDown();

    public RepeatEnd createRepeatEnd(IntegerExpression value, Block block);

    public Turn createTurn(IntegerExpression value);

    public Move createMove(IntegerExpression value);

    public Variable createVariable(String identifier);

    public Constant createConstant(Integer value);

    public Assign createAssign(String identifier, IntegerExpression value);

    public Block createBlock(List<Statement> statementList);
}