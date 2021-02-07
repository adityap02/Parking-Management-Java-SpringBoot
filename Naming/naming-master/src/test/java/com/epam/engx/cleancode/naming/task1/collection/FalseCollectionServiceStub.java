package com.epam.engx.cleancode.naming.task1.collection;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;

public class FalseCollectionServiceStub implements CollectionService {
    @Override
    public boolean isEligibleForCollection(Order order) {
        return false;
    }
}
