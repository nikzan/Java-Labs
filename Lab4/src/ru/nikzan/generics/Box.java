package ru.nikzan.generics;

public class Box<T> {
    private T item;

    public Box() {
        this.item = null;
    }

    public void put(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя помещать null в коробку");
        }

        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена!");
        }

        this.item = item;
    }

    public T take() {
        T result = this.item;
        this.item = null;
        return result;
    }

    public boolean isFull() {
        return this.item != null;
    }

    public T peek() {
        return this.item;
    }

    @Override
    public String toString() {
        if (item == null) {
            return "Коробка [пусто]";
        }
        return "Коробка [" + item + "]";
    }
}
