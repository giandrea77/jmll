package io.jmll.core.integer;
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

import java.util.Arrays;
import java.util.Random;

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
public abstract class JmllCoreInteger {

    /**
     * Generate a single random number
     *
     * @return
     */
    public Integer generateNumber() {
        return new Random().nextInt();
    }

    /**
     * Generate a list random {@code size} integers
     *
     * @param size
     * @return
     */
    public Integer[] generateNumbers(Integer size) {
        Random rand = new Random();
        Integer[] array = new Integer[size];
        Arrays.setAll(array, item -> rand.nextInt());
        return array;
    }

    /**
     * Generate a list random {@code size} integers with max number {@code max}
     * @param size
     * @param max
     * @return
     */
    public Integer[] generateNumbers(Integer size, Integer max) {
        return new Integer[0];
    }

    public Integer[] generateNumber(Integer size, Integer min, Integer max) {
        return new Integer[0];
    }

}
