package com.epam.engx.cleancode.functions.task1.thirdpartyjar;

import java.util.Date;
import java.util.List;

public interface Account {

    String getId();

    String getName();

    String getPassword();

    void setCreatedDate(Date date);

    Address getAdditionalAddress();

    Address getWorkAddress();

    Address getHomeAddress();

    void setAddresses(List<Address> addresses);
}
