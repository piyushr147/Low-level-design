package controller;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private List<Product> productList;
    private static ProductController productController;

    private ProductController(){
        productList = new ArrayList<Product>();
    }

    public static ProductController getInstance(){
        if(productController == null)
            productController = new ProductController();
        return productController;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProductInStock(int productID){
        for(Product product:productList){
            if(productID == product.getId())
                product.setStock(product.getStock()+1);
        }
    }

    public void removeProductFromStock(int productID){
        for(Product product:productList){
            if(productID == product.getId() && product.getStock()>0)
                product.setStock(product.getStock()-1);
        }
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void showAllAvailableProducts(){
        for(Product product:productList){
            if(product.getStock()>0)
                System.out.println(product.toString());
        }
    }
}
