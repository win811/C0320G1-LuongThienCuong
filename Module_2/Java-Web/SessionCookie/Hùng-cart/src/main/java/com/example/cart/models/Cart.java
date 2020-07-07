package com.example.cart.models;

import java.util.*;

public class Cart {
    private int id;
    private Product product;
    private int numberOfProduct;
    private Map<Product,Integer> carList = new HashMap<>();
    public Cart() {
    }

    public Cart(int id, Product product, int numberOfProduct) {
        this.id = id;
        this.product = product;
        this.numberOfProduct = numberOfProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public Map<Product, Integer> getCarList() {
        return carList;
    }

    public void setCarList(Map<Product, Integer> carList) {
        this.carList = carList;
    }
    public void addProductToCart(Product product,Integer number){
        Set<Product> products = carList.keySet();
        for(Product p:products){
            if(p.equals(product)){
                number+=carList.get(p);
                break;
            }
        }
        carList.put(product,number);
    }
    public Double getTotalPayment(){
        double payment = 0.0;
        Set<Product> key = carList.keySet();
        for(Product product:key){
            payment+=product.getPrice()*carList.get(product);
        }
        return payment;
    }
    public void removeProductFromCart(Product product){
        Set<Product> products = carList.keySet();
        for(Product p:products){
            if (p.equals(product)){
                carList.remove(p);
                break;
            }
        }
    }
    public List<Integer> getQuantityList(){
        List<Integer> quantities = new ArrayList<>();
        Set<Product> products = carList.keySet();
        for(Product p:products){
            quantities.add(carList.get(p));
        }
        return quantities;
    }
}
