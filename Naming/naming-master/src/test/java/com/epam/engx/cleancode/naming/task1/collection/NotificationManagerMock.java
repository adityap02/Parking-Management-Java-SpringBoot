package com.epam.engx.cleancode.naming.task1.collection;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotificationManager;

class NotificationManagerMock implements NotificationManager {

    Message message;
    int level;

    @Override
    public void notifyCustomer(Message message, int level) {
        this.message = message;
        this.level = level;
    }
}
