package com.epam.engx.cleancode.naming.task1;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Submitable;

public interface IOrderService  extends Submitable {
    void submitOrder(Order pOrder);
}
