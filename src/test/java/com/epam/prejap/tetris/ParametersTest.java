package com.epam.prejap.tetris;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParametersTest {

    @Test(dataProvider = "cliParams")
    public void shouldSetParameters(String[] cliArgs, int expectedRows, int expectedCols, int expectedDelay) {

        // act
        Parameters parameters = new Parameters(cliArgs);

        // assert
        assertEquals(parameters.getRows(), expectedRows, "Wrong number of rows!");
        assertEquals(parameters.getCols(), expectedCols, "Wrong number of columns!");
        assertEquals(parameters.getDelay(), expectedDelay, "Wrong delay period!");
    }

    @DataProvider
    public static Object[][] cliParams() {
        return new Object[][]{
                {new String[]{"10", "10", "200"}, 10, 10, 200},
                {new String[]{"9", "9", "199"}, 10, 10, 200},
                {new String[]{"11", "11", "201"}, 11, 11, 201},
                {new String[]{"99", "99", "1999"}, 99, 99, 1999},
                {new String[]{"100", "100", "2000"}, 100, 100, 2000},
                {new String[]{"101", "101", "2001"}, 100, 100, 2000},
                {new String[]{"lorem ipsum", "lorem ipsum", "lorem ipsum"}, 20, 30, 500},
                {new String[]{}, 20, 30, 500},
                {new String[]{"10"}, 10, 30, 500},
                {new String[]{"10", "10"}, 10, 10, 500},
                {new String[]{"9", "9", "199", "48"}, 10, 10, 200},
        };
    }
}