package com.maniek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WarehouseDB {


    private List<Product> products;

    public WarehouseDB(List<Product> initialdb) {

        products = initialdb;
    }

    public WarehouseDB() {

        products = new ArrayList<>();
    }


    public List<Product> getProducts() {

        return products;
    }


    public Product getProduct(String code) {

        for(int i = 0; i <products.size(); i++) {
            Product testProduct = products.get(i);

            if(code.equals(testProduct.getCode()) ) {
                return testProduct;
            }
        }
        return null;
    }

    public void add(Product product) {
        products.add(product);
    }

    public void addQuantity(String code, int newQuantity) {

        for(int i = 0; i <products.size(); i++) {
            Product testProduct = products.get(i);

            if (code.equals(testProduct.getCode())) {
                int lokalna = testProduct.getQuantity();
                lokalna += newQuantity;
                testProduct.setQuantity(lokalna);
            }
        }
    }
}
