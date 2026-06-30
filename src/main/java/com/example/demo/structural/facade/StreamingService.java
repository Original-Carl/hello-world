package com.example.demo.structural.facade;

public class StreamingService {
    public void connect()          { System.out.println("    [Stream] Connected to streaming service"); }
    public void play(String title) { System.out.println("    [Stream] Now playing: " + title); }
    public void disconnect()       { System.out.println("    [Stream] Disconnected"); }
}
