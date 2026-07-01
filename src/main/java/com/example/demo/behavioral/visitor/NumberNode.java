package com.example.demo.behavioral.visitor;

public class NumberNode implements AstNode {
    public final int value;
    public NumberNode(int value) { this.value = value; }

    @Override public <T> T accept(AstVisitor<T> visitor) { throw new UnsupportedOperationException(); }
}
