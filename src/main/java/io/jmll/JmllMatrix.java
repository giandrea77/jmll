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
import io.jmll.core.integer.JmllCoreInteger;

import java.util.Random;

/**
 * @author : andrea
 * @created : 2021, Feb
 */
public class JmllMatrix {

    /**
     * Generate a Matrix [{@rows} x {@colums}] of integers
     * @param rows
     * @param columns
     * @return
     */
    public static Integer[][] generateIntegerMatrix(int rows, int columns) {

        Integer[][] matrix = new Integer[rows][columns];
        JmllCore<Integer> jmllCore = new JmllCore<>();

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = JmllCore.generateArray(Random::nextInt, () -> new Integer[columns], columns);
        }

        return matrix;

    }

    /**
     * Generate a Matrix [{@rows} x {@colums}] of {@sign}integers with specific
     *
     * @param rows
     * @param columns
     * @param sign
     * @return
     */
    public static Integer[][] generateIntegerMatrix(int rows, int columns, JmllConstants.Sign sign) {

        Integer[][] matrix = new Integer[rows][columns];
        JmllCore<Integer> jmllCore = new JmllCore<>();

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = JmllCoreInteger.generateArray(() -> new Integer[columns], columns, sign);
        }

        return matrix;

    }

}
