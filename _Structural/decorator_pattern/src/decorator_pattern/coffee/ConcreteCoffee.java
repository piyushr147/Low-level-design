package decorator_pattern.coffee;

import decorator_pattern.coffee.Coffee;

public class ConcreteCoffee implements Coffee {
    @Override
    public int getPrice() {
        return 100;
    }
}
