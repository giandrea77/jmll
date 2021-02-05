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

import io.jmll.core.integer.JmllCore;

import java.util.List;
import java.util.Random;

/**
 * @author : andrea
 * @created : 2021, Feb
 */
public class JmllMatrix {

    public static Integer[][] generateIntegerMatrix(int rows, int columns) {

        Integer[][] matrix = new Integer[rows][columns];
        JmllCore<Integer> jmllCore = new JmllCore<>();

        for ( int index = 0; index < rows; index++ ) {
            for ( int innerIndex = 0; innerIndex < columns; innerIndex++ ) {
                matrix[index][innerIndex] = jmllCore.generateNumber(Random::nextInt);
            }
        }

        return matrix;

    }

}
