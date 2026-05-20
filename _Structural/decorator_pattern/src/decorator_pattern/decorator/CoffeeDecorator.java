package decorator_pattern.decorator;

import decorator_pattern.coffee.Coffee;
import decorator_pattern.coffee.ConcreteCoffee;

public abstract class CoffeeDecorator extends ConcreteCoffee {

    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getPrice() {
        return coffee.getPrice();
    }
}
