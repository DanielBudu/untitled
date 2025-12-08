package e2.binary;

import e2.Expression;

public abstract class Binary implements Expression {

    protected Expression left;
    protected Expression right;

    public Binary(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }


}
