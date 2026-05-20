package decorator_pattern.decorator;

import decorator_pattern.coffee.Coffee;

public class IceDecorator extends CoffeeDecorator {

    public IceDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 20;
    }
}
