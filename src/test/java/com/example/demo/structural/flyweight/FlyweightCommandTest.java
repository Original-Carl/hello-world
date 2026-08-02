package com.example.demo.structural.flyweight;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class FlyweightCommandTest {

    @Test
    void run_showsEnemyUnitsAndSharedTypeCount(CapturedOutput output) {
        new FlyweightCommand().run();
        assertThat(output).contains("Xenomorph Scout")
                          .contains("Plasma Drone")
                          .contains("Void Wraith")
                          .doesNotContain("[stub");
    }

    @Test
    void run_reportsFewerTypesThanUnits(CapturedOutput output) {
        new FlyweightCommand().run();
        // Demo spawns 12 units of 3 types — output must mention "3" types and "12" units
        assertThat(output).contains("12").contains("3");
    }
}
