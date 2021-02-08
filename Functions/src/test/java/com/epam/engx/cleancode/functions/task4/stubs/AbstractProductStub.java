package com.epam.engx.cleancode.functions.task4.stubs;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

public abstract class AbstractProductStub implements Product {
    @Override
    public double getProductPrice() {
        return 10;
    }

}
