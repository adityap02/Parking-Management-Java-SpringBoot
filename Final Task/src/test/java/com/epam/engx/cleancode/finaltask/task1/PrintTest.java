package com.epam.engx.cleancode.finaltask.task1;

import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import org.mockito.Mockito;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class PrintTest {
    private View view;
    private DatabaseManager manager;
    private Command command;
    private final DataSet dataSet = new DataSetImpl();

    @Before
    public void setup() {
        manager = Mockito.mock(DatabaseManager.class);
        view = Mockito.mock(View.class);
        command = new Print(view, manager);
    }

    @Test
    public void shouldPrintTableWithOneColumn() {
        //given
        dataSet.put("id", 1);
        prepareSingleResult();
        //when
        command.process("print test");
        //then
        assertPrinted("[" +
                "╔════╗\n" +
                "║ id ║\n" +
                "╠════╣\n" +
                "║ 1  ║\n" +
                "╚════╝\n" + "]");
    }

    @Test
    public void shouldPrintTableWithPaddingWhenOneShortColumn() {
        //given
        dataSet.put("i", 1);
        prepareSingleResult();
        //when
        command.process("print test");
        //then
        assertPrinted("[" +
                "╔════╗\n" +
                "║ i  ║\n" +
                "╠════╣\n" +
                "║ 1  ║\n" +
                "╚════╝\n" + "]");
    }

    @Test
    public void shouldPrintAllColumnLengthsWithTheLongestValue() {
        //given
        dataSet.put("i", 1);
        dataSet.put("j", 1234567890);
        prepareSingleResult();
        //when
        command.process("print test");
        //then
        assertPrinted("[" +
                "╔════════════╦════════════╗\n" +
                "║     i      ║     j      ║\n" +
                "╠════════════╬════════════╣\n" +
                "║     1      ║ 1234567890 ║\n" +
                "╚════════════╩════════════╝\n" + "]");
    }

    @Test
    public void shouldPrintMessageForNotExistingTable() {
        //given
        Mockito.when(manager.getTableData("testing")).thenReturn(new LinkedList<DataSet>());
        //when
        command.process("print testing");
        //then
        assertPrinted("[" +
                "╔════════════════════════════════════════════╗\n" +
                "║ Table 'testing' is empty or does not exist ║\n" +
                "╚════════════════════════════════════════════╝\n" + "]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTrowExceptionWhenCommandIsWrong() {
        command.process("print");
    }

    @Test
    public void shouldProcessValidCommand() {
        //when
        boolean canProcess = command.canProcess("print test");
        //then
        assertTrue(canProcess);
    }

    @Test
    public void shouldNotProcessInvalidCommand() {
        //when
        boolean canProcess = command.canProcess("qwe");
        //then
        assertFalse(canProcess);
    }

    @Test
    public void shouldPrintTableWithMultiDataSets() {
        //given
        createUserDataSets(createUser(1, "Steven Seagal", "123456"), createUser(2, "Eva Song", "789456"));
        //when
        command.process("print users");
        //then
        assertPrinted("[" +
                "╔════════════════╦════════════════╦════════════════╗\n" +
                "║       id       ║      name      ║    password    ║\n" +
                "╠════════════════╬════════════════╬════════════════╣\n" +
                "║       1        ║ Steven Seagal  ║     123456     ║\n" +
                "╠════════════════╬════════════════╬════════════════╣\n" +
                "║       2        ║    Eva Song    ║     789456     ║\n" +
                "╚════════════════╩════════════════╩════════════════╝\n" + "]");
    }

    private void createUserDataSets(DataSet... users) {
        List<DataSet> dataSets = new LinkedList<>();
        Collections.addAll(dataSets, users);
        Mockito.when(manager.getTableData("users")).thenReturn(dataSets);
    }

    private DataSet createUser(int id, String name, String password) {
        DataSet user = new DataSetImpl();
        user.put("id", id);
        user.put("name", name);
        user.put("password", password);
        return user;
    }

    private void prepareSingleResult() {
        List<DataSet> dataSets = new LinkedList<>();
        dataSets.add(dataSet);
        Mockito.when(manager.getTableData("test")).thenReturn(dataSets);
    }


    private void assertPrinted(String expected) {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(view, Mockito.atLeastOnce()).write(captor.capture());
        assertEquals(expected, captor.getAllValues().toString());
    }
}