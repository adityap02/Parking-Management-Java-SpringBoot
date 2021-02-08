package com.epam.engx.cleancode.dry.task1;

import com.epam.engx.cleancode.dry.task1.thirdpartyjar.Account;
import org.junit.Test;

import java.util.Calendar;

import static com.epam.engx.cleancode.dry.task1.InterestCalculatorTestHelper.makeAccountDetails;
import static org.junit.Assert.assertEquals;

public class InterestCalculatorTest {

    @Test
    public void shouldCalculateZeroInterestIfAccountStartedBeforeBonusAge() {
        assertInterest(makeAccountDetails(100, 22, 20), 0);
        assertInterest(makeAccountDetails(100, 20, 7), 0);
        assertInterest(reduceStartDate(makeAccountDetails(100, 20, 6)), 0);
    }

    @Test
    public void shouldCalculateInterestFor1YearAccount() {
        assertInterest(makeAccountDetails(100, 20, 1), 4.5);
    }

    @Test
    public void shouldCalculateInterestForSeveralYearsAccount() {
        assertInterest(makeAccountDetails(100, 20, 6), 27);
        assertInterest(makeAccountDetails(100, 20, 5), 22.5);
    }

    @Test
    public void shouldCalculateInterestDependingOnBalance() {
        assertInterest(makeAccountDetails(200, 20, 5), 45);
    }

    @Test
    public void shouldCalculateNormalInterestFor59YearsOld() {
        assertInterest(makeAccountDetails(100, 59, 5), 22.5);
    }

    @Test
    public void shouldCalculateSeniorInterestFor60YearsOld() {
        assertInterest(makeAccountDetails(100, 60, 1), 5.5);
        assertInterest(makeAccountDetails(100, 61, 5), 27.5);
    }

    @Test
    public void shouldCalculateZeroInterestIfBalanceIsZero() {
        assertInterest(makeAccountDetails(0, 60, 5), 0);
    }

    private Account reduceStartDate(Account accountDetails) {
        Calendar c = Calendar.getInstance();
        c.setTime(accountDetails.getStartDate());
        c.add(Calendar.DATE, -3);
        accountDetails.setStartDate(c.getTime());
        return accountDetails;
    }

    private void assertInterest(Account accountDetails, double expected) {
        assertEquals(expected, new InterestCalculator().calculateInterest((AccountDetails) accountDetails).doubleValue(), 0.00000001);
    }


}
