package ArithmeticExpression;

public class Number implements ArithmeticExpression {
    private int number;

    public Number(int number){
        this.number = number;
    }

    @Override
    public int calculateExpression() throws ArithmeticException{
        return this.number;
    }
}
