package com.example.demo.behavioral.interpreter;

import java.util.Map;

public class Variable implements BooleanExpression {
    private final String name;
    public Variable(String name) { this.name = name; }

    @Override public boolean interpret(Map<String, Boolean> context) { throw new UnsupportedOperationException(); }
}
