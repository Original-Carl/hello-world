package com.example.demo.structural.facade;

public class HomeTheaterFacade {
    private final TV tv = new TV();
    private final SoundSystem sound = new SoundSystem();
    private final StreamingService streaming = new StreamingService();

    public void watchMovie(String title) {
        System.out.println("  Getting ready to watch \"" + title + "\"...");
        tv.on();
        sound.on();
        sound.setVolume(30);
        streaming.connect();
        streaming.play(title);
    }

    public void endMovie() {
        System.out.println("  Shutting down home theater...");
        streaming.disconnect();
        sound.off();
        tv.off();
    }
}
