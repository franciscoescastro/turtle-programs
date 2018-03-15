package edu.sdsu.visitor;

import edu.sdsu.command.*;
import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.*;

public class CommandVisitor extends AbstractTurtleVisitor {
    private CommandListManager commandListManager;

    public CommandVisitor(Turtle turtle, Context context) {
        super(turtle, context);
        commandListManager = new CommandListManager();
    }

    public CommandListManager getCommandListManager() {
        return commandListManager;
    }

    public void visit(RepeatEnd repeat) {
        commandListManager.add(new RepeatCommand(turtle, context, repeat));
        commandListManager.add(new EndCommand(null, null));
    }

    @Override
    public void visit(PenUp penUp) {
        commandListManager.add(new PenUpCommand(turtle, context));
    }

    @Override
    public void visit(PenDown penDown) {
        commandListManager.add(new PenDownCommand(turtle, context));
    }

    @Override
    public void visit(Move move) {
        commandListManager.add(new MoveCommand(turtle, context, move));
    }

    @Override
    public void visit(Turn turn) {
        commandListManager.add(new TurnCommand(turtle, context, turn));
    }

    @Override
    public void visit(Assign assign) {
        commandListManager.add(new AssignCommand(turtle, context, assign));
    }
}