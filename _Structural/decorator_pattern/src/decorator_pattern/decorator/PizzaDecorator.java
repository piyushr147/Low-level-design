package decorator_pattern.decorator;

import decorator_pattern.BasePizza;

public abstract class PizzaDecorator implements BasePizza {
    protected BasePizza basePizza;

    public PizzaDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    public abstract int calculateCost();
}
