package edu.sdsu.visitor;

import edu.sdsu.program.Context;
import edu.sdsu.program.Turtle;
import edu.sdsu.syntaxTree.*;

public class DistanceCalculatorVisitor extends AbstractTurtleVisitor {
    private int totalDistance;

    public DistanceCalculatorVisitor(Turtle turtle, Context context) {
        super(turtle, context);
        totalDistance = 0;
    }

    @Override
    public void visit(Move move) {
        totalDistance += move.getDistance().evaluate(context);
    }

    @Override
    public void visit(RepeatEnd repeat) {
        for (int i = 0; i < repeat.getTimes().evaluate(context); i++) {
            repeat.getBlock().accept(this);
        }
    }

    @Override
    public void visit(Assign assign) {
        context.put(assign.getIdentifier(), assign.getValue().evaluate(context));
    }

    @Override
    public void visit(PenUp penUp) {
    }

    @Override
    public void visit(PenDown penDown) {
    }

    @Override
    public void visit(Turn turn) {
    }

    public int getTotalDistance() {
        return totalDistance;
    }
}
