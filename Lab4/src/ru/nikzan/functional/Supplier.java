package ru.nikzan.functional;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}
