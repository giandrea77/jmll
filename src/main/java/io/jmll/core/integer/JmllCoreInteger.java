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

import io.jmll.core.JmllConstants;
import io.jmll.core.JmllCore;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
public abstract class JmllCoreInteger extends JmllCore<Integer> {

    /**
     * Generate a list of integers with a specific sign
     * @param arrayCreator
     * @param size
     * @param sign
     * @return
     */
    public static Integer[] generateArray(Supplier<Integer[]> arrayCreator, int size, JmllConstants.Sign sign) {

        List<Integer> listOfArrays = generateList(Random::nextInt, size).stream().map(item -> ( sign.toInt() == JmllConstants.Sign.NEUTRAL.toInt() ? item : Math.abs(item) * sign.toInt() )).collect(Collectors.toList());
        return listOfArrays.toArray(arrayCreator.get());

    }

    /**
     *
     * @param arrayCreator
     * @param size
     * @param min
     * @param max
     * @param sign
     * @return
     */
    public static Integer[] generateArray(Supplier<Integer[]> arrayCreator, int size, int min, int max, JmllConstants.Sign sign) {

        Random rnd = new Random();
        List<Integer> generate = Stream.generate(() -> rnd.nextInt(max - min) + min)
                .limit(size)
                .map(item -> ( sign.toInt() == JmllConstants.Sign.NEUTRAL.toInt() ? item : Math.abs(item) * sign.toInt() ))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return generate.toArray(arrayCreator.get());

    }

    /**
     * https://docs.scipy.org/doc/scipy/reference/generated/scipy.stats.describe.html
     * Array = [4 5 8 5 6 4 9 2 4 3 6]
     * Measures of Dispersion
     * Minimum = 2
     * Maximum = 9
     * Range = 7
     * Varience = 3.90082644628
     * Standard Deviation = 1.9750509984
     * @return
     */
    public static HashMap<String, Number> describe(Integer[] array) {

        HashMap<String, Number> results = new HashMap<>();
        Double min = 0.0, max = 0.0, range = 0.0, variance = 0.0, standardDeviation = 0.0, mean = 0.0;

        Integer sum = Arrays.stream(array).mapToInt(Integer::intValue).sum();
        results.put("mean", Double.valueOf(sum) / array.length);

        return results;

    }


}
