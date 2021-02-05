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

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
public class JmllCore<T> {

    /**
     * Generate a single number
     *
     * @param creator
     * @return
     */
    public T generateNumber(Function<Random, T> creator) {
        return creator.apply(new Random());
    }



    /**
     * Generate a list of {@code size} {@code clazz} random elements
     * @param size
     * @param <T>
     * @return
     */
    public static <T> T[] generateArray(Function<Random, T> creator, Supplier<T[]> arrayCreator, int size) {
        List<T> generated  = (List<T>) Stream.generate(() -> creator.apply(new Random())).limit(size).collect(Collectors.toList());
        return generated.toArray(arrayCreator.get());
    }

    public static <T> List<T> generateList(Function<Random, T> creator, int size) {
        return  (List<T>) Stream.generate(() -> creator.apply(new Random())).limit(size).collect(Collectors.toList());
    }

}
