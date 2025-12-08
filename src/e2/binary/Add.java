package e2.binary;

import e2.Expression;

public class Add extends Binary{

    public Add(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public double evaluate()
    {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String toPostfix()
    {
        return left.toPostfix() + " " + right.toPostfix() + " +";
    }
}
