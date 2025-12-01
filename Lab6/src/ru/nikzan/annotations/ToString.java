package ru.nikzan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для управления представлением объекта.
 * Применяется к типам и полям.
 * Имеет необязательное свойство value со значением по умолчанию YES.
 *
 * @see ru.nikzan.processors.ToStringProcessor#process(Object)
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    Mode value() default Mode.YES;
}
