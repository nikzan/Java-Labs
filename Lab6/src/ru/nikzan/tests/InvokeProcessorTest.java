package ru.nikzan.tests;

import ru.nikzan.examples.Example;
import ru.nikzan.processors.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit тесты для проверки корректности работы аннотации @Invoke.
 * Использует Reflection API для поиска методов с аннотацией.
 *
 * @see ru.nikzan.annotations.Invoke
 * @see ru.nikzan.processors.Processor#processInvoke(Object)
 */
public class InvokeProcessorTest {
    private Example example;

    @BeforeEach
    public void setUp() {
        example = new Example();
    }

    /**
     * Тест проверяет, что методы с аннотацией @Invoke вызываются автоматически.
     * Проверяет побочный эффект: изменение флага wasAutoMethodCalled.
     */
    @Test
    public void testInvokeMethodsAreCalled() {
        assertFalse(example.wasAutoMethodCalled, "Флаг должен быть false до обработки");
        Processor.processInvoke(example);
        assertTrue(example.wasAutoMethodCalled, "Флаг должен быть true после вызова autoMethod()");
    }

    /**
     * Тест проверяет, что обработка не выбрасывает исключений.
     */
    @Test
    public void testInvokeProcessorDoesNotThrowException() {
        assertDoesNotThrow(() -> Processor.processInvoke(example),
                "Обработчик не должен выбрасывать исключений");
    }

    /**
     * Тест проверяет, что вызванные методы корректно изменяют состояние объекта.
     */
    @Test
    public void testInvokeMethodsSideEffects() {
        boolean initialFlag = example.wasAutoMethodCalled;
        Processor.processInvoke(example);
        assertNotEquals(initialFlag, example.wasAutoMethodCalled, 
                "Флаг должен измениться после обработки");
    }

    /**
     * Тест проверяет, что метод выполняется без исключений
     */
    @Test
    public void testInvokeMethodExecutesWithoutException() throws Exception {
        java.lang.reflect.Method[] methods = example.getClass().getDeclaredMethods();
        boolean foundInvokeMethod = false;
        
        for (java.lang.reflect.Method method : methods) {
            if (method.isAnnotationPresent(ru.nikzan.annotations.Invoke.class)) {
                foundInvokeMethod = true;
                method.setAccessible(true);
                
                assertDoesNotThrow(() -> {
                    try {
                        method.invoke(example);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }, "Метод с @Invoke должен выполняться без исключений");
            }
        }
        
        assertTrue(foundInvokeMethod, "Должен быть найден хотя бы один метод с @Invoke");
    }
}
