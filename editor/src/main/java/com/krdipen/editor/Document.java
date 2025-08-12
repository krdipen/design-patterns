package com.krdipen.editor;

import java.util.Stack;

public class Document {
    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();
    private final StringBuilder text = new StringBuilder();

    public void execute(Command command) {
        text.append(command.getText());
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            redoStack.push(command);
            text.delete(text.length() - command.getText().length(), text.length());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            undoStack.push(command);
            text.append(command.getText());
        }
    }

    public String getText() {
        return text.toString();
    }
}
