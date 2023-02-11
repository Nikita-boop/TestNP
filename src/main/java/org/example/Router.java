package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Router {
    private static final Set<String> allCities = new HashSet<>();
    private static final List<String> visitedCities = new ArrayList<>();

    // Основной метод в него передает список возможных путей, из которых нужно построить маршрут
    // В этом методе определяется отправная точка и выбирается первый путь по которому начинается следование по маршруту
    public static List<String> router(List<Path> initialList) {
        List<Path> modifyList = new ArrayList<>(initialList);
        fillAllCities(modifyList);
        for (int i = 0; i < modifyList.size(); i++) {
            visitedCities.add(modifyList.get(i).getFrom());
            Path newRoute = modifyList.get(i);
            modifyList.remove(i);
            if (routeBuilder(newRoute, modifyList)) {
                break;
            }
            modifyList.add(i, newRoute);
            visitedCities.remove(0);
        }
        List<String> completeRoute = new ArrayList<>(visitedCities);
        visitedCities.clear();
        allCities.clear();
        return completeRoute;
    }

    // Основной метод для поиска маршрута
    // выполняется рекурсивно, сложность алгоритма O(n!)
    // выход из рекурсии осуществляется или если все города посещены или если по этому маршруту нет возможности их посетить
    // принцип работы добавляем в маршрут точку прибытия из предыдущего пути, и проверяем есть ли возможность из этой точки
    // прибытия еще куда-нибудь уехать, если да удаляем вновь найденный путь и вызываем рекурсивный метод снова
    // если ничего не получилось то возвращаем путь обратно в список возможных путей
    // если не получилось в этом случае проложить маршрут удаляем добавленный город и выходим из метода
    private static boolean routeBuilder(Path currentPath, List<Path> pathList) {
        visitedCities.add(currentPath.getTo());
        Set<String> visitedSet = new HashSet<>(visitedCities);
        if (visitedSet.equals(allCities)) {
            return true;
        }
        for (int i = 0; i < pathList.size(); i++) {
            if (currentPath.getTo().equals(pathList.get(i).getFrom())) {
                Path newRoute = pathList.get(i);
                pathList.remove(i);
                if (routeBuilder(newRoute, pathList)) {
                    return true;
                }
                pathList.add(i, newRoute);
            }
        }
        visitedCities.remove(visitedCities.size() - 1);
        return false;
    }

    // Создание уникального списка всех городов которые нужно посетить
    private static void fillAllCities(List<Path> list) {
        for(Path path : list) {
            allCities.add(path.getFrom());
            allCities.add(path.getTo());
        }
    }
}