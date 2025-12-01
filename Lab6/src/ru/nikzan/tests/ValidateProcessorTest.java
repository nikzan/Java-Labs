package ru.nikzan.tests;

import ru.nikzan.examples.Example;
import ru.nikzan.examples.EmptyValidateExample;
import ru.nikzan.processors.Processor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit тесты для проверки корректности работы аннотации @Validate.
 *
 * @see ru.nikzan.annotations.Validate
 * @see ru.nikzan.processors.Processor#processValidate(Class)
 */
public class ValidateProcessorTest {

    /**
     * Тест проверяет, что обработчик корректно извлекает список классов из аннотации @Validate.
     */
    @Test
    public void testValidateClassesAreExtractedCorrectly() {
        assertDoesNotThrow(() -> Processor.processValidate(Example.class),
                "Обработчик должен корректно обрабатывать непустой массив классов");
    }

    /**
     * Тест проверяет, что при передаче пустого массива в @Validate
     * выбрасывается исключение IllegalArgumentException.
     */
    @Test
    public void testValidateThrowsExceptionForEmptyArray() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Processor.processValidate(EmptyValidateExample.class),
                "Должно быть выброшено IllegalArgumentException для пустого массива"
        );

        assertTrue(exception.getMessage().contains("at least one class"),
                "Сообщение об ошибке должно содержать информацию о необходимости хотя бы одного класса");
    }

    /**
     * Тест проверяет, что аннотация @Validate присутствует на классе Example
     */
    @Test
    public void testValidateAnnotationPresent() {
        assertTrue(Example.class.isAnnotationPresent(ru.nikzan.annotations.Validate.class),
                "Класс Example должен быть аннотирован @Validate");

        ru.nikzan.annotations.Validate annotation = 
                Example.class.getAnnotation(ru.nikzan.annotations.Validate.class);
        
        assertNotNull(annotation, "Аннотация @Validate не должна быть null");
        
        Class<?>[] classes = annotation.value();
        assertEquals(2, classes.length, 
                "Массив классов должен содержать 2 элемента");
        assertEquals(String.class, classes[0], 
                "Первый элемент должен быть String.class");
        assertEquals(Integer.class, classes[1], 
                "Второй элемент должен быть Integer.class");
    }

    /**
     * Тест проверяет, что EmptyValidateExample имеет пустой массив в @Validate.
     */
    @Test
    public void testEmptyValidateHasEmptyArray() {
        assertTrue(EmptyValidateExample.class.isAnnotationPresent(ru.nikzan.annotations.Validate.class),
                "EmptyValidateExample должен быть аннотирован @Validate");

        ru.nikzan.annotations.Validate annotation = 
                EmptyValidateExample.class.getAnnotation(ru.nikzan.annotations.Validate.class);
        
        Class<?>[] classes = annotation.value();
        assertEquals(0, classes.length, 
                "Массив классов должен быть пустым");
    }
}
