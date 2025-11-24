package ru.nikzan.functional;

@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);
}
