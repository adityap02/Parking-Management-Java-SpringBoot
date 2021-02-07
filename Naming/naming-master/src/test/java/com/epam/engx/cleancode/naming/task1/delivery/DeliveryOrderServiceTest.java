package com.epam.engx.cleancode.naming.task1.delivery;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotDeliverableOrderException;
import org.junit.Test;

public class DeliveryOrderServiceTest {

    private DeliveryOrderService deliveryOrderService = new DeliveryOrderService();

    @Test
    public void shouldDeliverProducts() {
        OrderFulfilmentServiceMock fulfilmentServiceMock = new OrderFulfilmentServiceMock();
        deliveryOrderService.setOrderFulfilmentService(fulfilmentServiceMock);
        deliveryOrderService.setDeliveryService(new TrueDeliveryServiceStub());
        deliveryOrderService.submitOrder(new OrderStub("product-1"));
        fulfilmentServiceMock.assertFirstProductName("product-1");
    }

    @Test (expected = NotDeliverableOrderException.class)
    public void shouldNotDeliverProducts() {
        deliveryOrderService.setDeliveryService(new FalseDeliveryServiceStub());
        deliveryOrderService.submitOrder(new OrderStub("product-1"));
    }

}
