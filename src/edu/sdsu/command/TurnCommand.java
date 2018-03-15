package edu.sdsu.command;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Turn;

public class TurnCommand extends Command {
    private Turn turn;

    public TurnCommand(Turtle turtle, Context context, Turn turn) {
        super(turtle, context);
        this.turn = turn;
    }

    @Override
    public void execute() {
        turtle.turn(turn.getDegrees().evaluate(context));
    }

    @Override
    public void undo() {
        turtle.turn(-turn.getDegrees().evaluate(context));
    }
}
