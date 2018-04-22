package com.gost.group.simple;


import com.gost.group.Factorial;

import java.math.BigInteger;


public class SimpleFactorial implements Factorial {

    /** метод подсчета факториала
     * @param number
     * @return
     */
    @Override
    public BigInteger calculate(long number) {
        if (number < 0) throw new IllegalArgumentException(number + " is not a positive number");
        return calculateMultiplyElementsSeries(1, number);
    }

    /** метод подсчета умножения ряда с startElement по endElement с +1 инкрементом
     * @param startElement
     * @param endElement
     * @return
     */
    @Override
    public BigInteger calculateMultiplyElementsSeries(long startElement, long endElement) {
        BigInteger result = BigInteger.ONE;
        for (long i = startElement; i <= endElement; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
