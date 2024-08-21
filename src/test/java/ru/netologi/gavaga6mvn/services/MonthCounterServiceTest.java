package ru.netologi.gavaga6mvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class MonthCounterServiceTest {

   @Test
    public void testMonthCounterCase1() {
        MonthCounterService service = new MonthCounterService();
        int actual = service.calculate(10_000, 3_000, 20_000);
        int expected = 3;
       Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMonthCounterCase2() {
        MonthCounterService service = new MonthCounterService();
        int actual = service.calculate(100_000, 60_000, 150_000);
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvFileSource(files="src/test/resources/params.csv")
    public void testMonthCounterWithParams(int income, int expenses, int threshold, int expected) {
        MonthCounterService service = new MonthCounterService();
        int actual = service.calculate(income, expenses, threshold);
        Assertions.assertEquals(expected, actual);
    }
}