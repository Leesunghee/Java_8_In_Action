package com.ready2die;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
