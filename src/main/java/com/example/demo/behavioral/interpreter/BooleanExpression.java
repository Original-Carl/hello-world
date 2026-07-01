package com.example.demo.behavioral.interpreter;

import java.util.Map;

public interface BooleanExpression {
    boolean interpret(Map<String, Boolean> context);
}
