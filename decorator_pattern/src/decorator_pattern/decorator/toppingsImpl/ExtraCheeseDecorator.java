package decorator_pattern.decorator.toppingsImpl;

import decorator_pattern.BasePizza;
import decorator_pattern.decorator.PizzaDecorator;

public class ExtraCheeseDecorator extends PizzaDecorator {

    public ExtraCheeseDecorator(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int calculateCost() {
        return 10 + super.basePizza.calculateCost();
    }
}
