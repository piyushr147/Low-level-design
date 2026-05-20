import decorator_pattern.coffee.ConcreteCoffee;
import decorator_pattern.decorator.IceDecorator;
import decorator_pattern.decorator.MilkDecorator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConcreteCoffee coffee = new ConcreteCoffee();

        IceDecorator iceDecorator = new IceDecorator(coffee);
        MilkDecorator milkDecorator = new MilkDecorator(iceDecorator);
        System.out.println(milkDecorator.getPrice());
    }
}