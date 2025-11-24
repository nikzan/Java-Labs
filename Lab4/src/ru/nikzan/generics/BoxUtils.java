package ru.nikzan.generics;

public class BoxUtils {
    
    public static double findMax(Box<? extends Number>... boxes) {
        if (boxes == null || boxes.length == 0) {
            throw new IllegalArgumentException("Массив коробок не может быть пустым");
        }

        Double max = null;
        for (Box<? extends Number> box : boxes) {
            if (box.isFull()) {
                double value = box.peek().doubleValue();
                if (max == null || value > max) {
                    max = value;
                }
            }
        }

        if (max == null) {
            throw new IllegalArgumentException("Все коробки пусты");
        }

        return max;
    }
}
