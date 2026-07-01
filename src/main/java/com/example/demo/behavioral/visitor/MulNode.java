package com.example.demo.behavioral.visitor;

public class MulNode implements AstNode {
    public final AstNode left, right;
    public MulNode(AstNode left, AstNode right) { this.left = left; this.right = right; }

    @Override public <T> T accept(AstVisitor<T> visitor) { throw new UnsupportedOperationException(); }
}
