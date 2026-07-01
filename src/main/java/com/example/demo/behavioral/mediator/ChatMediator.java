package com.example.demo.behavioral.mediator;

public interface ChatMediator {
    void register(ChatUser user);
    void relay(String from, String message);
}
