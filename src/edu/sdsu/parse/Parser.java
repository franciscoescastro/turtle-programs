package edu.sdsu.parse;

import edu.sdsu.syntaxTree.Block;
import edu.sdsu.syntaxTree.IntegerExpression;
import edu.sdsu.syntaxTree.Statement;
import edu.sdsu.syntaxTree.StatementFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Parser {
    private static final String PEN_DOWN = "penDown";
    private static final String PEN_UP = "penUp";
    private static final String MOVE = "move";
    private static final String TURN = "turn";
    private static final String REPEAT = "repeat";
    private static final String END = "end";
    private static final String VAR_DECLARATION = "$";
    private StringTokenizer tokens;

    public Block parse(String code) {
        tokens = new StringTokenizer(code.replaceAll("=", "").trim());
        return parseBlock();
    }

    private Block parseBlock() {
        List<Statement> statementList = new ArrayList<Statement>();
        String token;
        while (tokens.hasMoreTokens()
                && !(token = tokens.nextToken()).equals(END)) {
            statementList.add(parseToken(token));
        }
        return new Block(statementList);
    }

    private Statement parseToken(String token) {
        switch (token) {
            case PEN_DOWN:
                return StatementFactory.getInstance().createPenDown();
            case PEN_UP:
                return StatementFactory.getInstance().createPenUp();
            case MOVE:
                return StatementFactory.getInstance().createMove(
                        parserIntegerExpression(tokens.nextToken()));
            case TURN:
                return StatementFactory.getInstance().createTurn(
                        parserIntegerExpression(tokens.nextToken()));
            case REPEAT:
                return StatementFactory.getInstance().createRepeatEnd(
                        parserIntegerExpression(tokens.nextToken()),
                        parseBlock());
            default:
                if (isVariableDeclaration(token)) {
                    return StatementFactory.getInstance().createAssign(token,
                            parserIntegerExpression(tokens.nextToken()));
                }
                throw new NoSuchElementException("Token does not exist!");
        }
    }

    private IntegerExpression parserIntegerExpression(String token) {
        if (isVariableDeclaration(token)) {
            return StatementFactory.getInstance().createVariable(token);
        }
        return StatementFactory.getInstance().createConstant(Integer.parseInt(token));
    }

    private boolean isVariableDeclaration(String token) {
        return token.startsWith(VAR_DECLARATION);
    }
}