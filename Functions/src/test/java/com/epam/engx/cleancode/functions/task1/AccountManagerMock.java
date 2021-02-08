package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.Account;
import com.epam.engx.cleancode.functions.task1.thirdpartyjar.AccountManager;

import static org.junit.Assert.assertEquals;

class AccountManagerMock implements AccountManager {

    private Account account;

    @Override
    public void createNewAccount(Account account) {
        this.account = account;
    }

    public void assertAccountRegistered(Account account){
        assertEquals(this.account.getId(), account.getId());
    }

}
