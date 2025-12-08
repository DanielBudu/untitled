package e2.unary;

import e2.Expression;

public class Sqrt extends Unary {

    public Sqrt(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate()
    {
        return Math.sqrt(operand.evaluate());
    }

    @Override
    public String toPostfix()
    {
        return operand.toPostfix() + " SQRT";
    }
}
