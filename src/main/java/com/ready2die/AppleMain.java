package com.ready2die;

import java.util.ArrayList;
import java.util.List;

public class AppleMain {


    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight)  {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Apple apple = new Apple("green");
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(apple);

        List<Apple> greenApple = filterApplesByColor(inventory, "green");
        List<Apple> redApple = filterApplesByColor(inventory, "red");

    }
}
