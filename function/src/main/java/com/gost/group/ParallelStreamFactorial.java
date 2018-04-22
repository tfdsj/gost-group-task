package com.gost.group;


import java.math.BigInteger;
import java.util.stream.LongStream;


/**
 * Класс с паралельной обработкой факториала
 */
public class ParallelStreamFactorial implements Factorial {

    /** метод подсчета факториала
     * @param number
     * @return
     */
    @Override
    public BigInteger calculate(long number) {
        if(number<0) throw new IllegalArgumentException("wrong send number param to calculate");
        return calculateMultiplyElementsSeries(2, number);
    }

    /** метод подсчета умножения ряда с startElement по endElement с +1 инкрементом
     * @param startElement
     * @param endElement
     * @return
     */
    @Override
    public BigInteger calculateMultiplyElementsSeries(long startElement, long endElement) {
        return LongStream.rangeClosed(startElement, endElement).parallel().boxed().reduce(BigInteger.ONE, (multiple, num) -> multiple.multiply(BigInteger.valueOf(num)), BigInteger::multiply);
    }
}
