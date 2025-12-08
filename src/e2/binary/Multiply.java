package e2.binary;

import e2.Expression;

public class Multiply extends Binary {

    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(){
        return left.evaluate() * right.evaluate();
    }

    public String toPostfix(){
        return left.toPostfix() + " " + right.toPostfix() + " *";
    }

}
