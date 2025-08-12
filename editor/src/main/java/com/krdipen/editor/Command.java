package com.krdipen.editor;

public class Command {
    private final String text;

    public Command(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
