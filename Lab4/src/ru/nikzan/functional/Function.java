package ru.nikzan.functional;

@FunctionalInterface
public interface Function<T, P> {
    P apply(T value);
}
