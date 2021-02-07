package com.epam.engx.cleancode.naming.task3;

import org.junit.Assert;
import org.junit.Test;

import static com.epam.engx.cleancode.naming.task3.HarshadTestHelper.getHarshadNumbers;

public class HarshadTest {
    @Test
    public void shouldPrintAllHarshadNumbers() {
        Assert.assertEquals(
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "12\n" +
                "18\n" +
                "20\n" +
                "21\n" +
                "24\n" +
                "27\n" +
                "30\n" +
                "36\n" +
                "40\n" +
                "42\n" +
                "45\n" +
                "48\n" +
                "50\n" +
                "54\n" +
                "60\n" +
                "63\n" +
                "70\n" +
                "72\n" +
                "80\n" +
                "81\n" +
                "84\n" +
                "90\n" +
                "100\n" +
                "102\n" +
                "108\n" +
                "110\n" +
                "111\n" +
                "112\n" +
                "114\n" +
                "117\n" +
                "120\n" +
                "126\n" +
                "132\n" +
                "133\n" +
                "135\n" +
                "140\n" +
                "144\n" +
                "150\n" +
                "152\n" +
                "153\n" +
                "156\n" +
                "162\n" +
                "171\n" +
                "180\n" +
                "190\n" +
                "192\n" +
                "195\n" +
                "198\n" +
                "200\n",
                getHarshadNumbers());
    }

}
