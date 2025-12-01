package ru.nikzan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания кешируемых областей.
 * Применяется только к типам.
 * Имеет необязательное свойство value типа String[] со значением по умолчанию - пустой массив.
 *
 * @see ru.nikzan.processors.CacheProcessor#process(Class)
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    String[] value() default {};
}
