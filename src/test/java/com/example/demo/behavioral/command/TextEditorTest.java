package com.example.demo.behavioral.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TextEditorTest {

    private TextEditor editor;

    @BeforeEach
    void setUp() { editor = new TextEditor(); }

    @Test
    void initialContent_isEmpty() {
        assertThat(editor.content()).isEmpty();
    }

    @Test
    void writeAction_appendsText() {
        editor.execute(new WriteAction(editor, "Hello"));
        assertThat(editor.content()).isEqualTo("Hello");
    }

    @Test
    void writeAction_undo_removesText() {
        editor.execute(new WriteAction(editor, "Hello"));
        editor.undo();
        assertThat(editor.content()).isEmpty();
    }

    @Test
    void multipleWrites_concatenate() {
        editor.execute(new WriteAction(editor, "Hello"));
        editor.execute(new WriteAction(editor, ", World"));
        assertThat(editor.content()).isEqualTo("Hello, World");
    }

    @Test
    void deleteLastAction_removesTrailingChars() {
        editor.execute(new WriteAction(editor, "Hello, World"));
        editor.execute(new DeleteLastAction(editor, 6));
        assertThat(editor.content()).isEqualTo("Hello,");
    }

    @Test
    void deleteLastAction_undo_restoresDeletedChars() {
        editor.execute(new WriteAction(editor, "Hello, World"));
        editor.execute(new DeleteLastAction(editor, 6));
        editor.undo();
        assertThat(editor.content()).isEqualTo("Hello, World");
    }

    @Test
    void multipleUndos_restoreInReverseOrder() {
        editor.execute(new WriteAction(editor, "Hello"));
        editor.execute(new WriteAction(editor, ", World"));
        editor.undo();
        assertThat(editor.content()).isEqualTo("Hello");
        editor.undo();
        assertThat(editor.content()).isEmpty();
    }

    @Test
    void undo_onEmptyHistory_isNoOp() {
        assertDoesNotThrow(() -> editor.undo());
        assertThat(editor.content()).isEmpty();
    }

    @Test
    void deleteMoreThanBufferLength_clampsToStart() {
        editor.execute(new WriteAction(editor, "Hi"));
        editor.execute(new DeleteLastAction(editor, 100));
        assertThat(editor.content()).isEmpty();
    }

    @Test
    void deleteMoreThanBufferLength_undo_restoresOriginal() {
        editor.execute(new WriteAction(editor, "Hi"));
        editor.execute(new DeleteLastAction(editor, 100));
        editor.undo();
        assertThat(editor.content()).isEqualTo("Hi");
    }
}
