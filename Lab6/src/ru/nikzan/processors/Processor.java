package ru.nikzan.processors;

import ru.nikzan.annotations.*;
import java.lang.reflect.*;
import java.util.Arrays;

public class Processor {

    /**
     * Формирует и выводит строковое представление объекта на основе аннотации @ToString.
     * Включает только те поля, которые имеют аннотацию ToString(Mode.YES) или не аннотированы вовсе.
     * Исключает поля с аннотацией ToString(Mode.NO).
     * Также не обрабатывает классы, если они помечены аннотацией ToString(Mode.NO).
     *
     * @param object объект для строкового представления
     * @return строковое представление объекта
     * @throws NullPointerException если передан null объект
     * @see ru.nikzan.annotations.Mode
     * @see ToString
     */
    public static String processToString(Object object) {
        if (object == null) throw new NullPointerException("Object cannot be null");
        Class<?> cls = object.getClass();
        
        // Проверка аннотации на уровне класса
        if (cls.isAnnotationPresent(ToString.class)) {
            ToString ann = cls.getAnnotation(ToString.class);
            if (ann.value() == Mode.NO) {
                return "Class excluded by @ToString(Mode.NO)";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cls.getSimpleName()).append("{");
        
        Field[] fields = cls.getDeclaredFields();
        boolean first = true;
        for (Field field : fields) {
            field.setAccessible(true);
            boolean include = true;
            
            if (field.isAnnotationPresent(ToString.class)) {
                ToString ann = field.getAnnotation(ToString.class);
                if (ann.value() == Mode.NO) {
                    include = false;
                }
            }
            
            if (include) {
                if (!first) sb.append(", ");
                try {
                    sb.append(field.getName()).append("=").append(field.get(object));
                    first = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Обрабатывает аннотацию @Invoke, вызывая помеченные методы.
     *
     * @param object объект, методы которого нужно обработать
     * @see Invoke
     */
    public static void processInvoke(Object object) {
        Class<?> cls = object.getClass();
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Обрабатывает аннотацию @Two, выводя её параметры.
     *
     * @param cls класс для проверки
     * @see Two
     */
    public static void processTwo(Class<?> cls) {
        if (cls.isAnnotationPresent(Two.class)) {
            Two ann = cls.getAnnotation(Two.class);
            System.out.println("Two: first=" + ann.first() + ", second=" + ann.second());
        }
    }

    /**
     * Обрабатывает аннотацию @Cache, выводя список кешируемых областей.
     *
     * @param cls класс для проверки
     * @see Cache
     */
    public static void processCache(Class<?> cls) {
        if (cls.isAnnotationPresent(Cache.class)) {
            Cache ann = cls.getAnnotation(Cache.class);
            System.out.println("Cache: " + Arrays.toString(ann.value()));
        }
    }

    /**
     * Обрабатывает аннотацию @Validate, проверяя указанные классы.
     * Выбрасывает исключение, если массив классов пустой.
     *
     * @param cls класс для проверки
     * @throws IllegalArgumentException если массив классов пустой
     * @see Validate
     */
    public static void processValidate(Class<?> cls) {
        if (cls.isAnnotationPresent(Validate.class)) {
            Validate ann = cls.getAnnotation(Validate.class);
            Class<?>[] classes = ann.value();
            
            if (classes.length == 0) {
                throw new IllegalArgumentException("Validate annotation must have at least one class");
            }
            
            System.out.println("Validate: " + Arrays.toString(classes));
        }
    }

    /**
     * Обрабатывает аннотацию @Default, выводя класс по умолчанию.
     *
     * @param cls класс для проверки
     * @see Default
     */
    public static void processDefault(Class<?> cls) {
        if (cls.isAnnotationPresent(Default.class)) {
            Default ann = cls.getAnnotation(Default.class);
            System.out.println("Default (Class): " + ann.value().getName());
        }
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Default.class)) {
                Default ann = field.getAnnotation(Default.class);
                System.out.println("Default (Field " + field.getName() + "): " + ann.value().getName());
            }
        }
    }
}
