package com.gost.group;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.LongStream;

public interface Factorial {
    /** метод подсчета факториала
     * @param number
     * @return
     */
    BigInteger calculate(long number);

    /** метод подсчета умножения ряда с startElement по endElement с +1 инкрементом
     * @param startElement
     * @param endElement
     * @return
     */
    BigInteger calculateMultiplyElementsSeries(long startElement, long endElement);
}
