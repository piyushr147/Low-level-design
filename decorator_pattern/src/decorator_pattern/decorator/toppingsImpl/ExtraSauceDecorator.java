package decorator_pattern.decorator.toppingsImpl;

import decorator_pattern.BasePizza;
import decorator_pattern.decorator.PizzaDecorator;

public class ExtraSauceDecorator extends PizzaDecorator {
    public ExtraSauceDecorator(BasePizza basePizza){
        super(basePizza);
    }

    public int calculateCost(){
        return 20 + super.basePizza.calculateCost();
    }

}
