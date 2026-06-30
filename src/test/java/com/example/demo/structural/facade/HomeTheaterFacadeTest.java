package com.example.demo.structural.facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class HomeTheaterFacadeTest {

    @Test
    void watchMovie_outputsAllSubsystemSteps(CapturedOutput output) {
        new HomeTheaterFacade().watchMovie("Inception");
        assertThat(output).contains("[TV]");
        assertThat(output).contains("[Sound]");
        assertThat(output).contains("[Stream]");
        assertThat(output).contains("Inception");
    }

    @Test
    void endMovie_outputsShutdownMessages(CapturedOutput output) {
        HomeTheaterFacade facade = new HomeTheaterFacade();
        facade.watchMovie("Test");
        facade.endMovie();
        assertThat(output).contains("Amplifier off");
        assertThat(output).contains("Powered off");
        assertThat(output).contains("Disconnected");
    }

    @Test
    void watchMovieThenEnd_fullSequence(CapturedOutput output) {
        HomeTheaterFacade facade = new HomeTheaterFacade();
        facade.watchMovie("The Matrix");
        facade.endMovie();

        assertThat(output).contains("The Matrix", "Powered on", "Disconnected", "Powered off");

        // "Now playing: The Matrix" is unique to this test; lastIndexOf("Powered off") is
        // this test's shutdown (after any earlier tests' output that may be accumulated).
        String out = output.toString();
        int playIdx  = out.indexOf("Now playing: The Matrix");
        int tvOffIdx = out.lastIndexOf("Powered off");
        assertThat(playIdx).isGreaterThanOrEqualTo(0);
        assertThat(playIdx).isLessThan(tvOffIdx);
    }
}
