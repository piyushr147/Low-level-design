package controller;

import product.Product;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ProductController {
    HashSet<Product> products;
    Product selectedProduct;

    private ProductController() {
        products = new HashSet<>();
    }

    public void reduceQuantity() {
        products
                .stream()
                .filter(p -> p==selectedProduct)
                .findFirst()
                .ifPresent(p -> { p.decreaseQuantity(1);});
    }

    private static class SingletonHolder{
        private static final ProductController INSTANCE = new ProductController();
    }

    public static ProductController getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public void displayProducts(){
        for(Product product : products){
            System.out.println(product.toString());
        }
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public boolean checkIfProductExist(Product product){
        return products
                .stream()
                .filter(p -> p.getName().equals(product.getName()))
                .findFirst()
                .map(p -> p.getQuantity() > 0).orElse(false);
    }
}
