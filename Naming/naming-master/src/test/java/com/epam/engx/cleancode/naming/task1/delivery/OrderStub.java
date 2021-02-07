package com.epam.engx.cleancode.naming.task1.delivery;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Product;

import java.util.Collections;
import java.util.List;

class OrderStub implements Order {

    private String name;

    public OrderStub(String name) {
        this.name = name;
    }

    @Override
    public List<Product> getProducts() {
        return Collections.<Product>singletonList(new Product() {
            @Override
            public String getName() {
                return name;
            }
        });
    }
}
