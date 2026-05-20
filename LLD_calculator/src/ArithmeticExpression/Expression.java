package ArithmeticExpression;

import operator.Operator;

public class Expression implements ArithmeticExpression {

    private ArithmeticExpression leftExpression;
    private ArithmeticExpression rightExpression;
    private Operator operator;

    public Expression(ArithmeticExpression leftExpression,ArithmeticExpression rightExpression, Operator operator){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int calculateExpression() throws ArithmeticException{
        int left = leftExpression.calculateExpression();
        int right = rightExpression.calculateExpression();

        if(operator == Operator.ADD){
            return left+right;
        }
        else if(operator == Operator.SUBTRACT){
            return left-right;
        }
        else if(operator == Operator.MULTIPLY){
            return left*right;
        }
        else if(operator == Operator.DIVIDE){
            return left/right;
        }
        return 0;
    }
}
