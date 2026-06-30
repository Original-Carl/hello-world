package com.example.demo.behavioral.visitor;

public class PrintVisitor implements AstVisitor<String> {
    @Override public String visit(NumberNode n) { throw new UnsupportedOperationException(); }
    @Override public String visit(AddNode n)    { throw new UnsupportedOperationException(); }
    @Override public String visit(MulNode n)    { throw new UnsupportedOperationException(); }
}
