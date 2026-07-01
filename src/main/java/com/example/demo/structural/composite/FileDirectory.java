package com.example.demo.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class FileDirectory implements FileComponent {
    private final String name;
    private final List<FileComponent> children = new ArrayList<>();

    public FileDirectory(String name) { this.name = name; }
    public void add(FileComponent c) { children.add(c); }
    public List<FileComponent> children() { return children; }

    @Override public String name() { throw new UnsupportedOperationException(); }
    @Override public long size()   { throw new UnsupportedOperationException(); }
}
