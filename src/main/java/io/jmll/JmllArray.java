package io.jmll;

import io.jmll.core.JmllCore;

import java.util.Random;

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
     * Generate an array of random integers
     *
     * @return
     */
    public int[] array() {
        return JmllCore.generateIntegers(JmllCore.generateInteger());
    }

    /**
     * Generate an array of{@code size} integers
     *
     * @param size
     * @return
     */
    public int[] array(int size) {
        return JmllCore.generateIntegers(size);
    }

    public int[] zeros(int size) {
        return new int[1];
    }

}
