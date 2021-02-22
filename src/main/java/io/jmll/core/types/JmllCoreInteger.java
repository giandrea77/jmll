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

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
public class JmllCoreInteger extends JmllCore<Integer> {

    /**
     * @param size output array dimension
     * @return array of random integer
     */
    @Override
    public Integer[] generateArray(int size) {
        return generateArray(size, JmllConstants.Sign.NEUTRAL);
    }

    /**
     *
     * @param size output array dimension
     * @param sign Expected sign of random numbers
     * @return array of random integer
     */
    @Override
    public Integer[] generateArray(int size, JmllConstants.Sign sign) {

        // https://stackoverflow.com/questions/66067625/generic-returned-array-is-not-expected-type
        // Generated.toArray() returns an Object array, and casting it to T[] is not checked at compile time (hence the warning).
        // You can improve the type safety of your code by passing an array to toArray(), ensuring that your returned array's component type is exactly T.
        // But the array will have to be created by the caller (because generateArray can't create an array of an unknown type T)
        Supplier<Integer[]> arrayCreator = () -> new Integer[size];

        List<Integer> listOfArrays = generateList(Random::nextInt, size).stream()
                .map(item -> ( sign.toInt() == JmllConstants.Sign.NEUTRAL.toInt() ? item : Math.abs(item) * sign.toInt() ))
                .collect(Collectors.toList());

        return listOfArrays.toArray(arrayCreator.get());
    }

    /**
     *
     * @param size
     * @param min
     * @param max
     * @param sign
     * @return
     */
    @Override
    public Integer[] generateArray(int size, Integer min, Integer max, JmllConstants.Sign sign) {

        Supplier<Integer[]> arrayCreator = () -> new Integer[size];

        Random rnd = new Random();
        List<Integer> generate = Stream.generate(() -> rnd.nextInt(max - min) + min)
                .limit(size)
                .map(item -> ( sign.toInt() == JmllConstants.Sign.NEUTRAL.toInt() ? item : Math.abs(item) * sign.toInt() ))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        return generate.toArray(arrayCreator.get());

    }

    /**
     * https://docs.scipy.org/doc/scipy/reference/generated/scipy.stats.describe.html
     *
     * @param array = [4 5 8 5 6 4 9 2 4 3 6]
     * Measures of Dispersion
     * Minimum = 2
     * Maximum = 9
     * Range = 7
     * Varience = 3.90082644628
     * Standard Deviation = 1.9750509984
     *
     * @return List of statistic calculated values
     */
    @Override
    public HashMap<String, Number> describe(Integer[] array) {

        HashMap<String, Number> results = new HashMap<>();
        Integer sum = Arrays.stream(array).mapToInt(Integer::intValue).sum();
        Double mean = Double.valueOf(sum) / array.length;
        Double variance = Arrays.stream(array).map(a -> (a - mean) * ( a - mean )).reduce(0d, Double::sum) / (array.length - 1);

        results.put("mean", mean);
        results.put("min", Arrays.stream(array).mapToInt(Integer::intValue).min().orElseThrow(NoSuchElementException::new));
        results.put("max", Arrays.stream(array).mapToInt(Integer::intValue).max().orElseThrow(NoSuchElementException::new));
        results.put("variance", variance);
        results.put("standardDeviation", Math.sqrt(variance));

        return results;
    }

    /**
     * Generate a Matrix [{@rows} x {@colums}] of integers
     *
     * @param rows number of rows
     * @param columns number columns
     * @return a matrix with random value
     */
    @Override
    public Integer[][] generateMatrix(int rows, int columns) {

        Integer[][] matrix = new Integer[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(Random::nextInt, () -> new Integer[columns], columns);
        }

        return matrix;

    }

    /**
     * Generate a Matrix [{@rows} x {@colums}] of {@sign} integers
     *
     * @param rows
     * @param columns
     * @param sign
     * @return
     */
    @Override
    public Integer[][] generateMatrix(int rows, int columns, JmllConstants.Sign sign) {

        Integer[][] matrix = new Integer[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(columns, sign);
        }

        return matrix;

    }

    /**
     * Generate a Matrix [{@rows} x {@colums}] of {@sign} integers between {@min} and {@max}
     *
     * @param rows
     * @param columns
     * @param sign
     * @param min
     * @param max
     * @return
     */
    @Override
    public Integer[][] generateMatrix(int rows, int columns, JmllConstants.Sign sign, Integer min, Integer max) {

        Integer[][] matrix = new Integer[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(columns, min, max, sign);
        }

        return matrix;

    }

    /**
     * Prettify an array
     * @param array of Integers
     * @return a string that represents the array
     */
    @Override
    public String prettify(Integer[] array) {
        StringBuilder sb = new StringBuilder().append("\n");
        return Arrays.asList(array).stream().map(String::valueOf).collect(Collectors.joining("\t"));
    }

    /**
     * Prettify a matrix
     *
     * @param matrix of array
     * @return a string that represents the matrix
     */
    @Override
    public String prettify(Integer[][] matrix) {

        StringBuilder sb = new StringBuilder().append("\n");

        for ( int index = 0; index < matrix.length; index++ ) {

            for ( int innerIndex = 0; innerIndex < matrix[0].length; innerIndex++ ) {
                sb.append(String.format("%20s", matrix[index][innerIndex]));
            }

            sb.append("\n");

        }

        return sb.toString();

    }
}
