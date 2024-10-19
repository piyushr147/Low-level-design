package decorator_pattern.pizzaImpl;

import decorator_pattern.BasePizza;

public class TomatoPizza implements BasePizza {
    @Override
    public int calculateCost() {
        return 120;
    }
}
