package com.ready2die;

import java.util.ArrayList;
import java.util.List;

public class AppleMain {


    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ((flag && color.equals(apple.getColor())) ||
                (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Apple apple = new Apple("green");
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(apple);

        List<Apple> greenApples = filterApples(inventory, "green", 0, true);
        List<Apple> heavyApplas = filterApples(inventory, "", 150, false);

    }
}
