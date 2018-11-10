package com.ready2die.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamPractice {

    public static void main(String[] args) {
        //given
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());


        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        Set<String> cities2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());

        List<Trader> traders = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Campbrige"))
                .map(transaction -> transaction.getTrader())
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        String traderStr2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());

        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambride"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Optional<Integer> highestValue = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);

        Optional<Integer> smallestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);

        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() > t1.getValue() ? t1 : t2);

        smallestTransaction = transactions.stream()
                .min(comparing(Transaction::getValue));


    }
}
