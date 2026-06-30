package com.example.demo.behavioral.visitor;

public interface AstNode {
    <T> T accept(AstVisitor<T> visitor);
}
