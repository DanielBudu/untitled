package e2.binary;

import e2.Expression;

public class Divide extends Binary{

    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    //División entre 0????
    @Override
    public double evaluate() {
        return left.evaluate() / right.evaluate();
    }

    @Override
    public String toPostfix() {
        return left.toPostfix() + " " + right.toPostfix() + " /";
    }
}
