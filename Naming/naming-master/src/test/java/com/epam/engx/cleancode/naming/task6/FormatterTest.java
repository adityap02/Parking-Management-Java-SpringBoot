package com.epam.engx.cleancode.naming.task6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    @Test
    public void shouldFormatKeyValue() {
        assertEquals(
                "+-------------+\n" +
                "|enable _ true|\n" +
                "+-------------+\n",
                new Formatter().formatKeyValue("enable", "true"));
        assertEquals(
                "+----------+\n" +
                "|name _ Bob|\n" +
                "+----------+\n",
                new Formatter().formatKeyValue("name", "Bob"));
    }
}
