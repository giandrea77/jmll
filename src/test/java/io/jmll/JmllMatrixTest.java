package io.jmll;

import com.google.gson.Gson;
import io.jmll.core.JmllConstants;
import io.jmll.core.JmllCore;
import io.jmll.core.types.JmllCoreInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

            Integer found = Arrays.asList(matrix[index]).stream().filter(item ->  JmllConstants.Sign.checkSign(item) == sign).findAny().orElse(0);

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
        JmllCore<Integer> jmllCore = new JmllCoreInteger();
        Integer[][] matrix = jmllCore.generateMatrix(row, column);
        logger.trace("Matrix: " + jmllCore.prettify(matrix));
    }

    @Test
    @Order(2)
    void generatePositiveIntegerMatrix() {

        JmllCore<Integer> jmllCore = new JmllCoreInteger();
        Integer[][] matrixPositive = jmllCore.generateMatrix(row, column, JmllConstants.Sign.POSITIVE);
        logger.trace("matrixPositive: " + jmllCore.prettify(matrixPositive));

        assertTrue(checkMatrix(matrixPositive, row, column, JmllConstants.Sign.POSITIVE));

    }

    @Test
    @Order(3)
    void generateNegativeIntegerMatrix() {

        JmllCore<Integer> jmllCore = new JmllCoreInteger();
        Integer[][] matrixNegative = jmllCore.generateMatrix(row, column, JmllConstants.Sign.NEGATIVE);
        logger.trace("matrixNegative: " + jmllCore.prettify(matrixNegative));

        assertTrue(true == checkMatrix(matrixNegative, row, column, JmllConstants.Sign.NEGATIVE));

    }

    @Test
    @Order(4)
    void generateNeutralIntegerMatrixMinMax() {

        JmllCore<Integer> jmllCore = new JmllCoreInteger();
        Integer[][] matrixMinMax = jmllCore.generateMatrix(row, column, JmllConstants.Sign.NEUTRAL, 100, 1000);
        logger.trace("matrixMinMax: " + jmllCore.prettify(matrixMinMax));

    }

    @Test
    @Order(5)
    void descriptionOfNeutralIntegerMatrixMinMax() {

        JmllCore<Integer> jmllCore = new JmllCoreInteger();
        Integer[][] matrixMinMax = jmllCore.generateMatrix(row, column, JmllConstants.Sign.NEUTRAL, 100, 1000);
        logger.trace("matrixMinMax: " + jmllCore.prettify(matrixMinMax));

        logger.trace("description [0]: " + new Gson().toJson(jmllCore.describe(matrixMinMax[0])));
        logger.trace("description [1]: " + new Gson().toJson(jmllCore.describe(matrixMinMax[1])));
        logger.trace("description [2]: " + new Gson().toJson(jmllCore.describe(matrixMinMax[2])));

    }

}