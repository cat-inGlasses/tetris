package com.epam.prejap.tetris.block;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class holds data of shapes that should be for each block class
 * <p>
 * Creation date: 18/06/2021
 *
 * @author Nikita Pochapynskyi
 */
public class BlockShapeData {

    /**
     * Holds block object to be tested and and its expected image.
     * Feel free to add more shapes here. They will be tested automatically.
     */
    final static Object[][] blocks = new Object[][]{
            {new SBlock(), new byte[][]{
                    {0, 1, 1},
                    {1, 1, 0}
            }},
            {new OBlock(), new byte[][]{
                    {1, 1},
                    {1, 1}
            }},
            {new TBlock(), new byte[][]{
                    {1, 1, 1},
                    {0, 1, 0}
            }},
            {new YBlock(), new byte[][]{
                    {1, 0, 1},
                    {0, 1, 0},
                    {0, 1, 0}
            }}
    };

    /**
     * Generates expected data for {@link Block#dotAt(int, int)} method
     *
     * @return {@link Iterator} with block object to be tested, coordinates of bytes and expected byte.
     */
    static Iterator<Object[]> getDotAtData() {

        List<Object[]> data = new LinkedList<>();
        for (Object[] block : blocks) {

            byte[][] image = (byte[][]) block[1];

            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[i].length; j++) {
                    data.add(new Object[]{block[0], i, j, image[i][j]});
                }
            }
        }

        return data.iterator();
    }
}
