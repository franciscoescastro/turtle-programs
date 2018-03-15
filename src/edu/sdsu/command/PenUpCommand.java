package edu.sdsu.command;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;

public class PenUpCommand extends Command {
    private boolean penUpState;

    public PenUpCommand(Turtle turtle, Context context) {
        super(turtle, context);
        penUpState = turtle.isPenUp();
    }

    @Override
    public void execute() {
        turtle.penUp();
    }

    @Override
    public void undo() {
        if (!penUpState) {
            turtle.penDown();
        }
    }
}
