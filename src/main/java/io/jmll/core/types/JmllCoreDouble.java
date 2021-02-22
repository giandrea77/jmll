package io.jmll.core.types;
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

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
public class JmllCoreDouble extends JmllCore<Double> {


    @Override
    public Double[] generateArray(int size) {
        return new Double[0];
    }

    @Override
    public Double[] generateArray(int size, JmllConstants.Sign sign) {
        return new Double[0];
    }

    @Override
    public Double[] generateArray(int size, Double min, Double max, JmllConstants.Sign sign) {
        return new Double[0];
    }

    @Override
    public HashMap<String, Number> describe(Double[] array) {
        return null;
    }

    @Override
    public Double[][] generateMatrix(int rows, int columns) {
        return new Double[0][];
    }

    @Override
    public Double[][] generateMatrix(int rows, int columns, JmllConstants.Sign sign) {
        return new Double[0][];
    }

    @Override
    public Double[][] generateMatrix(int rows, int columns, JmllConstants.Sign sign, int min, int max) {
        return new Double[0][];
    }

    @Override
    public String prettify(Double[] array) {
        return null;
    }

    @Override
    public String prettify(Double[][] matrix) {
        return null;
    }
}
