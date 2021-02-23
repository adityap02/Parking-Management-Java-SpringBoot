package com.epam.engx.cleancode.naming.task2;

public class UserTestHelper {

    public static User getAdminUser(User user) {
        user.isAdmin = true;
        return user;
    }
}
