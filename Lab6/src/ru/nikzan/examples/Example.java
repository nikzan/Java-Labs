package ru.nikzan.examples;

import ru.nikzan.annotations.*;
import ru.nikzan.processors.Processor;

/**
 * Класс Example демонстрирует комплексное использование всех кастомных аннотаций.
 * Нужен для проверки корректности работы процессоров аннотаций через Reflection API.
 *
 * @see ru.nikzan.annotations.Two
 * @see ru.nikzan.annotations.Cache
 * @see ru.nikzan.annotations.Validate
 * @see ru.nikzan.annotations.ToString
 * @see ru.nikzan.annotations.Default
 * @see ru.nikzan.annotations.Invoke
 * @see ru.nikzan.processors.Processor
 */
@Two(first = "Example", second = 100)
@Cache({"memory", "disk"})
@Validate(value = {String.class, Integer.class})
@ToString(Mode.YES)
@Default(value = String.class)
public class Example {

    @ToString(Mode.NO)
    private String secret = "Hidden Data";

    @ToString(Mode.YES)
    @Default(value = Integer.class)
    public int publicData = 42;

    public boolean wasAutoMethodCalled = false;

    @Invoke
    public void autoMethod() {
        wasAutoMethodCalled = true;
        System.out.println("Метод был вызван автоматически!");
    }

    public void manualMethod() {
        System.out.println("Этот метод не должен вызываться автоматически.");
    }

    @Override
    public String toString() {
        return Processor.processToString(this);
    }
}
