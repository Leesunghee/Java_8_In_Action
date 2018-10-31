package com.ready2die;

public class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
