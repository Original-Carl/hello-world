package com.example.demo.behavioral.mediator;

public class ChatRoom implements ChatMediator {
    @Override public void register(ChatUser user)               { throw new UnsupportedOperationException(); }
    @Override public void relay(String from, String message)    { throw new UnsupportedOperationException(); }
}
