package edu.sdsu.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CommandListManager implements Iterator<Command> {
    private int currentIndex;
    private List<Command> commandList;

    public CommandListManager() {
        currentIndex = 0;
        this.commandList = new ArrayList<Command>();
    }

    public boolean add(Command command) {
        return commandList.add(command);
    }

    public boolean addAll(CommandListManager commandListManager) {
        return this.commandList.addAll(commandListManager.commandList);
    }

    private Command get(int index) {
        Command command = commandList.get(index);
        if (isRepeatCommand(command)) {
            extractLoopList(index, (RepeatCommand) command);
            return get(index);
        }
        return command;
    }

    private boolean isRepeatCommand(Command command) {
        return command instanceof RepeatCommand;
    }

    private void extractLoopList(int index, RepeatCommand repeatCommand) {
        System.out.println(index);
        if (repeatCommand.hasLoop()) {
            repeatCommand.execute();
            List<Command> commandListExtracted =
                    repeatCommand.getCommandListManager().commandList;
            if (commandListExtracted != null)
                commandList.addAll(index, commandListExtracted);
        } else {
            commandList.remove(index);
        }
    }

    public int size() {
        return commandList.size();
    }

    @Override
    public boolean hasNext() {
        return currentIndex < commandList.size();
    }

    @Override
    public Command next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return get(currentIndex++);
    }
}