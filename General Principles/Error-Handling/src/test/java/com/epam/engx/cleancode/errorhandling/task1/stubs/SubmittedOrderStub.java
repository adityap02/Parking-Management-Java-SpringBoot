package com.epam.engx.cleancode.errorhandling.task1.stubs;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Order;

public class SubmittedOrderStub implements Order {
    @Override
    public Double total() {
        return 285.15;
    }

    @Override
    public boolean isSubmitted() {
        return true;
    }
}
