package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("qwer@qw.com", "Star Nik");
        map.put("qwe@q.com", "Star Nik");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
