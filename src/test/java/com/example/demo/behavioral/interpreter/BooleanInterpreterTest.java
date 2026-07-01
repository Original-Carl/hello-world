package com.example.demo.behavioral.interpreter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BooleanInterpreterTest {

    @Test
    void literal_true_interpretsTrue() {
        assertThat(new Literal(true).interpret(Map.of())).isTrue();
    }

    @Test
    void literal_false_interpretsFalse() {
        assertThat(new Literal(false).interpret(Map.of())).isFalse();
    }

    @Test
    void variable_lookupsValueFromContext() {
        assertThat(new Variable("x").interpret(Map.of("x", true))).isTrue();
        assertThat(new Variable("x").interpret(Map.of("x", false))).isFalse();
    }

    @Test
    void variable_missingFromContext_throwsException() {
        assertThatThrownBy(() -> new Variable("z").interpret(Map.of()))
                .isInstanceOf(Exception.class);
    }

    @Test
    void and_trueAndTrue_isTrue() {
        BooleanExpression expr = new AndExpression(new Literal(true), new Literal(true));
        assertThat(expr.interpret(Map.of())).isTrue();
    }

    @Test
    void and_trueAndFalse_isFalse() {
        BooleanExpression expr = new AndExpression(new Literal(true), new Literal(false));
        assertThat(expr.interpret(Map.of())).isFalse();
    }

    @Test
    void or_falseOrTrue_isTrue() {
        BooleanExpression expr = new OrExpression(new Literal(false), new Literal(true));
        assertThat(expr.interpret(Map.of())).isTrue();
    }

    @Test
    void or_falseOrFalse_isFalse() {
        BooleanExpression expr = new OrExpression(new Literal(false), new Literal(false));
        assertThat(expr.interpret(Map.of())).isFalse();
    }

    @Test
    void not_true_isFalse() {
        assertThat(new NotExpression(new Literal(true)).interpret(Map.of())).isFalse();
    }

    @Test
    void not_false_isTrue() {
        assertThat(new NotExpression(new Literal(false)).interpret(Map.of())).isTrue();
    }

    @Test
    void composite_AndOrNot() {
        // And(Or(Var("x"), Lit(true)), Not(Var("y"))) with {x=false, y=false} -> true
        BooleanExpression expr = new AndExpression(
                new OrExpression(new Variable("x"), new Literal(true)),
                new NotExpression(new Variable("y"))
        );
        assertThat(expr.interpret(Map.of("x", false, "y", false))).isTrue();
    }
}
