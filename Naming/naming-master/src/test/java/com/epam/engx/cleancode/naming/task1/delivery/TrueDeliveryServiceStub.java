package com.epam.engx.cleancode.naming.task1.delivery;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.DeliveryService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;

public class TrueDeliveryServiceStub implements DeliveryService {

    @Override
    public boolean isDeliverable(Order o) {
        return true;
    }
}
