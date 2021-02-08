package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.Account;
import com.epam.engx.cleancode.functions.task1.thirdpartyjar.Address;

import java.util.Date;
import java.util.List;

public class AccountDummy implements Account {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setCreatedDate(Date date) {

    }

    @Override
    public Address getAdditionalAddress() {
        return null;
    }

    @Override
    public Address getWorkAddress() {
        return null;
    }

    @Override
    public Address getHomeAddress() {
        return null;
    }

    @Override
    public void setAddresses(List<Address> addresses) {

    }
}
