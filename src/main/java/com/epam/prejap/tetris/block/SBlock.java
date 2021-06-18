package com.epam.prejap.tetris.block;

/**
 * Creation date: 18/06/2021
 *
 * @author Nikita Pochapynskyi
 */
public class SBlock extends Block {

    /**
     * Byte array represents "S" block.
     * In game will be displayed as (between lines):
     *  -------------------
     *       ##
     *      ##
     *  -------------------
     */
    private static final byte[][] S_IMAGE = {
            {0, 1, 1},
            {1, 1, 0}
    };

    public SBlock() {
        super(S_IMAGE);
    }
}