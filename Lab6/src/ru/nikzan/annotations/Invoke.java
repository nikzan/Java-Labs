package ru.nikzan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для автоматического вызова методов.
 * Применяется только к методам.
 * Доступна во время выполнения программы (RUNTIME).
 *
 * @see ru.nikzan.processors.InvokeProcessor#process(Object)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
}
