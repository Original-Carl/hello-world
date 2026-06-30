package com.example.demo.structural.facade;

public class SoundSystem {
    public void on()              { System.out.println("    [Sound] Amplifier on, surround mode 7.1"); }
    public void setVolume(int v)  { System.out.println("    [Sound] Volume → " + v); }
    public void off()             { System.out.println("    [Sound] Amplifier off"); }
}
