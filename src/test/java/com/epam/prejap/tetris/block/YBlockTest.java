package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = {"blockShapes", "blocks"})
public class YBlockTest {
    YBlock yBlock = new YBlock();

    public void numberOfYBlockRowsEqualsThree() {
        int actual = yBlock.rows();
        int expected = 3;
        assertEquals(actual, expected, "Number of rows is incorrect. Expected: " + expected + ", actual: " + actual);
    }

    public void numberOfYBlockColsEqualsThree() {
        int actual = yBlock.cols();
        int expected = 3;
        assertEquals(actual, expected, "Number of cols is incorrect. Expected: " + expected + ", actual: " + actual);
    }

    @Test(dataProvider = "dotsRepresentation")
    public void dotAtReturnCorrectValue(int i, int j, int expected, String message) {
        int actual = yBlock.dotAt(i, j);
        assertEquals(actual, expected, message);
    }

    @DataProvider
    public static Object[][] dotsRepresentation() {
        return new Object[][]{
                {0, 0, 1, "Incorrect dotAt(0, 0)"},
                {0, 1, 0, "Incorrect dotAt(0, 1)"},
                {0, 2, 1, "Incorrect dotAt(0, 2)"},
                {1, 0, 0, "Incorrect dotAt(1, 0)"},
                {1, 1, 1, "Incorrect dotAt(1, 1)"},
                {1, 2, 0, "Incorrect dotAt(1, 2)"},
                {2, 0, 0, "Incorrect dotAt(2, 0)"},
                {2, 1, 1, "Incorrect dotAt(2, 1)"},
                {2, 2, 0, "Incorrect dotAt(2, 2)"}
        };
    }
}
