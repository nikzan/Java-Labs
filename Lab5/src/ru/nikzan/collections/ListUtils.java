package ru.nikzan.collections;

import java.util.List;
import java.util.Iterator;

public class ListUtils {
    public static <T> void removeElements(List<T> list, T element) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (current.equals(element)) {
                iterator.remove();
            }
        }
    }
}
