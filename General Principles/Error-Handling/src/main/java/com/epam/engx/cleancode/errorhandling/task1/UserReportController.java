package com.epam.engx.cleancode.errorhandling.task1;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Model;

public class UserReportController {

    private UserReportBuilder userReportBuilder;

    public String getUserTotalOrderAmountView(String userId, Model model){
        String totalMessage = getUserTotalMessage(userId);
        if (totalMessage == null)
            return "technicalError";
        model.addAttribute("userTotalMessage", totalMessage);
        return "userTotal";
    }

    private String getUserTotalMessage(String userId) {

        Double amount = userReportBuilder.getUserTotalOrderAmount(userId);

        if (amount == null)
            return null;

        if (amount == -1)
            return "WARNING: User ID doesn't exist.";
        if (amount == -2)
            return "WARNING: User have no submitted orders.";
        if (amount == -3)
            return "ERROR: Wrong order amount.";

        return "User Total: " + amount + "$";
    }


    public UserReportBuilder getUserReportBuilder() {
        return userReportBuilder;
    }

    public void setUserReportBuilder(UserReportBuilder userReportBuilder) {
        this.userReportBuilder = userReportBuilder;
    }
}
