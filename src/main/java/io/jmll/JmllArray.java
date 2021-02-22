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
import io.jmll.core.types.JmllCoreInteger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Random integer arrays generator
 *
 * Bugs: none known
 *
 * @author      Andrea Girardi
 * @version     1.0
 * @since       Feb, 2020
 * @see
 */
public abstract class JmllArray {

    /**
     * Generate an array of int {@code size} integers
     *
     * @param size
     * @return
     */
//    public static Integer[] arrayOfIntegers(int size) {
//        return JmllCore.generateArray(Random::nextInt, () -> new Integer[size], size);
//    }

    /**
     *
     * @param size
     * @param sign
     * @return
     */
//    public static Integer[] arrayOfIntegers(int size, JmllConstants.Sign sign) {
//        JmllCore<Integer> calculable = new JmllCoreInteger();
//        return calculable.generateArray(() -> new Integer[size], size, sign);
//    }

    /**
     * Generate an array of {@code size} integers
     *
     * @param size
     * @return
     */
//    public static Integer[] arrayOfIntegers(int size, Integer MaxValue) {
//        return JmllCore.generateArray(Random::nextInt, () -> new Integer[size], size);
//    }

    /**
     *
     * @param size
     * @return
     */
//    public static Long[] arrayOfLongs(int size) {
//        return JmllCore.generateArray(Random::nextLong, () -> new Long[size], size);
//    }

    /**
     *
     * @param size
     * @return
     */
//    public static Long[] arrayOfLongs(int size, Long maxValue) {
//        return JmllCore.generateArray(Random::nextLong, () -> new Long[size], size);
//    }

    /**
     *
     * @param size
     * @return
     */
//    public static Double[] arrayOfDouble(int size) {
//        return JmllCore.generateArray(Random::nextDouble, () -> new Double[size], size);
//    }

    /**
     *
     * @param size
     * @return
     */
//    public static Double[] arrayOfDouble(int size, Double maxValue) {
//        return JmllCore.generateArray(Random::nextDouble, () -> new Double[size], size);
//    }

    /**
     *
     * @param size
     * @return
     */
//    public static Float[] arrayOfFloat(int size) {
//        return JmllCore.generateArray(Random::nextFloat, () -> new Float[size], size);
//    }

    /**
     *
     * @param size
     * @return
     */
//    public static Float[] arrayOfFloat(int size, Float maxValue) {
//        return JmllCore.generateArray(Random::nextFloat, () -> new Float[size], size);
//    }

    /**
     *
     * @param size
     * @return
     */
//    public static Integer[] arrayOfZeros(int size) {
//        List<Integer> generated  = Stream.generate(() -> 0).limit(size).collect(Collectors.toList());
//        return generated.toArray(new Integer[size]);
//    }

    /**
     * Generates an array of UUID. A UUID represents a 128-bit value.
     *
     * @param size
     * @return
     */
//    public static UUID[] arrayOfUUID(int size) {
//        List<UUID> generated = Stream.generate(UUID::randomUUID).limit(size).collect(Collectors.toList());
//        return generated.toArray(new UUID[size]);
//    }

    /**
     * Prettify an array
     *
     *
     * @param array
     * @return
     */
//    public static String prettify(Integer[] array) {
//        StringBuilder sb = new StringBuilder().append("\n");
//        return Arrays.asList(array).stream().map(String::valueOf).collect(Collectors.joining("\t"));
//    }

}
