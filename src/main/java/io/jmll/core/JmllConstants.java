package io.jmll.core;
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

/**
 * @author : Andrea Girardi
 * @created : Feb, 2021
 */
public class JmllConstants {

    /**
     * Sign enum
     */
    public enum Sign {

        POSITIVE(1),
        NEGATIVE(-1),
        NEUTRAL(0);

        private final int sign;

        private Sign(int sign) {
            this.sign = sign;
        }

        public int toInt() {
            return sign;
        }

        public static Sign checkSign(Integer value) {

            if ( value >= 0 ) {
                return POSITIVE;
            } else {
                return NEGATIVE;
            }

        }

    }

    public static final int SIGN_POSITIVE = 1;
    public static final int SIGN_NEGATIVE = -1;

}
