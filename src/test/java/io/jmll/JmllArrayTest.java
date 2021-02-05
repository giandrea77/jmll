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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
public class JmllArrayTest {

    private final int ARRAY_SIZE = 10000000;
    private Integer randomNumber;

    @Test
    void arrayOfIntegers() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfIntegers(ARRAY_SIZE).length);
    }

    @Test
    void testArrayOfIntegers() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfIntegers(ARRAY_SIZE, 10).length);
    }

    @Test
    void arrayOfLongs() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfLongs(ARRAY_SIZE).length);
    }

    @Test
    void testArrayOfLongs() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfLongs(ARRAY_SIZE, 10L).length);
    }

    @Test
    void arrayOfDouble() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfDouble(ARRAY_SIZE).length);
    }

    @Test
    void testArrayOfDouble() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfDouble(ARRAY_SIZE, Double.valueOf(10)).length);
    }

    @Test
    void arrayOfFloat() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfFloat(ARRAY_SIZE).length);
    }

    @Test
    void testArrayOfFloat() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfFloat(ARRAY_SIZE, Float.valueOf(10)).length);
    }

    @Test
    void arrayOfZeros() {
        assertEquals(ARRAY_SIZE, JmllArray.arrayOfZeros(ARRAY_SIZE).length);
    }

}