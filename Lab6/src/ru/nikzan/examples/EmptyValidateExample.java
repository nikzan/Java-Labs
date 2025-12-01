package ru.nikzan.examples;

import ru.nikzan.annotations.Validate;

/**
 * Пример класса с пустой аннотацией @Validate для тестирования исключения.
 * Используется для проверки того, что обработчик выбрасывает IllegalArgumentException.
 *
 * @see ru.nikzan.annotations.Validate
 * @see ru.nikzan.processors.Processor#processValidate(Class)
 */
@Validate({})
public class EmptyValidateExample {
    private String data = "Empty validation test";
}
