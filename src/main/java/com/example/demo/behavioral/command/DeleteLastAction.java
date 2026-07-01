package com.example.demo.behavioral.command;

public class DeleteLastAction implements EditAction {
    private final TextEditor editor;
    private final int count;
    private String deleted;

    public DeleteLastAction(TextEditor editor, int count) {
        this.editor = editor;
        this.count = count;
    }

    @Override
    public void execute() {
        int len = editor.buffer().length();
        int from = Math.max(0, len - count);
        deleted = editor.buffer().substring(from);
        editor.buffer().delete(from, len);
        System.out.println("    [exec] DeleteLast(" + count + ")     → \"" + editor.content() + "\"");
    }

    @Override
    public void undo() {
        editor.buffer().append(deleted);
        System.out.println("    [undo] DeleteLast(" + count + ")     → \"" + editor.content() + "\"");
    }
}
