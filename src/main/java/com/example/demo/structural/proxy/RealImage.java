package com.example.demo.structural.proxy;

public class RealImage implements ImageLoader {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        // expensive load happens here in real implementation
    }

    @Override public String display()  { return "Displaying " + filename; }
    @Override public int loadCount()   { return 1; }
}
