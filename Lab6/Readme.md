# Лабораторная работа №6

## Содержание
1. [Структура проекта](#структура-проекта)
2. [Как работает основной код в Main](#как-работает-основной-код-в-main)
3. [Задание 1-1 — Аннотация @Invoke](#задание-1-1-аннотация-invoke)
4. [Задание 1-2 — Аннотация @Default](#задание-1-2-аннотация-default)
5. [Задание 1-3 — Аннотация @ToString](#задание-1-3-аннотация-tostring)
6. [Задание 1-4 — Аннотация @Validate](#задание-1-4-аннотация-validate)
7. [Задание 1-5 — Аннотация @Two](#задание-1-5-аннотация-two)
8. [Задание 1-6 — Аннотация @Cache](#задание-1-6-аннотация-cache)
9. [Задание 2-2 — Тестирование @Invoke](#задание-2-2-тестирование-invoke)
10. [Задание 2-4 — Тестирование @Validate](#задание-2-4-тестирование-validate)

## Структура проекта
Проект посвящен изучению пользовательских аннотаций, Reflection API и unit-тестированию.
- `Main` — главный класс с интерактивным меню для демонстрации всех заданий.
- `TestRunner` — класс для запуска тестов и проверки корректности решений.
- **Аннотации** (`ru.nikzan.annotations`): `Invoke`, `Default`, `ToString`, `Validate`, `Two`, `Cache`, `Mode`.
- **Процессоры** (`ru.nikzan.processors`): обработчики для каждой аннотации через Reflection API.
- **Примеры** (`ru.nikzan.examples`): классы, демонстрирующие использование аннотаций.
- **Тесты** (`ru.nikzan.main`): JUnit 5 тесты для `@Invoke` и `@Validate`.

## Как работает основной код в Main
Класс `Main` предоставляет консольное меню, позволяющее выбрать задание (1-6) для демонстрации.
При запуске программы выводится список доступных опций:
1. Демонстрация @Invoke — автоматический вызов методов
2. Демонстрация @Default — указание класса по умолчанию
3. Демонстрация @ToString — генерация строкового представления
4. Демонстрация @Validate — валидация списка классов
5. Демонстрация @Two — хранение двух значений
6. Демонстрация @Cache — управление кешируемыми областями

Каждое задание включает создание примера объекта, обработку через соответствующий процессор и вывод результатов.

## Задание 1-1 — Аннотация @Invoke
Реализация: пакет `ru.nikzan.annotations`, класс `Invoke`.
### Назначение
Автоматический вызов методов, отмеченных аннотацией `@Invoke`, через Reflection API.
### Характеристики
- **Target**: `ElementType.METHOD` — применяется только к методам
- **Retention**: `RetentionPolicy.RUNTIME` — доступна во время выполнения
- **Свойства**: нет
### Пример использования
```java
public class InvokeExample {
    @Invoke
    public void setFlag() {
        this.flag = true;
    }
    
    @Invoke
    public void incrementCounter() {
        this.counter++;
    }
}
```
### Обработчик
`InvokeProcessor.process(Object obj)` — находит все методы с `@Invoke` и вызывает их автоматически.

## Задание 1-2 — Аннотация @Default
Реализация: пакет `ru.nikzan.annotations`, класс `Default`.
### Назначение
Указание класса по умолчанию для типа или поля.
### Характеристики
- **Target**: `ElementType.TYPE`, `ElementType.FIELD`
- **Retention**: `RetentionPolicy.RUNTIME`
- **Свойства**: обязательное `value` типа `Class<?>`
### Пример использования
```java
@Default(String.class)
public class DefaultExample {
    @Default(Integer.class)
    private Object value;
}
```
### Обработчик
`DefaultProcessor.process(Class<?> clazz)` — выводит имя класса по умолчанию для типа и полей.

## Задание 1-3 — Аннотация @ToString
Реализация: пакет `ru.nikzan.annotations`, классы `ToString` и `Mode`.
### Назначение
Генерация строкового представления объекта с выборочным включением полей.
### Характеристики
- **Target**: `ElementType.TYPE`, `ElementType.FIELD`
- **Retention**: `RetentionPolicy.RUNTIME`
- **Свойства**: необязательное `value` типа `Mode` (YES/NO), по умолчанию `Mode.YES`
### Пример использования
```java
@ToString
public class Person {
    @ToString(Mode.YES)
    private String name;
    
    @ToString(Mode.NO)
    private String password;  // не будет включен в toString
}
```
### Обработчик
`ToStringProcessor.process(Object obj)` — формирует строку, включая только поля с `Mode.YES`.

## Задание 1-4 — Аннотация @Validate
Реализация: пакет `ru.nikzan.annotations`, класс `Validate`.
### Назначение
Валидация списка классов, указанных в аннотации.
### Характеристики
- **Target**: `ElementType.TYPE`, `ElementType.ANNOTATION_TYPE`
- **Retention**: `RetentionPolicy.RUNTIME`
- **Свойства**: обязательное `value` типа `Class<?>[]`
### Пример использования
```java
@Validate({String.class, Integer.class, Double.class})
public class ValidateExample {
    // ...
}
```
### Обработчик
`ValidateProcessor.process(Class<?> clazz)` — выводит список классов или выбрасывает `IllegalArgumentException` для пустого массива.

## Задание 1-5 — Аннотация @Two
Реализация: пакет `ru.nikzan.annotations`, класс `Two`.
### Назначение
Хранение двух обязательных значений: строки и числа.
### Характеристики
- **Target**: `ElementType.TYPE`
- **Retention**: `RetentionPolicy.RUNTIME`
- **Свойства**: `first` (String), `second` (int)
### Пример использования
```java
@Two(first = "Example", second = 42)
public class TwoExample {
    // ...
}
```
### Обработчик
`TwoProcessor.process(Class<?> clazz)` — считывает и выводит значения `first` и `second`.

## Задание 1-6 — Аннотация @Cache
Реализация: пакет `ru.nikzan.annotations`, класс `Cache`.
### Назначение
Указание кешируемых областей для класса.
### Характеристики
- **Target**: `ElementType.TYPE`
- **Retention**: `RetentionPolicy.RUNTIME`
- **Свойства**: необязательное `value` типа `String[]`, по умолчанию `{}`
### Пример использования
```java
@Cache({"users", "products", "sessions"})
public class CacheExample {
    // ...
}

@Cache  // пустой массив по умолчанию
public class EmptyCacheExample {
    // ...
}
```
### Обработчик
`CacheProcessor.process(Class<?> clazz)` — выводит список кешируемых областей или сообщение о пустом списке.

## Задание 2-2 — Тестирование @Invoke
Реализация: класс `ru.nikzan.tests.InvokeProcessorTest`.
### Назначение
Проверка корректности автоматического вызова методов с аннотацией `@Invoke` через JUnit 5.
### Тесты
- `testInvokeMethodsAreCalled()` — проверяет, что методы вызываются и изменяют флаг `wasAutoMethodCalled`
- `testInvokeProcessorDoesNotThrowException()` — проверяет отсутствие исключений при обработке
- `testInvokeMethodsSideEffects()` — проверяет побочные эффекты (изменение состояния объекта)
- `testInvokeMethodExecutesWithoutException()` — использует Reflection API для прямого вызова метода с `@Invoke`
### Использование
Тест использует `@BeforeEach` для создания нового экземпляра `Example` перед каждым тестом.

## Задание 2-4 — Тестирование @Validate
Реализация: класс `ru.nikzan.tests.ValidateProcessorTest`.
### Назначение
Проверка корректности валидации классов с аннотацией `@Validate`.
### Тесты
- `testValidateClassesAreExtractedCorrectly()` — проверяет корректное извлечение классов из аннотации
- `testValidateThrowsExceptionForEmptyArray()` — использует `assertThrows` для проверки исключения при пустом массиве
- `testValidateAnnotationPresent()` — проверяет наличие аннотации и содержимое массива классов
- `testEmptyValidateHasEmptyArray()` — проверяет класс `EmptyValidateExample` с пустым массивом
### Использование
Тесты используют `assertThrows` (JUnit 5) для проверки выброса `IllegalArgumentException` при пустом массиве классов.
