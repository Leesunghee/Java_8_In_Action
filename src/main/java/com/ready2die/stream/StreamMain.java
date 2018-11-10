package com.ready2die.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamMain {


    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", false, 350, Dish.Type.OTHER),
                new Dish("season", false, 120, Dish.Type.OTHER),
                new Dish("pizza", false, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>(){

            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d1.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }


        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        System.out.println(threeHighCaloricDishNames);

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);

        List<String> names = new ArrayList<>();
        for (Dish d : menu) {
            names.add(d.getName());
        }


        names = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish d = iterator.next();
            names.add(d.getName());
        }

        List<Integer> collect = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());


        List<String> words = Arrays.asList("Java8", "Lambda", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());


        String[] arrayOfWords = {"Goodbye", "World"};
        System.out.println(Arrays.stream(arrayOfWords).collect(Collectors.toList()));

        List<String> uniqueCharacters = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(toList());

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
//        List<Integer[]> pairs = numbers1.stream()
//                .flatMap(i -> numbers2.stream()
//                        .map(j -> new int[]{i, j})
//                .collect(toList());


        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("the menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println("isHealthy = " + isHealthy);

        isHealthy = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
        System.out.println("isHealthy = " + isHealthy);

        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian)
                .findAny();

        dish.ifPresent(d -> System.out.println(d.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();

        firstSquareDivisibleByThree.ifPresent(n -> System.out.println(n));

        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }

        sum = numbers.stream().reduce(0, (a, b) -> a + b);

        System.out.println("sum = " + sum);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product = " + product);

        sum = numbers.stream().reduce(0, Integer::sum);

        Optional<Integer> sumOptional = numbers.stream().reduce((a, b) -> a + b);

        if (sumOptional.isPresent()) {
            System.out.println("sumOptional = " + sumOptional.get());
        }

        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);

        long menuCount = menu.stream().count();
        System.out.println("menuCount = " + menuCount);

    }





}
