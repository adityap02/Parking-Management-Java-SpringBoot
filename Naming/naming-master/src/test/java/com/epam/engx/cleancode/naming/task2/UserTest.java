package com.epam.engx.cleancode.naming.task2;

import org.junit.Test;

import static com.epam.engx.cleancode.naming.task2.UserTestHelper.getAdminUser;
import static org.junit.Assert.assertEquals;

public class UserTest {

    private final User bob = new User("Bob", "14.02.1974", new User[0]);

    @Test
    public void shouldPrintUser() {
        assertEquals("User [dateOfBirth=14.02.1974, name=Bob, isAdmin=false, subordinates=[], rating=0]", bob.toString());
    }

    @Test
    public void shouldPrintUserWithSubordinates() {
        assertEquals("User [dateOfBirth=19.08.1968, name=Alex, isAdmin=false, subordinates=" +
                "[User [dateOfBirth=14.02.1974, name=Bob, isAdmin=false, subordinates=[], rating=0], " +
                "User [dateOfBirth=22.05.1981, name=Tom, isAdmin=false, subordinates=" +
                "[User [dateOfBirth=08.06.1983, name=Peter, isAdmin=false, subordinates=[], rating=0]], rating=0]], rating=0]",
                new User("Alex", "19.08.1968", new User[]{bob, new User("Tom", "22.05.1981",
                        new User[]{new User("Peter", "08.06.1983", new User[0])})}).toString());
    }

    @Test
    public void shouldPrintAdminUserWithRating() {
        bob.setRating(33);
        assertEquals("User [dateOfBirth=14.02.1974, name=Bob, isAdmin=true, subordinates=[], rating=33]", getAdminUser(bob).toString());
    }


}
