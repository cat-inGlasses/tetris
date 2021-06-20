package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
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
public class BlockShapeTest {

    private final Block block;
    private final byte[][] image;

    @Factory(dataProviderClass = BlockShapeData.class, dataProvider = "blocks")
    public BlockShapeTest(Block block, byte[][] image) {
        this.block = block;
        this.image = image;
    }

    @DataProvider
    public Iterator<Object[]> dotAtDataPerBlock() {
        return BlockShapeData.getDotAtDataFor(block.getClass());
    }

    public void shouldBeRightQntOfRows() {
        assertEquals(block.rows(), image.length,
                String.format("Number of rows for %s is incorrect.", block.getClass().getSimpleName()));
    }

    public void shouldBeRightQntOfColumns() {
        assertEquals(block.cols(), image[0].length,
                String.format("Number of columns for %s is incorrect.", block.getClass().getSimpleName()));
    }

    @Test(dataProvider = "dotAtDataPerBlock")
    public void shouldReturnRightBytesFromDotAtMethod(int i, int j, byte expectedDot) {
        assertEquals(block.dotAt(i, j), expectedDot,
                String.format("%s incorrect dotAt(%s, %s)", block.getClass().getSimpleName(), i, j));
    }
}
