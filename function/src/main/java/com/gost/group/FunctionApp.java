package com.gost.group;

import com.gost.group.simple.CalculatedFunctionSimple;

import java.util.function.BiFunction;

public class FunctionApp {

    public static void main(String[] args) {
        long m=50000, r=20000;
        if(args!=null && args.length >= 2)  {
            m = Long.valueOf(args[0]);
            r = Long.valueOf(args[1]);
        }
        BiFunction functionCalcTwoNumber = new CalculatedFunction(new ParallelStreamFactorial());
        System.out.println("CalculatedFunction =" + functionCalcTwoNumber.apply(m,r));
    }
}


