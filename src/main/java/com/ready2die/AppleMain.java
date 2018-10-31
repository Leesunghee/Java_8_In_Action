package com.ready2die;

import java.util.ArrayList;
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

        Apple apple = new Apple("green");
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(apple);

        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        List<Apple> heavyApplas = filterApples(inventory, new AppleHeavyWeightPredicate());

    }
}
