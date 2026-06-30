package com.example.demo.behavioral.interpreter;

import java.util.Map;

public class AndExpression implements BooleanExpression {
    private final BooleanExpression left, right;
    public AndExpression(BooleanExpression left, BooleanExpression right) { this.left = left; this.right = right; }

    @Override public boolean interpret(Map<String, Boolean> context) { throw new UnsupportedOperationException(); }
}
