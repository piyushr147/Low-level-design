package state;

import currency.Currency;
import product.Product;
import vandingMachine.VendingMachine;

public class DispatchState implements State{


    public DispatchState(){
        System.out.println("Currently the machine is in product dispatch state");
    }
    @Override
    public void clickFundsButton() throws Exception {
        System.out.println("Can't add funds in dispense state");
    }

    @Override
    public void clickProductButton() throws Exception {
        System.out.println("can't select product in dispense state");
    }

    @Override
    public void addFunds(Currency currency) throws Exception {
        throw new Exception("can't reach funding state");
    }

    @Override
    public void cancelFunds() throws Exception {
        throw new Exception("can't reach fund cancelling state");
    }

    @Override
    public void selectProduct(int productID) throws Exception {
        throw new Exception("can't reach selection state");
    }

    @Override
    public void cancelProduct(int productID) throws Exception {
        throw new Exception("can't reach product cancellation state");
    }

    @Override
    public void dispenseProduct(int productID) throws Exception {
        for(Product product:VendingMachine.getInstance().getProductController().getProductList()){
            if(product.getId() == productID){
                System.out.println("Product has dispatched now");
                VendingMachine.getInstance().changeState(new IdealState());
            }
        }
    }

    @Override
    public int getChange() throws Exception {
        return 0;
    }
}
