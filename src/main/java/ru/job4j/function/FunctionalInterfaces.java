package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (key, value) -> map.put(key, value);
        biConsumer.accept(1, "one");
        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");
        BiPredicate<Integer, String> biPredicate = (key, value) -> key % 2 == 0 || map.get(key).length() == 4;
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }
        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> values = supplier.get();
        for (String str : values) {
            System.out.println("value: " + str);
        }
        Consumer<String> consumer = (str) -> System.out.println(str);
        Function<String, String> function = (str) -> str.toUpperCase();
        for (String str : supplier.get()) {
            str = function.apply(str);
            consumer.accept(str);
        }
    }
}