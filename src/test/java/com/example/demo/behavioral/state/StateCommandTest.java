package com.example.demo.behavioral.state;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class StateCommandTest {

    @Test
    void run_printsDescriptionAndStubMarker(CapturedOutput output) {
        new StateCommand().run();
        assertThat(output.toString().trim()).isNotEmpty();
        assertThat(output).doesNotContain("[stub — full demo coming]");
    }
}
