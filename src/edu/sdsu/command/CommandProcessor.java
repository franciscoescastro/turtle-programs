package edu.sdsu.command;

import java.util.Stack;

public class CommandProcessor {
    private static CommandProcessor instance;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    private CommandProcessor() {
        undoStack = new Stack<Command>();
        redoStack = new Stack<Command>();
    }

    public static CommandProcessor getInstance() {
        if (instance == null) {
            instance = new CommandProcessor();
        }
        return instance;
    }

    public void execute(Command command) {
        undoStack.push(command);
        command.execute();
    }

    public void undo() {
        if (undoStack.size() > 0) {
            Command command = undoStack.pop();
            redoStack.push(command);
            command.undo();
        }
    }

    public void redo() {
        if (redoStack.size() > 0) {
            Command command = redoStack.pop();
            undoStack.push(command);
            command.execute();
        }
    }
}