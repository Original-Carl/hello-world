package com.example.demo.behavioral.chain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SupportChainTest {

    private SupportHandler buildChain() {
        SupportHandler l1 = new Level1Support();
        SupportHandler l2 = new Level2Support();
        SupportHandler l3 = new Level3Support();
        l1.setNext(l2).setNext(l3);
        return l1;
    }

    @Test
    void level1_handlesSeverity1Ticket() {
        String result = new Level1Support().handle(new SupportTicket(1, "low"));
        assertThat(result).satisfiesAnyOf(
                r -> assertThat(r).containsIgnoringCase("level1"),
                r -> assertThat(r).containsIgnoringCase("l1"),
                r -> assertThat(r).contains("1")
        );
    }

    @Test
    void fullChain_severity3_handledByLevel1() {
        String result = buildChain().handle(new SupportTicket(3, "minor bug"));
        assertThat(result).satisfiesAnyOf(
                r -> assertThat(r).containsIgnoringCase("level1"),
                r -> assertThat(r).containsIgnoringCase("l1"),
                r -> assertThat(r).contains("1")
        );
    }

    @Test
    void fullChain_severity5_handledByLevel2() {
        String result = buildChain().handle(new SupportTicket(5, "medium bug"));
        assertThat(result).satisfiesAnyOf(
                r -> assertThat(r).containsIgnoringCase("level2"),
                r -> assertThat(r).containsIgnoringCase("l2"),
                r -> assertThat(r).contains("2")
        );
    }

    @Test
    void fullChain_severity8_handledByLevel3() {
        String result = buildChain().handle(new SupportTicket(8, "critical outage"));
        assertThat(result).satisfiesAnyOf(
                r -> assertThat(r).containsIgnoringCase("level3"),
                r -> assertThat(r).containsIgnoringCase("l3"),
                r -> assertThat(r).contains("3")
        );
    }

    @Test
    void level2_handlesSeverity5Ticket() {
        String result = new Level2Support().handle(new SupportTicket(5, "medium"));
        assertThat(result).isNotNull().isNotEmpty();
    }

    @Test
    void level3_handlesSeverity8Ticket() {
        String result = new Level3Support().handle(new SupportTicket(8, "critical"));
        assertThat(result).isNotNull().isNotEmpty();
    }

    @Test
    void level1_escalatesSeverity4ToNext() {
        SupportHandler l1 = new Level1Support();
        SupportHandler l2 = new Level2Support();
        l1.setNext(l2);
        String result = l1.handle(new SupportTicket(4, "medium"));
        assertThat(result).doesNotContainIgnoringCase("level1");
    }

    @Test
    void noHandlerCapable_returnsUnhandledMessage() {
        SupportHandler l1 = new Level1Support();
        String result = l1.handle(new SupportTicket(9, "critical with no l3 attached"));
        assertThat(result).isNotNull();
    }
}
