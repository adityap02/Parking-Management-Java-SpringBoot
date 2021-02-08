package com.epam.engx.cleancode.errorhandling.task1.stubs;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Order;

public class AnotherSubmittedOrderStub implements Order {
    @Override
    public Double total() {
        return 78.00;
    }

    @Override
    public boolean isSubmitted() {
        return true;
    }
}
