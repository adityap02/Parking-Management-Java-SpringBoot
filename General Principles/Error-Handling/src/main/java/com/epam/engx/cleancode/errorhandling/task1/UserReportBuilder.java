package com.epam.engx.cleancode.errorhandling.task1;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Order;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.User;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.UserDao;

import java.util.List;

public class UserReportBuilder {

    private UserDao userDao;

    public Double getUserTotalOrderAmount(String userId) {

        if (userDao == null)
            return null;

        User user = userDao.getUser(userId);
        if (user == null)
            return -1.0;

        List<Order> orders = user.getAllOrders();

        if (orders.isEmpty())
            return -2.0;

        Double sum = 0.0;
        for (Order order : orders) {

            if (order.isSubmitted()) {
                Double total = order.total();
                if (total < 0)
                    return -3.0;
                sum += total;
            }
        }

        return sum;
    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
