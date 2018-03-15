package edu.sdsu.command;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;

public class PenDownCommand extends Command {
    private boolean penUpState;

    public PenDownCommand(Turtle turtle, Context context) {
        super(turtle, context);
        penUpState = turtle.isPenUp();
    }

    @Override
    public void execute() {
        turtle.penDown();
    }

    @Override
    public void undo() {
        if (penUpState) {
            turtle.penUp();
        }
    }
}
