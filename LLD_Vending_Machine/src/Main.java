import controller.ProductController;
import enums.Coin;
import machine.VendingMachine;
import product.Product;
import states.State;
import states.concreteStateImpl.IdleState;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        VendingMachine vm = new VendingMachine();
        State state = vm.getCurrentState();

        ProductController productController = ProductController.getInstance();
        productController.addProduct(new Product("pepsi",2,20));
        productController.addProduct(new Product("lays",1,10));
        productController.addProduct(new Product("biscuit",9,30));

        state.displayItems(vm);

        State nextState = vm.getCurrentState();
        nextState.selectItems(vm,new Product("pepsi",2,20));

        nextState = vm.getCurrentState();
        nextState.enterCoins(vm, Coin.FIFTY);

        nextState = vm.getCurrentState();
        nextState.dispenseProduct(vm);
    }
}