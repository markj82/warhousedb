package com.maniek;

import java.util.ArrayList;
import java.util.List;

public class WarehouseDB {
    List<Product> productList;

    public Product addProduct(String name, int howMany) {
        productList = new ArrayList<>();
        Product product = new Product(name, howMany);

        return product;
    }






}
