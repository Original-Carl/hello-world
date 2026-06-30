package com.example.demo.behavioral.visitor;

public class AddNode implements AstNode {
    public final AstNode left, right;
    public AddNode(AstNode left, AstNode right) { this.left = left; this.right = right; }

    @Override public <T> T accept(AstVisitor<T> visitor) { throw new UnsupportedOperationException(); }
}
