package com.example.demo.behavioral.mediator;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ChatRoomTest {

    @Test
    void message_deliveredToAllOtherUsers() {
        ChatRoom room = new ChatRoom();
        ChatUser alice = new ChatUser("Alice", room);
        ChatUser bob = new ChatUser("Bob", room);
        room.register(alice);
        room.register(bob);
        alice.send("Hello");
        assertThat(bob.inbox()).contains("Hello");
    }

    @Test
    void message_notDeliveredToSender() {
        ChatRoom room = new ChatRoom();
        ChatUser alice = new ChatUser("Alice", room);
        ChatUser bob = new ChatUser("Bob", room);
        room.register(alice);
        room.register(bob);
        alice.send("Hello");
        assertThat(alice.inbox()).doesNotContain("Hello");
    }

    @Test
    void threeUsers_allReceiveFromOneUser() {
        ChatRoom room = new ChatRoom();
        ChatUser alice = new ChatUser("Alice", room);
        ChatUser bob = new ChatUser("Bob", room);
        ChatUser carol = new ChatUser("Carol", room);
        room.register(alice);
        room.register(bob);
        room.register(carol);
        alice.send("Hi everyone");
        assertThat(bob.inbox()).contains("Hi everyone");
        assertThat(carol.inbox()).contains("Hi everyone");
        assertThat(alice.inbox()).doesNotContain("Hi everyone");
    }

    @Test
    void multipleMessages_allDeliveredInOrder() {
        ChatRoom room = new ChatRoom();
        ChatUser alice = new ChatUser("Alice", room);
        ChatUser bob = new ChatUser("Bob", room);
        room.register(alice);
        room.register(bob);
        alice.send("first");
        alice.send("second");
        assertThat(bob.inbox()).containsSequence("first", "second");
    }

    @Test
    void chatUser_hasNoDirectReferenceToOtherChatUsers() {
        Field[] fields = ChatUser.class.getDeclaredFields();
        boolean hasUserField = Arrays.stream(fields)
                .anyMatch(f -> f.getType().equals(ChatUser.class));
        assertThat(hasUserField).isFalse();
    }
}
