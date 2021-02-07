package com.epam.engx.cleancode.naming.task1.delivery;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.OrderFulfilmentService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Product;
import org.junit.Assert;

import java.util.List;

class OrderFulfilmentServiceMock implements OrderFulfilmentService {

    private String productName;

    @Override
    public void fulfilProducts(List<Product> products) {
        productName = products.get(0).getName();
    }

    public void assertFirstProductName(String s){
        Assert.assertEquals(s, productName);
    }
}
