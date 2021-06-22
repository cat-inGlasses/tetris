package com.epam.prejap.tetris;

import org.testng.annotations.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

@Test(groups = {"parameters", "console"})
public class ParametersTest {

    protected final PrintStream stdout = System.out;
    protected final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeClass
    public void prepareOutStreamToBeTested() {
        System.setOut(new PrintStream(outStream));
    }

    @BeforeMethod
    public void resetOutStreamBeforeTestCall() {
        outStream.reset();
    }

    @AfterClass
    public void resetOutStreamForResultToBeDisplayed() {
        System.setOut(stdout);
    }

    @Test(dataProvider = "cliParams", groups = {"console"})
    public void shouldProvideUserWithMessageAboutParameters(String[] cliArgs, int expectedRows, int expectedCols, int expectedDelay) {

        // arrange
        var pattern = "The game will start with %d rows and %d columns and a delay of %d milliseconds" + System.lineSeparator();
        String expectedScreen = String.format(pattern, expectedRows, expectedCols, expectedDelay);

        // act
        new Parameters(cliArgs);

        // assert
        assertEquals(outStream.toString(), expectedScreen, "Wrong message for user!");
    }

    @Test(dataProvider = "cliParams", groups = {"parameters"})
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