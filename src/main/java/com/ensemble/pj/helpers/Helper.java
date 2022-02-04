package com.ensemble.pj.helpers;

import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;

public class Helper {

    public static class Box {
        double num = 0;
        long denom = 0;
    }

    public static <T> Collector<T,?,Double> averagingWeighted(ToDoubleFunction<T> valueFunction, ToDoubleFunction<T> weightFunction) {
        return Collector.of(
                Box::new,
                (b, e) -> {
                    b.num += valueFunction.applyAsDouble(e) * weightFunction.applyAsDouble(e);
                    b.denom += weightFunction.applyAsDouble(e);
                },
                (b1, b2) -> { b1.num += b2.num; b1.denom += b2.denom; return b1; },
                b -> b.num / b.denom
        );
    }
}
