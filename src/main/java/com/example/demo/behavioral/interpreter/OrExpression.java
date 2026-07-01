package com.example.demo.behavioral.interpreter;

import java.util.Map;

public class OrExpression implements BooleanExpression {
    private final BooleanExpression left, right;
    public OrExpression(BooleanExpression left, BooleanExpression right) { this.left = left; this.right = right; }

    @Override public boolean interpret(Map<String, Boolean> context) { throw new UnsupportedOperationException(); }
}
