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
public class JmllCoreDouble extends JmllCore<Double> {

    /**
     * @param size output array dimension
     * @return array of random integer
     */
    @Override
    public Double[] generateArray(int size) {
        return generateArray(size, JmllConstants.Sign.NEUTRAL);
    }

    /**
     * @param size output array dimension
     * @param sign Expected sign of random numbers
     * @return array of random integer
     */
    @Override
    public Double[] generateArray(int size, JmllConstants.Sign sign) {

        Supplier<Double[]> arrayCreator = () -> new Double[size];

        List<Double> listOfArrays = generateList(Random::nextDouble, size).stream()
                .map(item -> ( sign.toInt() == JmllConstants.Sign.NEUTRAL.toInt() ? item : Math.abs(item) * sign.toInt() ))
                .collect(Collectors.toList());

        return listOfArrays.toArray(arrayCreator.get());

    }

    @Override
    public Double[] generateArray(int size, Double min, Double max, JmllConstants.Sign sign) {

        Supplier<Double[]> arrayCreator = () -> new Double[size];

        Random rnd = new Random();
        List<Double> generate = Stream.generate(() -> rnd.nextDouble() * ((max - min) + 1) + min)
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
    public HashMap<String, Number> describe(Double[] array) {

        HashMap<String, Number> results = new HashMap<>();
        Double sum = Arrays.stream(array).mapToDouble(Double::intValue).sum();
        Double mean = Double.valueOf(sum) / array.length;
        Double variance = Arrays.stream(array).map(a -> (a - mean) * ( a - mean )).reduce(0d, Double::sum) / (array.length - 1);

        results.put("mean", mean);
        results.put("min", Arrays.stream(array).mapToDouble(Double::intValue).min().orElseThrow(NoSuchElementException::new));
        results.put("max", Arrays.stream(array).mapToDouble(Double::intValue).max().orElseThrow(NoSuchElementException::new));
        results.put("variance", variance);
        results.put("standardDeviation", Math.sqrt(variance));

        return results;

    }

    /**
     * Generate a Matrix [{@rows} x {@colums}] of doubles
     *
     * @param rows number of rows
     * @param columns number columns
     * @return a matrix with random value
     */
    @Override
    public Double[][] generateMatrix(int rows, int columns) {

        Double[][] matrix = new Double[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(Random::nextDouble, () -> new Double[columns], columns);
        }

        return matrix;

    }

    /**
     * Generate a Matrix [{@rows} x {@colums}] of {@sign} doubles
     *
     * @param rows
     * @param columns
     * @param sign
     * @return
     */
    @Override
    public Double[][] generateMatrix(int rows, int columns, JmllConstants.Sign sign) {

        Double[][] matrix = new Double[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(columns, sign);
        }

        return matrix;

    }

    /**
     * Generate a Matrix [{@rows} x {@colums}] of {@sign} doubles between {@min} and {@max}
     *
     * @param rows
     * @param columns
     * @param sign
     * @param min
     * @param max
     * @return
     */
    @Override
    public Double[][] generateMatrix(int rows, int columns, JmllConstants.Sign sign, Double min, Double max) {

        Double[][] matrix = new Double[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(columns, min, max, sign);
        }

        return matrix;

    }

    /**
     * Prettify an array
     *
     * @param array of Doubles
     * @return a string that represents the array
     */
    @Override
    public String prettify(Double[] array) {

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
    public String prettify(Double[][] matrix) {

        StringBuilder sb = new StringBuilder().append("\n");

        for ( int index = 0; index < matrix.length; index++ ) {
            sb.append(prettify(matrix[index]));
            sb.append("\n");
        }

        return sb.toString();

    }
}
