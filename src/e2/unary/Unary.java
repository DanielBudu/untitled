package e2.unary;

import e2.Expression;

public abstract class Unary implements Expression {

    protected Expression operand;

    public Unary(Expression operand) {
        this.operand = operand;
    }
}
