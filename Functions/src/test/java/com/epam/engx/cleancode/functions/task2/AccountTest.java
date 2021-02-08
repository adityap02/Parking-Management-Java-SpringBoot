package com.epam.engx.cleancode.functions.task2;

import com.epam.engx.cleancode.functions.task2.stubs.AccountStub;
import com.epam.engx.cleancode.functions.task2.stubs.NotRegisteredAccountStub;
import com.epam.engx.cleancode.functions.task2.stubs.NotVisitingAccountStub;
import com.epam.engx.cleancode.functions.task2.stubs.ReviewStub;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Level;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.NotActivUserException;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Review;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class AccountTest {


    private TreeMap<Integer, Level> levelMap = new TreeMap<>(Collections.reverseOrder());

    @Before
    public void setUp() throws Exception {
        levelMap.put(10, new Level("1"));
        levelMap.put(30, new Level("2"));
    }

    @Test (expected = NotActivUserException.class)
    public void shouldThrowExceptionWhenAccountIsNotRegistered() {
        Account accountStub = new NotRegisteredAccountStub();
        accountStub.getActivityLevel();
    }

    @Test (expected = NotActivUserException.class)
    public void shouldThrowExceptionWhenAccountIsNotVisiting() {
        Account accountStub = new NotVisitingAccountStub();
        accountStub.getActivityLevel();
    }

    @Test
    public void shouldGetDefaultLevelWhenThereAreNoAnswers() {
        Account accountStub = new AccountStub(Arrays.<Review>asList(new ReviewStub(0)));
        assertEquals(Level.defaultLevel(), accountStub.getActivityLevel());
    }

    @Test
    public void shouldGetDefaultLevelWhenThereAreNotEnoughAnswers() {
        Account accountStub = new AccountStub(Arrays.<Review>asList(new ReviewStub(9)));
        assertEquals(Level.defaultLevel(), accountStub.getActivityLevel());
    }

    @Test
    public void shouldGetFirstLevelWhenThereAreEnoughAnswers() {
        Account accountStub = new AccountStub(Arrays.<Review>asList(new ReviewStub(10)));
        accountStub.setLevelMap(levelMap);
        assertEquals(new Level("1"), accountStub.getActivityLevel());
    }

    @Test
    public void shouldGetFirstLevelWhenThereAreEnoughSumOfAnswers() {
        Account accountStub = new AccountStub(Arrays.<Review>asList(new ReviewStub(5), new ReviewStub(5)));
        accountStub.setLevelMap(levelMap);
        assertEquals(new Level("1"), accountStub.getActivityLevel());
    }

    @Test
    public void shouldGetSecondLevelWhenThereAreEnoughAnswers() {
        Account accountStub = new AccountStub(Arrays.<Review>asList(new ReviewStub(30)));
        accountStub.setLevelMap(levelMap);
        assertEquals(new Level("2"), accountStub.getActivityLevel());
    }
}
