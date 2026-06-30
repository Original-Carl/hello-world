package com.example.demo.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditor {
    private final StringBuilder buffer = new StringBuilder();
    private final Deque<EditAction> history = new ArrayDeque<>();

    public void execute(EditAction action) {
        action.execute();
        history.push(action);
    }

    public void undo() {
        if (!history.isEmpty()) history.pop().undo();
    }

    public String content() { return buffer.toString(); }
    public StringBuilder buffer() { return buffer; }
}
