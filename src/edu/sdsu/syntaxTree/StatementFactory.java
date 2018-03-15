package edu.sdsu.syntaxTree;

import java.util.List;

public class StatementFactory implements IStatementFactory {
    private static IStatementFactory instance;

    private StatementFactory() {
    }

    public static IStatementFactory getInstance() {
        if (instance == null) {
            instance = new StatementFactory();
        }
        return instance;
    }

    @Override
    public PenUp createPenUp() {
        return new PenUp();
    }

    @Override
    public PenDown createPenDown() {
        return new PenDown();
    }

    @Override
    public RepeatEnd createRepeatEnd(IntegerExpression value, Block block) {
        return new RepeatEnd(value, block);
    }

    @Override
    public Turn createTurn(IntegerExpression value) {
        return new Turn(value);
    }

    @Override
    public Move createMove(IntegerExpression value) {
        return new Move(value);
    }

    @Override
    public Variable createVariable(String identifier) {
        return new Variable(identifier);
    }

    @Override
    public Constant createConstant(Integer value) {
        return new Constant(value);
    }

    @Override
    public Assign createAssign(String identifier, IntegerExpression value) {
        return new Assign(identifier, value);
    }

    @Override
    public Block createBlock(List<Statement> statementList) {
        return new Block(statementList);
    }
}