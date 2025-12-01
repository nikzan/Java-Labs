package ru.nikzan.main;

import ru.nikzan.examples.Example;
import ru.nikzan.processors.Processor;

import java.util.Scanner;

/**
 * Главный класс программы для демонстрации работы аннотаций.
 * Предоставляет интерактивное меню для выбора задания.
 * 
 */
public class Main {
    private final Scanner scanner;

    /**
     * Создает новый экземпляр Main.
     */
    public Main() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Точка входа в программу.
     * 
     * @param args номер задания
     */
    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * Запускает меню выбора заданий.
     */
    public void run() {
        System.out.println("Лабораторная работа #6");

        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("1 - Задание 1-1: @Invoke");
            System.out.println("2 - Задание 1-2: @Default");
            System.out.println("3 - Задание 1-3: @ToString");
            System.out.println("4 - Задание 1-4: @Validate");
            System.out.println("5 - Задание 1-5: @Two");
            System.out.println("6 - Задание 1-6: @Cache");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choiceStr = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Введите число.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            try {
                switch (choice) {
                    case 1:
                        demonstrateInvoke();
                        break;
                    case 2:
                        demonstrateDefault();
                        break;
                    case 3:
                        demonstrateToString();
                        break;
                    case 4:
                        demonstrateValidate();
                        break;
                    case 5:
                        demonstrateTwo();
                        break;
                    case 6:
                        demonstrateCache();
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    /**
     * Демонстрирует работу @Invoke.
     * Создает объект с аннотированными методами и автоматически вызывает их.
     * 
     * @throws Exception если произошла ошибка при обработке
     */
    private void demonstrateInvoke() throws Exception {
        System.out.println("\nЗадание 1-1: @Invoke");
        System.out.println("Создается объект Example с методом autoMethod, помеченным @Invoke.");
        
        Example example = new Example();
        System.out.println("До обработки wasAutoMethodCalled: " + example.wasAutoMethodCalled);
        
        System.out.println("\nВызов Processor.processInvoke()...\n");
        Processor.processInvoke(example);
        
        System.out.println("\nПосле обработки wasAutoMethodCalled: " + example.wasAutoMethodCalled);
    }

    /**
     * Демонстрирует работу @Default.
     * Показывает класс по умолчанию, указанный в аннотации.
     */
    private void demonstrateDefault() {
        System.out.println("\nЗадание 1-2: @Default");
        System.out.println("Класс Example аннотирован @Default(String.class).");
        System.out.println("Поле 'publicData' аннотировано @Default(Integer.class).\n");

        Processor.processDefault(Example.class);
    }

    /**
     * Демонстрирует работу @ToString.
     * Генерирует строковое представление объекта с учетом аннотаций.
     * 
     * @throws Exception если произошла ошибка при обработке
     */
    private void demonstrateToString() throws Exception {
        System.out.println("\nЗадание 1-3: @ToString");
        System.out.println("Класс Example содержит поля: secret (Mode.NO), publicData (Mode.YES).");
        
        Example example = new Example();
        
        System.out.println("Обычный toString() (переопределенный через Processor): " + example.toString());
        System.out.println("Прямой вызов Processor.processToString(): " + Processor.processToString(example));
    }

    /**
     * Демонстрирует работу @Validate.
     * Проверяет валидацию классов.
     */
    private void demonstrateValidate() {
        System.out.println("\nЗадание 1-4: Аннотация @Validate");
        System.out.println("Example аннотирован @Validate({String.class, Integer.class}).\n");

        Processor.processValidate(Example.class);
    }

    /**
     * Демонстрирует работу @Two.
     * Показывает два обязательных свойства: строку и число.
     */
    private void demonstrateTwo() {
        System.out.println("\nЗадание 1-5: Аннотация @Two");
        System.out.println("Example аннотирован @Two(first=\"Combined Example\", second=100).\n");

        Processor.processTwo(Example.class);
    }

    /**
     * Демонстрирует работу @Cache.
     * Показывает список кешируемых областей.
     */
    private void demonstrateCache() {
        System.out.println("\nЗадание 1-6: Аннотация @Cache");
        System.out.println("Example аннотирован @Cache({\"memory\", \"disk\"}).\n");

        Processor.processCache(Example.class);
    }
}
