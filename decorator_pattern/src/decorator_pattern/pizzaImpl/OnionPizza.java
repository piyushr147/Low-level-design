package decorator_pattern.pizzaImpl;

import decorator_pattern.BasePizza;

public class OnionPizza implements BasePizza {
    @Override
    public int calculateCost() {
        return 100;
    }
}
