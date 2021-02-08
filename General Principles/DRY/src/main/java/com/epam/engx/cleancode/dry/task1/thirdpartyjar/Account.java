package com.epam.engx.cleancode.dry.task1.thirdpartyjar;

import java.math.BigDecimal;
import java.util.Date;

public interface Account {
    Date getBirth();

    Date getStartDate();

    BigDecimal getBalance();

    void setStartDate(Date time);
}
