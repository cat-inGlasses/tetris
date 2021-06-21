package com.epam.prejap.tetris;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Nikita Pochapynskyi
 */
public class ParametersTest {

    @BeforeMethod
    void resetState() {
        Parameters.resetArgs();
    }

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
                {new String[]{"50", "50", "700"}, 50, 50, 700},
                {new String[]{"20", "30", "500"}, 20, 30, 500},
                {new String[]{"-1", "-1", "-1"}, 10, 10, 200},
                {new String[]{"1000", "1000", "50000"}, 100, 100, 2000},
                {new String[]{"1000"}, 100, 30, 500},
                {new String[]{"5"}, 10, 30, 500},
                {new String[]{"10", "-40"}, 10, 10, 500},
                {new String[]{"7", "40"}, 10, 40, 500},
                {new String[]{"10.5", "40.6", "499,99"}, 20, 30, 500},
                {new String[]{"lorem ipsum", "lorem ipsum", "lorem ipsum"}, 20, 30, 500},
                {new String[]{"10", "20", "30", "48"}, 10, 20, 200},
        };
    }
}