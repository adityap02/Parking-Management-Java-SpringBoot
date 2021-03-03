/*
 * package com.epam.parking.services;
 * 
 * import static org.junit.jupiter.api.Assertions.assertDoesNotThrow; import
 * static org.mockito.Mockito.mock; import static org.mockito.Mockito.times;
 * import static org.mockito.Mockito.verify;
 * 
 * import org.junit.jupiter.api.BeforeAll; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.junit.jupiter.MockitoExtension;
 * 
 * import com.epam.parking.database.DatabaseModule;
 * 
 * @ExtendWith(MockitoExtension.class) class PrintAllSlotsTest { PrintAllSlots
 * printAllSlots = mock(PrintAllSlots.class);
 * 
 * static DatabaseModule database;
 * 
 * 
 * @BeforeAll public static void init() { database = new DatabaseModule();
 * 
 * }
 * 
 * @Test void test() {
 * 
 * assertDoesNotThrow(() -> { printAllSlots.execute(); });
 * //printAllSlots.execute(); verify(printAllSlots, times(1)).execute(); } }
 */