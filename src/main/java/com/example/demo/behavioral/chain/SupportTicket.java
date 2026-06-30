package com.example.demo.behavioral.chain;

public class SupportTicket {
    private final int severity;
    private final String description;

    public SupportTicket(int severity, String description) {
        this.severity = severity;
        this.description = description;
    }

    public int severity()       { return severity; }
    public String description() { return description; }
}
