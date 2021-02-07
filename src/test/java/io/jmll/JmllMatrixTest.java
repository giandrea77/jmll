package io.jmll;

import com.google.gson.Gson;
import io.jmll.core.JmllConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

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

    private final int row = 5;
    private final int column = 5;

    @Test
    @Order(0)
    void generateIntegerMatrix() {

        Integer[][] matrix = JmllMatrix.generateIntegerMatrix(row, column);
        logger.info("Matrix: " + JmllMatrix.prettifyMatrix(matrix));
    }

    @Test
    @Order(2)
    void generatePositiveIntegerMatrix() {

        Integer[][] matrixPositive = JmllMatrix.generateIntegerMatrix(row, column, JmllConstants.Sign.POSITIVE);
        logger.info("matrixPositive: " + JmllMatrix.prettifyMatrix(matrixPositive));

    }

    @Test
    @Order(3)
    void generateNegativeIntegerMatrix() {

        Integer[][] matrixNegative = JmllMatrix.generateIntegerMatrix(row, column, JmllConstants.Sign.NEGATIVE);
        logger.info("matrixNegative: " + JmllMatrix.prettifyMatrix(matrixNegative));

    }

    @Test
    @Order(4)
    void generateNeutralIntegerMatrixMinMax() {

        Integer[][] matrixMinMax = JmllMatrix.generateIntegerMatrix(row, column, JmllConstants.Sign.NEUTRAL, 100, 1000);
        logger.info("matrixMinMax: " + JmllMatrix.prettifyMatrix(matrixMinMax));

    }

    @Test
    @Order(5)
    void descriptionOfNeutralIntegerMatrixMinMax() {

        Integer[][] matrixMinMax = JmllMatrix.generateIntegerMatrix(row, column, JmllConstants.Sign.NEUTRAL, 100, 1000);
        logger.info("matrixMinMax: " + JmllMatrix.prettifyMatrix(matrixMinMax));

        logger.info("description: " + new Gson().toJson(JmllMatrix.describe(matrixMinMax, 0)));

    }

}