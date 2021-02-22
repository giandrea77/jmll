package io.jmll;

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

import io.jmll.core.JmllConstants;
import io.jmll.core.JmllCore;
import io.jmll.core.types.JmllCoreDouble;
import io.jmll.core.types.JmllCoreInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
public class JmllArrayTest {

    private final int ARRAY_SIZE = 100;
    private Integer randomNumber;

    private static Logger logger = LogManager.getLogger(JmllArrayTest.class);

    @Test
    void arrayOfIntegers() {
        JmllCore<Integer> jmllCore = new JmllCoreInteger();
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE).length);
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE, JmllConstants.Sign.POSITIVE).length);
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE, JmllConstants.Sign.NEGATIVE).length);
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE, JmllConstants.Sign.NEUTRAL).length);
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE, 0, 10, JmllConstants.Sign.POSITIVE).length);
    }

    @Test
    void arrayOfDoubles() {
        JmllCore<Double> jmllCore = new JmllCoreDouble();
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE).length);
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE, JmllConstants.Sign.POSITIVE).length);
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE, JmllConstants.Sign.NEGATIVE).length);
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE, JmllConstants.Sign.NEUTRAL).length);
        assertEquals(ARRAY_SIZE, jmllCore.generateArray(ARRAY_SIZE, 0D, 10D, JmllConstants.Sign.POSITIVE).length);
    }


    @Test
    void describeIntegerArray() {

        JmllCore<Integer> jmllCore = new JmllCoreInteger();
        Integer[] array = jmllCore.generateArray(10, -10, 10, JmllConstants.Sign.NEUTRAL);
        logger.debug(jmllCore.prettify(array));
        logger.debug(jmllCore.describe(array));

    }

    @Test
    void describeDoubleArray() {

        JmllCore<Double> jmllCore = new JmllCoreDouble();
        Double[] array = jmllCore.generateArray(10, -10D, 10D, JmllConstants.Sign.NEUTRAL);
        logger.debug(jmllCore.prettify(array));
        logger.debug(jmllCore.describe(array));

    }

}