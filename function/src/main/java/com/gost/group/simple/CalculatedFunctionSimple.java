package com.gost.group.simple;

import com.gost.group.Factorial;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.BiFunction;


public class CalculatedFunctionSimple implements BiFunction<Long, Long, BigInteger> {

    private Factorial factorial;
    private Map<String, BigInteger> cacheCalcFactorial;

    public CalculatedFunctionSimple() {
    }

    public CalculatedFunctionSimple(Factorial factorial) {
        this.factorial = factorial;
    }

    @Override
    public BigInteger apply(Long m, Long r) {
        if(r > m) throw new IllegalArgumentException("the number m should be greater than r");

        BigInteger mFactorial = factorial.calculate(m);
        BigInteger rFactorial = factorial.calculate(r);
        BigInteger differentFactorial = factorial.calculate(m-r);
        return calculatedByFormula(mFactorial, rFactorial, differentFactorial);
    }


    protected BigInteger calculatedByFormula(BigInteger mFactorial, BigInteger rFactorial, BigInteger differentFactorial) {
        BigInteger multiple = rFactorial.multiply(differentFactorial);
        return mFactorial.divide(multiple);
    }
}
