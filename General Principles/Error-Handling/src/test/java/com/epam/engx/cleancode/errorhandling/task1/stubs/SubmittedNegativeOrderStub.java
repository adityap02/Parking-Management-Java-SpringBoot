package com.epam.engx.cleancode.errorhandling.task1.stubs;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Order;

public class SubmittedNegativeOrderStub implements Order {
    @Override
    public Double total() {
        return -1.0;
    }

    @Override
    public boolean isSubmitted() {
        return true;
    }
}
