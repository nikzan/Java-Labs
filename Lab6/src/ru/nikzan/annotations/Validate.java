package ru.nikzan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для валидации списка классов.
 * Применяется к типам и аннотациям.
 * Имеет обязательное свойство value типа Class[].
 *
 * @see ru.nikzan.processors.ValidateProcessor#process(Class)
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    Class<?>[] value();
}
