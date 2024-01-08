package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("torgunivan@gmail.com", "Torgun I.V.");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        for (String mail : map.keySet()) {
            System.out.println(mail);
        }
    }
}
