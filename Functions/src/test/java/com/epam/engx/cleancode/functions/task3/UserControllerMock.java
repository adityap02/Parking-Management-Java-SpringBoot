package com.epam.engx.cleancode.functions.task3;

import org.junit.Assert;

class UserControllerMock extends UserController {

    private boolean successLoginResponse = false;
    private boolean failLoginResponse = false;

    @Override
    public void generateSuccessLoginResponse(String user) {
        successLoginResponse = true;
    }

    @Override
    public void generateFailLoginResponse() {
        failLoginResponse = true;
    }

    public void assertGenerateSuccessLoginResponseCalled(){
        Assert.assertTrue(successLoginResponse);
    }

    public void assertGenerateFailLoginResponseCalled(){
        Assert.assertTrue(failLoginResponse);
    }
}
