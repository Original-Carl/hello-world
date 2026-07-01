package com.example.demo.behavioral.visitor;

public class EvalVisitor implements AstVisitor<Integer> {
    @Override public Integer visit(NumberNode n) { throw new UnsupportedOperationException(); }
    @Override public Integer visit(AddNode n)    { throw new UnsupportedOperationException(); }
    @Override public Integer visit(MulNode n)    { throw new UnsupportedOperationException(); }
}
