package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus;
import com.epam.engx.cleancode.functions.task1.thirdpartyjar.PasswordChecker;

class NotOkPasswordChecker implements PasswordChecker {
    @Override
    public CheckStatus validate(String password) {
        return CheckStatus.WRONG;
    }
}
