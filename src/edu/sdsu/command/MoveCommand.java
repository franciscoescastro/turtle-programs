package edu.sdsu.command;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Move;

public class MoveCommand extends Command {
    private Move move;

    public MoveCommand(Turtle turtle, Context context, Move move) {
        super(turtle, context);
        this.move = move;
    }

    @Override
    public void execute() {
        turtle.move(move.getDistance().evaluate(context));
    }

    @Override
    public void undo() {
        turtle.turn(180);
        turtle.move(move.getDistance().evaluate(context));
        turtle.turn(-180);
    }
}
