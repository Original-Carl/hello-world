package com.example.demo.structural.composite;

public class FileLeaf implements FileComponent {
    private final String name;
    private final long size;
    public FileLeaf(String name, long size) { this.name = name; this.size = size; }
    @Override public String name() { throw new UnsupportedOperationException(); }
    @Override public long size()   { throw new UnsupportedOperationException(); }
}
