package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.assertEquals;

/**
 * "Generic" test class, to test shapes.
 * Define shape object and its expected image in {@link BlockShapeData#blocks} array
 * and it will be tested automatically
 * <p>
 * Creation date: 18/06/2021
 *
 * @author Nikita Pochapynskyi
 */
@Test(groups = "blockShapes")
public class BlockShapesTest {

    /**
     * Template error message for <b>wrong ROWS</b>> quantity
     */
    private final static String ROW_QNT_MSG = "Number of rows for block image in class %s is incorrect. Expected %d, but got: %d";

    /**
     * Template error message for <b>wrong COLUMNS</b> quantity
     */
    private final static String COL_QNT_MSG = "Number of columns for block image in class %s is incorrect. Expected %d, but got: %d";

    /**
     * Template error message for <b>wrong DOT</b> in block's image
     */
    private final static String DOT_MSG = "Incorrect dot for block image in class %s for dotAt(%d, %d). Expected %d, but got: %d";

    @Test(dataProvider = "blocks")
    public void shouldBeRightQntOfRows(Block block, byte[][] image) {

        // arrange
        int expectedRows = image.length;

        // act
        int actualRows = block.image.length;

        // assert
        assertEquals(actualRows, expectedRows, String.format(ROW_QNT_MSG, block.getClass().getName(), expectedRows, actualRows));
    }

    @Test(dataProvider = "blocks")
    public void shouldBeRightQntOfColumns(Block block, byte[][] image) {

        // arrange
        int expectedRows = image[0].length;

        // act
        int actualRows = block.image[0].length;

        // assert
        assertEquals(actualRows, expectedRows, String.format(COL_QNT_MSG, block.getClass().getName(), expectedRows, actualRows));
    }

    @Test(dataProvider = "dotAtDataPerBlock")
    public void shouldReturnRightBytesFromDotAtMethod(Block block, int i, int j, byte expectedDot) {

        // act
        byte actualDot = block.dotAt(i, j);

        // assert
        assertEquals(actualDot, expectedDot, String.format(DOT_MSG, block.getClass().getName(), i, j, expectedDot, actualDot));
    }

    @DataProvider
    public static Object[][] blocks() {
        return BlockShapeData.blocks;
    }

    @DataProvider
    public static Iterator<Object[]> dotAtDataPerBlock() {
        return BlockShapeData.getDotAtData();
    }
}
