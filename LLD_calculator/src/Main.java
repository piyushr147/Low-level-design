import ArithmeticExpression.Expression;
import ArithmeticExpression.Number;
import operator.Operator;

public class Main {
    public static void main(String[] args) {
        Number x = new Number(10);
        Number y = new Number(7);
        Number z = new Number(3);

        Expression expression = new Expression(y,z, Operator.MULTIPLY);
        Expression expression1 = new Expression(x,expression,Operator.ADD);

        System.out.println("result = "+expression1.calculateExpression());
    }
}