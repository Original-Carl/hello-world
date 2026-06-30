package com.example.demo.behavioral.visitor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AstVisitorTest {

    // Tree: (2 + 3) * 4
    private AstNode tree() {
        return new MulNode(new AddNode(new NumberNode(2), new NumberNode(3)), new NumberNode(4));
    }

    @Test
    void eval_numberNode_returnsValue() {
        assertThat(new NumberNode(7).accept(new EvalVisitor())).isEqualTo(7);
    }

    @Test
    void eval_addNode_returnsSum() {
        AstNode add = new AddNode(new NumberNode(3), new NumberNode(4));
        assertThat(add.accept(new EvalVisitor())).isEqualTo(7);
    }

    @Test
    void eval_mulNode_returnsProduct() {
        AstNode mul = new MulNode(new NumberNode(3), new NumberNode(4));
        assertThat(mul.accept(new EvalVisitor())).isEqualTo(12);
    }

    @Test
    void eval_compositeExpression() {
        assertThat(tree().accept(new EvalVisitor())).isEqualTo(20);
    }

    @Test
    void print_numberNode_returnsString() {
        String result = new NumberNode(5).accept(new PrintVisitor());
        assertThat(result).contains("5");
    }

    @Test
    void print_addNode_showsOperator() {
        AstNode add = new AddNode(new NumberNode(1), new NumberNode(2));
        String result = add.accept(new PrintVisitor());
        assertThat(result).contains("+");
    }

    @Test
    void print_compositeExpression_isReadable() {
        String result = tree().accept(new PrintVisitor());
        assertThat(result).contains("2").contains("3").contains("4");
    }

    @Test
    void doubleDispatch_newVisitorWithoutChangingNodes() {
        AstVisitor<Integer> sumOnly = new AstVisitor<>() {
            @Override public Integer visit(NumberNode n) { return 0; }
            @Override public Integer visit(AddNode n)    { return n.left.accept(this) + n.right.accept(this); }
            @Override public Integer visit(MulNode n)    { return n.left.accept(this) + n.right.accept(this); }
        };
        AstNode expr = new AddNode(new NumberNode(1), new NumberNode(2));
        assertThat(expr.accept(sumOnly)).isEqualTo(3);
    }
}
