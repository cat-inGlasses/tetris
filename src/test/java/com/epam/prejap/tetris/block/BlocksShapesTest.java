package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "blockShapes")
public class BlocksShapesTest {

    private final int rowsExpected;
    private final int rowsActual;
    private final int colsExpected;
    private final int colsActual;
    private final String testedBlock;
    private final Object[][] dotRepresentation;

    public void numberOfEveryBlockShapeRowsAsExpected() {
        assertEquals(rowsActual, rowsExpected, "Number of rows for " + testedBlock +
                " is incorrect. Expected: " + rowsExpected + ", actual: " + rowsActual);
    }

    public void numberOfEveryBlockShapeColsAsExpected() {
        assertEquals(colsActual, colsExpected, "Number of cols for " + testedBlock +
                " is incorrect. Expected: " + colsExpected + ", actual: " + colsActual);
    }

    @Test(dataProvider = "dotsRepresentation")
    public void dotAtReturnCorrectValue(int actual, int expected, String message) {
        String msg = testedBlock + message;
        assertEquals(actual, expected, msg);
    }

    @DataProvider
    public Object[][] dotsRepresentation() {
        return dotRepresentation;
    }

    @Factory(dataProvider = "blocks")
    public BlocksShapesTest(Block block, String testedBlock, int rowsExpected, int colsExpected, Object[][] dotRepresentation) {
        this.rowsActual = block.rows();
        this.rowsExpected = rowsExpected;
        this.colsActual = block.cols();
        this.colsExpected = colsExpected;
        this.testedBlock = testedBlock;
        this.dotRepresentation = dotRepresentation;
    }

    @DataProvider
    public static Object[][] blocks() {

        OBlock oBlock = new OBlock();
        var oBlockDotRepresentation = new Object[][]{
                {oBlock.dotAt(0, 0), 1, " incorrect dotAt(0, 0)"},
                {oBlock.dotAt(0, 1), 1, " incorrect dotAt(0, 1)"},
                {oBlock.dotAt(1, 0), 1, " incorrect dotAt(1, 0)"},
                {oBlock.dotAt(1, 1), 1, " incorrect dotAt(1, 1)"}
        };

        TBlock tBlock = new TBlock();
        var TBlockDotRepresentation = new Object[][]{
                {tBlock.dotAt(0, 0), 1, "Incorrect dotAt(0, 0)"},
                {tBlock.dotAt(0, 1), 1, "Incorrect dotAt(0, 1)"},
                {tBlock.dotAt(0, 2), 1, "Incorrect dotAt(0, 2)"},
                {tBlock.dotAt(1, 0), 0, "Incorrect dotAt(1, 0)"},
                {tBlock.dotAt(1, 1), 1, "Incorrect dotAt(1, 1)"},
                {tBlock.dotAt(1, 2), 0, "Incorrect dotAt(1, 2)"},
        };

        YBlock yBlock = new YBlock();
        var YBlockDotRepresentation = new Object[][]{
                {yBlock.dotAt(0, 0), 1, "Incorrect dotAt(0, 0)"},
                {yBlock.dotAt(0, 1), 0, "Incorrect dotAt(0, 1)"},
                {yBlock.dotAt(0, 2), 1, "Incorrect dotAt(0, 2)"},
                {yBlock.dotAt(1, 0), 0, "Incorrect dotAt(1, 0)"},
                {yBlock.dotAt(1, 1), 1, "Incorrect dotAt(1, 1)"},
                {yBlock.dotAt(1, 2), 0, "Incorrect dotAt(1, 2)"},
                {yBlock.dotAt(2, 0), 0, "Incorrect dotAt(2, 0)"},
                {yBlock.dotAt(2, 1), 1, "Incorrect dotAt(2, 1)"},
                {yBlock.dotAt(2, 2), 0, "Incorrect dotAt(2, 2)"}
        };

        return new Object[][]{
                {oBlock, "Tests for OBlock", 2, 2, oBlockDotRepresentation},
                {tBlock, "Tests for TBlock", 2, 3, TBlockDotRepresentation},
                {yBlock, "Tests for YBlock", 3, 3, YBlockDotRepresentation}
        };
    }
}
