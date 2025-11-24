package ru.nikzan.functional;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T value);
}
