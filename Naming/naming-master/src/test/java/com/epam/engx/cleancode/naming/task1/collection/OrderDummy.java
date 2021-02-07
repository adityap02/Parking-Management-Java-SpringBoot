package com.epam.engx.cleancode.naming.task1.collection;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Product;

import java.util.List;

class OrderDummy implements Order {
    @Override
    public List<Product> getProducts() {
        return null;
    }
}
