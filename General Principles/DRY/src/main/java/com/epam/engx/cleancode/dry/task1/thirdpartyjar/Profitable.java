package com.epam.engx.cleancode.dry.task1.thirdpartyjar;

import com.epam.engx.cleancode.dry.task1.AccountDetails;

import java.math.BigDecimal;

public interface Profitable {
    BigDecimal calculateInterest(AccountDetails accountDetails);
}
