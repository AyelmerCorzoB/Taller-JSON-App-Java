package com.taller.domain.ExprecionesLambda;

import java.util.function.Predicate;

public class Predicator implements Predicate<Integer> {
    
    @Override
    public boolean test(Integer year) {
        return year > 2000;
    }

    public boolean test2(Integer pg){
        return pg > 20; 
    }
}