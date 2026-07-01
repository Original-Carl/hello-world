package com.example.demo.behavioral.interpreter;

import java.util.Map;

public class Literal implements BooleanExpression {
    private final boolean value;
    public Literal(boolean value) { this.value = value; }

    @Override public boolean interpret(Map<String, Boolean> context) { throw new UnsupportedOperationException(); }
}
