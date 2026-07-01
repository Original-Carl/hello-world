package com.example.demo.behavioral.visitor;

public interface AstVisitor<T> {
    T visit(NumberNode n);
    T visit(AddNode n);
    T visit(MulNode n);
}
