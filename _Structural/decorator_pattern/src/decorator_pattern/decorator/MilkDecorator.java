package decorator_pattern.decorator;

import decorator_pattern.coffee.Coffee;

public class MilkDecorator extends CoffeeDecorator{

    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 60;
    }
}
