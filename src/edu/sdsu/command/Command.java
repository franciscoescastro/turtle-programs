package edu.sdsu.command;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;

public abstract class Command {
    protected Turtle turtle;
    protected Context context;

    public Command(Turtle turtle, Context context) {
        this.turtle = turtle;
        this.context = context;
    }

    public abstract void execute();

    public abstract void undo();
}
