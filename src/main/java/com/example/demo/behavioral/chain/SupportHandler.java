package com.example.demo.behavioral.chain;

public abstract class SupportHandler {
    protected SupportHandler next;

    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    public abstract String handle(SupportTicket ticket);
}
