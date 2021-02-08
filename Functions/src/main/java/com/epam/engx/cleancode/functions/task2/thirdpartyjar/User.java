package com.epam.engx.cleancode.functions.task2.thirdpartyjar;

import java.util.List;

public interface User {
    boolean isRegistered();
    int getVisitNumber();
    List<Review> getAllReviews();
}
