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
public class JmllCoreLong extends JmllCore<Long> {

    @Override
    public Long[] generateArray(int size) {
        return generateArray(size, JmllConstants.Sign.NEUTRAL);
    }

    @Override
    public Long[] generateArray(int size, JmllConstants.Sign sign) {

        Supplier<Long[]> arrayCreator = () -> new Long[size];

        List<Long> listOfArrays = generateList(Random::nextLong, size).stream()
                .map(item -> ( sign.toInt() == JmllConstants.Sign.NEUTRAL.toInt() ? item : Math.abs(item) * sign.toInt() ))
                .collect(Collectors.toList());

        return listOfArrays.toArray(arrayCreator.get());

    }

    @Override
    public Long[] generateArray(int size, Long min, Long max, JmllConstants.Sign sign) {

        Supplier<Long[]> arrayCreator = () -> new Long[size];

        Random rnd = new Random();
        List<Long> generate = Stream.generate(() -> rnd.nextLong() * ((max - min) + 1) + min)
                .limit(size)
                .map(item -> ( sign.toInt() == JmllConstants.Sign.NEUTRAL.toInt() ? item : Math.abs(item) * sign.toInt() ))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        return generate.toArray(arrayCreator.get());

    }

    @Override
    public HashMap<String, Number> describe(Long[] array) {

        HashMap<String, Number> results = new HashMap<>();
        Double sum = Arrays.stream(array).mapToDouble(Long::longValue).sum();
        Double mean = Double.valueOf(sum) / array.length;
        Double variance = Arrays.stream(array).map(a -> (a - mean) * ( a - mean )).reduce(0d, Double::sum) / (array.length - 1);

        results.put("mean", mean);
        results.put("min", Arrays.stream(array).mapToDouble(Long::longValue).min().orElseThrow(NoSuchElementException::new));
        results.put("max", Arrays.stream(array).mapToDouble(Long::longValue).max().orElseThrow(NoSuchElementException::new));
        results.put("variance", variance);
        results.put("standardDeviation", Math.sqrt(variance));

        return results;

    }

    @Override
    public Long[][] generateMatrix(int rows, int columns) {

        Long[][] matrix = new Long[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(Random::nextLong, () -> new Long[columns], columns);
        }

        return matrix;

    }

    @Override
    public Long[][] generateMatrix(int rows, int columns, JmllConstants.Sign sign) {

        Long[][] matrix = new Long[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(columns, sign);
        }

        return matrix;

    }

    @Override
    public Long[][] generateMatrix(int rows, int columns, JmllConstants.Sign sign, Long min, Long max) {

        Long[][] matrix = new Long[rows][columns];

        for ( int index = 0; index < rows; index++ ) {
            matrix[index] = generateArray(columns, min, max, sign);
        }

        return matrix;

    }

    @Override
    public String prettify(Long[] array) {
        StringBuilder sb = new StringBuilder().append("\n");
        return Arrays.asList(array).stream().map(String::valueOf).collect(Collectors.joining("\t"));
    }

    @Override
    public String prettify(Long[][] matrix) {

        StringBuilder sb = new StringBuilder().append("\n");

        for ( int index = 0; index < matrix.length; index++ ) {
            sb.append(prettify(matrix[index]));
            sb.append("\n");
        }

        return sb.toString();

    }
}
