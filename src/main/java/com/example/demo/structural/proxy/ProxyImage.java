package com.example.demo.structural.proxy;

public class ProxyImage implements ImageLoader {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) { this.filename = filename; }

    @Override public String display()  { throw new UnsupportedOperationException(); }
    @Override public int loadCount()   { return realImage == null ? 0 : realImage.loadCount(); }
}
