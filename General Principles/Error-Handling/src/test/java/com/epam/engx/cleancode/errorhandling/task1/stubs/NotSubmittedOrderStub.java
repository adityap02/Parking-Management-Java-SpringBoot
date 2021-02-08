package com.epam.engx.cleancode.errorhandling.task1.stubs;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Order;

public class NotSubmittedOrderStub implements Order {
    @Override
    public Double total() {
        return 99.99;
    }

    @Override
    public boolean isSubmitted() {
        return false;
    }
}
