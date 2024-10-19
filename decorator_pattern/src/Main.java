import decorator_pattern.BasePizza;
import decorator_pattern.decorator.toppingsImpl.ExtraCheeseDecorator;
import decorator_pattern.decorator.toppingsImpl.ExtraSauceDecorator;
import decorator_pattern.pizzaImpl.OnionPizza;
import decorator_pattern.pizzaImpl.TomatoPizza;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TomatoPizza tomatoPizza = new TomatoPizza();
        OnionPizza onionPizza = new OnionPizza();

        ExtraSauceDecorator extraSauceTomatoPizza = new ExtraSauceDecorator(tomatoPizza);
        ExtraCheeseDecorator extraCheeseOnionPizza = new ExtraCheeseDecorator(onionPizza);

        ExtraSauceDecorator extraSauceAndCheeseTomatoPizza = new ExtraSauceDecorator(new ExtraCheeseDecorator(tomatoPizza));

        System.out.println("extra sauce tomato pizza cost: "+extraSauceTomatoPizza.calculateCost());
        System.out.println("extra cheese onion pizza cost: "+extraCheeseOnionPizza.calculateCost());
        System.out.println("extra sauce and cheese tomato pizza cost: "+extraSauceAndCheeseTomatoPizza.calculateCost());
    }
}