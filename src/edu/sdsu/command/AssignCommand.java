package edu.sdsu.command;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.Assign;

public class AssignCommand extends Command {
    private Assign assign;
    public Integer previousValue;

    public AssignCommand(Turtle turtle, Context context, Assign assign) {
        super(turtle, context);
        this.assign = assign;
    }

    @Override
    public void execute() {
        previousValue = context.get(assign.getIdentifier());
        context.put(assign.getIdentifier(), assign.getValue().evaluate(context));
    }

    @Override
    public void undo() {
        if (previousValue == null) {
            context.remove(assign.getIdentifier());
        } else {
            context.put(assign.getIdentifier(), previousValue);
        }
    }
}