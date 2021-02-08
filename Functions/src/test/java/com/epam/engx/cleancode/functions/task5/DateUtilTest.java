package com.epam.engx.cleancode.functions.task5;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.epam.engx.cleancode.functions.task5.DateUtilTestHelper.*;
import static org.junit.Assert.assertEquals;

public class DateUtilTest {

    private static final int MONTH_SHIFT = -1;

    private DateUtil dateUtil = new DateUtil();

    private final Date date = create(2014, 10, 10);

    @Test
    public void shouldIncrementDate() {
        assertEquals("10/11/2014 00:00:00", format(getDirectlyIncrementedDate(dateUtil, date)));
    }

    @Test
    public void shouldDecrementDate() {
        assertEquals("10/09/2014 00:00:00", format(getInverseIncrementedDate(dateUtil, date)));
    }

    private String format(Date date) {
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(date);
    }


    public Date create(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month + MONTH_SHIFT);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
}
