package edu.sdsu.command;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.RepeatEnd;
import edu.sdsu.visitor.CommandVisitor;

public class RepeatCommand extends Command {
    private CommandListManager commandListManager;
    private RepeatEnd repeat;
    private int index = 0;

    public RepeatCommand(Turtle turtle, Context context, RepeatEnd repeat) {
        super(turtle, context);
        this.repeat = repeat;
    }

    @Override
    public void execute() {
        if (repeat.getTimes().evaluate(context) > index) {
            CommandVisitor visitor = new CommandVisitor(turtle, context);
            repeat.getBlock().accept(visitor);
            commandListManager = visitor.getCommandListManager();
            index++;
        }
    }

    @Override
    public void undo() {
    }

    public CommandListManager getCommandListManager() {
        return commandListManager;
    }

    public boolean hasLoop() {
        return index < repeat.getTimes().evaluate(context);
    }
}