package edu.sdsu.command;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;

public class EndCommand extends Command {
    public EndCommand(Turtle turtle, Context context) {
        super(turtle, context);
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}