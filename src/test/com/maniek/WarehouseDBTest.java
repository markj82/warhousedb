package com.maniek;

import com.sun.tools.javac.util.List;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarehouseDBTest {

    @Test
    public void getEmptyList() throws Exception {
        WarehouseDB db = new WarehouseDB();
       assertTrue(db.getProducts().size() == 0);
    }


    @Test
    public void initializeDbWithList() throws Exception {
        List<Product> initialdb = List.of(new Product("apple", "Apple", 5, 2.0),
                new Product("carrot", "Carrot", 10, 1.0));


        WarehouseDB db = new WarehouseDB(initialdb);
        assertTrue(db.getProducts().size() == 2);
    }

    @Test
    public void getProductByCode() throws Exception {
        WarehouseDB db = new WarehouseDB(List.of(new Product("apple", "Apple", 5, 2.0),
                new Product("carrot", "Carrot", 10, 1.0)));


        Product apples = db.getProduct("apple");

        assertNotNull(apples);

        assertTrue(apples.getQuantity() == 5);
        assertTrue(apples.getPrice() == 2.0);

        assertNotNull(db.getProduct(new String("apple")));
    }

    @Test
    public void getProductByCodeNotExist() throws Exception {
        WarehouseDB db = new WarehouseDB(List.of(new Product("apple", "Apple", 5, 2.0)));

        assertNotNull(db.getProduct("apple"));
        assertNull(db.getProduct("strawbery"));
    }

    @Test
    public void addNewProduct() throws Exception {
        WarehouseDB db = new WarehouseDB();

        Product apples = new Product("apple", "Apple", 5, 2.0);
        db.add(apples);

        assertTrue(db.getProducts().size() == 1);
        assertTrue(db.getProducts().get(0).getCode().equals("apple"));
    }

    @Test
    public void addQuantity() throws Exception {
        WarehouseDB db = new WarehouseDB();

        db.add(new Product("apple", "Apple", 5, 2.0));
        db.addQuantity("apple", 10);

        assertTrue(db.getProducts().size() == 1);
        assertTrue(db.getProduct("apple").getQuantity() == 15);
    }




}