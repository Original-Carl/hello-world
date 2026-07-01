package com.example.demo.structural.decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class TextProcessorDecoratorTest {

    @Test
    void plain_passesThrough() {
        assertThat(new PlainTextProcessor().process("hello")).isEqualTo("hello");
    }

    @Test
    void trim_removesLeadingAndTrailingSpaces() {
        TextProcessor p = new TrimDecorator(new PlainTextProcessor());
        assertThat(p.process("  hello  ")).isEqualTo("hello");
    }

    @Test
    void upperCase_uppercasesResult() {
        TextProcessor p = new UpperCaseDecorator(new PlainTextProcessor());
        assertThat(p.process("hello")).isEqualTo("HELLO");
    }

    @Test
    void chain_trimThenUpperCase() {
        TextProcessor p = new UpperCaseDecorator(new TrimDecorator(new PlainTextProcessor()));
        assertThat(p.process("  hello  ")).isEqualTo("HELLO");
    }

    @Test
    void upperCaseAppliesAfterTrim_orderMatters() {
        TextProcessor trimFirst = new UpperCaseDecorator(new TrimDecorator(new PlainTextProcessor()));
        TextProcessor upperFirst = new TrimDecorator(new UpperCaseDecorator(new PlainTextProcessor()));
        assertThat(trimFirst.process("  hello  ")).isEqualTo("HELLO");
        assertThat(upperFirst.process("  hello  ")).isEqualTo("HELLO");
    }

    @Test
    void logging_returnsCorrectResult(CapturedOutput output) {
        TextProcessor p = new LoggingDecorator(new PlainTextProcessor());
        String result = p.process("test");
        assertThat(result).isEqualTo("test");
        assertThat(output.toString()).contains("test");
    }
}
