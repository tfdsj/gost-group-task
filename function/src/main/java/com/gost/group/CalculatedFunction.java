package com.gost.group;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static sun.swing.SwingUtilities2.submit;

public class CalculatedFunction implements BiFunction<Long, Long, BigInteger> {

    private Factorial factorial;

    public CalculatedFunction() {
    }

    public CalculatedFunction(Factorial factorial) {
        this.factorial = factorial;
    }

    /**
     * т.к. функция работает для всех m>=r - то для оптимизации вычислений можем сразу сократить вычисления min(r,(m-r))! и m!
     * верхний факториал переходит в ряд произведений (min(r,(m-r)) + 1)*(min(r,(m-r)) + 2)...*m, нижний min(r,(m-r))!
     * @param m
     * @param r
     * @return
     */
    @Override
    public BigInteger apply(Long m, Long r) {
        if(r > m) throw new IllegalArgumentException("the number m should be greater than r");
        Long maxDenominator = r > (m-r) ? r : m-r;
        Long minDenominator = r > (m-r) ? (m-r) : r;
      //  BigInteger numerator = factorial.calculateMultiplyElementsSeries(maxDenominator+1, m);
    //    BigInteger denominator = factorial.calculate(minDenominator);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<BigInteger> futureNumerator = executorService.submit(() -> factorial.calculateMultiplyElementsSeries(maxDenominator+1, m));
        Future<BigInteger> futureDenominator = executorService.submit(() -> factorial.calculate(minDenominator));

        try {
            BigInteger numerator = futureNumerator.get();
            BigInteger denominator = futureDenominator.get();
            executorService.shutdown();
            return numerator.divide(denominator);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
