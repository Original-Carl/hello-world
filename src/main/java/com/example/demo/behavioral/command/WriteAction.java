package com.example.demo.behavioral.command;

public class WriteAction implements EditAction {
    private final TextEditor editor;
    private final String text;

    public WriteAction(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.buffer().append(text);
        System.out.println("    [exec] Write(\"" + text + "\")   → \"" + editor.content() + "\"");
    }

    @Override
    public void undo() {
        int len = editor.buffer().length();
        editor.buffer().delete(len - text.length(), len);
        System.out.println("    [undo] Write(\"" + text + "\")   → \"" + editor.content() + "\"");
    }
}
