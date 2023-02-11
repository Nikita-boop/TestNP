package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Router.router;

public class RouterRunner {
    public static void main(String[] args) {
        List<Path> list = new ArrayList<>();
        list.add(new Path("Москва", "Питер"));
        list.add(new Path("Москва", "Тюмень"));
        list.add(new Path("Питер", "Курск"));
        list.add(new Path("Курск", "Москва"));
        list.add(new Path("Курск", "Смоленск"));
        list.add(new Path("Смоленск", "Курск"));
        printRoute(router(list));

        list.clear();
        list.add(new Path("Москва", "Тюмень"));
        list.add(new Path("Тюмень", "Сочи"));
        list.add(new Path("Ростов-на-Дону", "Москва"));
        printRoute(router(list));
    }

    public static void printRoute(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("Маршрут не найден");
        } else {
            System.out.println(String.join(" -> ", list));
        }
    }
}
