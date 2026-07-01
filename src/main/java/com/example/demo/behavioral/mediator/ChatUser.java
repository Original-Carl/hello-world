package com.example.demo.behavioral.mediator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatUser {
    private final String name;
    private final ChatMediator mediator;
    private final List<String> inbox = new ArrayList<>();

    public ChatUser(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String name() { return name; }
    public List<String> inbox() { return Collections.unmodifiableList(inbox); }

    public void send(String message)    { throw new UnsupportedOperationException(); }
    public void receive(String message) { throw new UnsupportedOperationException(); }
}
