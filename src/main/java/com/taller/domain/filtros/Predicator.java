package com.taller.domain.filtros;

import java.util.function.Predicate;

public class Predicator implements Predicate<Integer> {
    @Override
    public boolean test(Integer year) {
        return year > 2000;
    }
}