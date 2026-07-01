package com.example.demo.behavioral.interpreter;

import java.util.Map;

public class NotExpression implements BooleanExpression {
    private final BooleanExpression operand;
    public NotExpression(BooleanExpression operand) { this.operand = operand; }

    @Override public boolean interpret(Map<String, Boolean> context) { throw new UnsupportedOperationException(); }
}
