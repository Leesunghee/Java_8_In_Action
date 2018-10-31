package com.ready2die;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleMain {


    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                                                new Apple("green", 155),
                                                new Apple("red", 120));

//        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
//        List<Apple> heavyApplas = filterApples(inventory, new AppleHeavyWeightPredicate());
//
//        List<Apple> readApples = filterApples(inventory, new ApplePredicate() {
//            public boolean test(Apple apple) {
//                return "red".equals(apple.getColor());
//            }
//        });

        List<Apple> redApples = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    }
}
