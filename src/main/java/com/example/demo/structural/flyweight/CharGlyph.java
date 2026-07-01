package com.example.demo.structural.flyweight;

public class CharGlyph {
    private final char symbol;
    private final String font;
    private final String color;

    CharGlyph(char symbol, String font, String color) {
        this.symbol = symbol;
        this.font = font;
        this.color = color;
    }

    public char symbol() { return symbol; }
    public String font()  { return font; }
    public String color() { return color; }

    public String render(int x, int y) { throw new UnsupportedOperationException(); }
}
