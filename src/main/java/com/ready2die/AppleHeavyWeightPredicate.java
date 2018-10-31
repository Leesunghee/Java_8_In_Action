package com.ready2die;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {

        return apple.getWeight() > 150;
    }
}
