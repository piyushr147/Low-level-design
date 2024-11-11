package state;

import controller.CurrencyController;
import controller.ProductController;
import currency.Currency;
import product.Product;
import vandingMachine.VendingMachine;

import java.util.List;

public class SelectProductState implements State{

    int balanceLeft;
    private CurrencyController currencyController = CurrencyController.getInstance();
    private ProductController productController = ProductController.getInstance();

    public SelectProductState(){
        System.out.println("Currently the machine is in product selection state");
    }

    @Override
    public void clickFundsButton() throws Exception {
        System.out.println("Can't add funds, please cancel your process first, money will be refunded back");
    }

    @Override
    public void clickProductButton() throws Exception {
        System.out.println("Product selection already in process");
    }

    @Override
    public void addFunds(Currency currency) throws Exception {
        throw new Exception("can't add funds, please cancel this process first");
    }

    @Override
    public void cancelFunds() throws Exception {
        throw new Exception("Invalid operation of cancelling funds");
    }

    @Override
    public void selectProduct(int productID) throws Exception {
        System.out.println("Selecting your product");
        List<Product> productList = ProductController.getInstance().getProductList();

        for(Product product:productList){
            if(product.getId() == productID){
                System.out.println("selected product");
                System.out.println(product.toString());
                if(product.getStock()==0){
                    System.out.println("this product is out of stock, kindly add some other one or cancel your transaction");
                    VendingMachine.getInstance().changeState(new AddFundState());
                }
                else{
                    int total = CurrencyController.getInstance().getTotalValue();
                    balanceLeft = total - product.getPrice();
                    if(balanceLeft<0){
                        System.out.println("you don't have enough amount to buy it, kindly add more funds");
                        VendingMachine.getInstance().changeState(new AddFundState());
                    }
                    else{
                        System.out.println("product is available and affordable");
                        getChange();
                        ProductController.getInstance().removeProductFromStock(productID);
                        VendingMachine.getInstance().changeState(new DispatchState());
                    }
                }
            }
        }
    }

    @Override
    public void cancelProduct(int productID) throws Exception {
        System.out.println("cancelling product selection, refunding money back");
        CurrencyController.getInstance().getCurrencyList().clear();
        ProductController.getInstance().addProductInStock(productID);
        VendingMachine.getInstance().changeState(new IdealState());
    }

    @Override
    public void dispenseProduct(int productID) throws Exception {
        throw new Exception("can't dispense the product before selection process");
    }

    @Override
    public int getChange() throws Exception {
        System.out.println("Returned money is: "+balanceLeft);
        return balanceLeft;
    }
}
