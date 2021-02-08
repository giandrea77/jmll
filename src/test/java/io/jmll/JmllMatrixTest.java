package io.jmll;

import com.google.gson.Gson;
import io.jmll.core.JmllConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/* MIT License
-----------

Copyright (c) 2021 Andrea Girardi (https://www.andreagirardi.it)
Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE. */

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
class JmllMatrixTest {

    private static Logger logger = LogManager.getLogger(JmllMatrixTest.class);

    private final int row = 1000;
    private final int column = 1000;

    /**
     * Private method used to check the signs of the single values
     *
     * @param matrix
     * @param row
     * @param column
     * @param sign
     * @return
     */
    private boolean checkMatrix(Integer[][] matrix, int row, int column, JmllConstants.Sign sign) {

        for ( int index = 0; index < row; index++ ) {

            // Integer found = Arrays.asList(matrix[index]).stream().filter(item ->  JmllConstants.Sign.checkSign(item) == sign).findAny().orElse(0);

            for ( int innerIndex = 0; innerIndex < column; innerIndex++ ) {
                if ( JmllConstants.Sign.checkSign(matrix[index][innerIndex]) != sign ) {
                    return false;
                }
            }

        }

        return true;

    }


    @Test
    @Order(0)
    void generateIntegerMatrix() {

        Integer[][] matrix = JmllMatrix.generateIntegerMatrix(row, column);
        logger.trace("Matrix: " + JmllMatrix.prettifyMatrix(matrix));
    }

    @Test
    @Order(2)
    void generatePositiveIntegerMatrix() {

        Integer[][] matrixPositive = JmllMatrix.generateIntegerMatrix(row, column, JmllConstants.Sign.POSITIVE);
        logger.trace("matrixPositive: " + JmllMatrix.prettifyMatrix(matrixPositive));

        assertTrue(checkMatrix(matrixPositive, row, column, JmllConstants.Sign.POSITIVE));

    }

    @Test
    @Order(3)
    void generateNegativeIntegerMatrix() {

        Integer[][] matrixNegative = JmllMatrix.generateIntegerMatrix(row, column, JmllConstants.Sign.NEGATIVE);
        logger.trace("matrixNegative: " + JmllMatrix.prettifyMatrix(matrixNegative));

        assertTrue(true == checkMatrix(matrixNegative, row, column, JmllConstants.Sign.NEGATIVE));

    }

    @Test
    @Order(4)
    void generateNeutralIntegerMatrixMinMax() {

        Integer[][] matrixMinMax = JmllMatrix.generateIntegerMatrix(row, column, JmllConstants.Sign.NEUTRAL, 100, 1000);
        logger.trace("matrixMinMax: " + JmllMatrix.prettifyMatrix(matrixMinMax));

    }

    @Test
    @Order(5)
    void descriptionOfNeutralIntegerMatrixMinMax() {

        Integer[][] matrixMinMax = JmllMatrix.generateIntegerMatrix(row, column, JmllConstants.Sign.NEUTRAL, 100, 1000);
        logger.trace("matrixMinMax: " + JmllMatrix.prettifyMatrix(matrixMinMax));

        logger.trace("description: " + new Gson().toJson(JmllMatrix.describe(matrixMinMax, 0)));

    }

}