package ru.nikzan.functional;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T, P> List<P> map(List<T> list, Function<T, P> function) {
        if (list == null) throw new IllegalArgumentException("Список не может быть null");
        if (function == null) throw new IllegalArgumentException("Функция не может быть null");

        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if (list == null) throw new IllegalArgumentException("Список не может быть null");
        if (predicate == null) throw new IllegalArgumentException("Предикат не может быть null");

        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> T reduce(List<T> list, BinaryOperator<T> operator) {
        if (operator == null) throw new IllegalArgumentException("Оператор не может быть null");
        if (list == null || list.isEmpty()) {
            return null;
        }

        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = operator.apply(result, list.get(i));
        }
        return result;
    }

    public static <T> T reduce(List<T> list, T identity, BinaryOperator<T> operator) {
        if (operator == null) throw new IllegalArgumentException("Оператор не может быть null");
        if (list == null || list.isEmpty()) {
            return identity;
        }

        T result = identity;
        for (T item : list) {
            result = operator.apply(result, item);
        }
        return result;
    }

    public static <T, P> P collect(List<T> list, Supplier<P> supplier, BiConsumer<P, T> accumulator) {
        if (list == null) throw new IllegalArgumentException("Список не может быть null");
        if (supplier == null) throw new IllegalArgumentException("Supplier не может быть null");
        if (accumulator == null) throw new IllegalArgumentException("Accumulator не может быть null");

        P result = supplier.get();
        for (T item : list) {
            accumulator.accept(result, item);
        }
        return result;
    }
}
