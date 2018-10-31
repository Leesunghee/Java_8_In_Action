package com.ready2die;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T e : list) {
            if(predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 155),
                new Apple("red", 120));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Apple> redApples = filter(inventory, (Apple apple) -> ("red").equals(apple.getColor()));

        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
    }
}
