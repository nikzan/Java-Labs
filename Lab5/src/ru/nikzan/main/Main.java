package ru.nikzan.main;

import ru.nikzan.cats.*;
import ru.nikzan.collections.*;
import ru.nikzan.fractions.*;
import ru.nikzan.geometry.Point;
import ru.nikzan.geometry.Polyline;
import ru.nikzan.streams.StreamTasks;

import java.io.IOException;
import java.util.*;

public class Main {
    private final Scanner scanner;

    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        System.out.println("Лабораторная работа №5: Шаблоны, Коллекции, Стримы");
        System.out.println("===================================================");

        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("1 - Задание 1: Шаблоны (Дробь + Кэширование)");
            System.out.println("2 - Задание 2: Структурные шаблоны (Кот + Декоратор)");
            System.out.println("3 - Задание 3: Список (Удаление элементов)");
            System.out.println("4 - Задание 4: Map (Генерация логинов)");
            System.out.println("5 - Задание 5: Set (Звонкие согласные)");
            System.out.println("6 - Задание 6: Очередь (Реверс)");
            System.out.println("7 - Задание 7: Стримы (Ломаная и Группировка людей)");
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
                    case 1: demoTask1(); break;
                    case 2: demoTask2(); break;
                    case 3: demoTask3(); break;
                    case 4: demoTask4(); break;
                    case 5: demoTask5(); break;
                    case 6: demoTask6(); break;
                    case 7: demoTask7(); break;
                    default: System.out.println("Неверный выбор.");
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка при выполнении задания: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void demoTask1() {
        System.out.println("\n--- Задание 1: Дробь и Кэширование ---");
        Fraction fr = new Fraction(1, 2);
        FractionInterface cachedFr = new CachedFraction(fr);

        System.out.println("Дробь: " + cachedFr);
        System.out.println("Получаем значение (1-й раз): " + cachedFr.getDecimalValue());
        System.out.println("Получаем значение (2-й раз): " + cachedFr.getDecimalValue());
        
        System.out.println("Меняем числитель на 3...");
        cachedFr.setNum(3);
        System.out.println("Получаем значение (после изменения): " + cachedFr.getDecimalValue());
        System.out.println("Получаем значение (еще раз): " + cachedFr.getDecimalValue());
    }

    private void demoTask2() {
        System.out.println("\n--- Задание 2: Кот и Подсчет мяуканий ---");
        Cat cat = new Cat("Барсик");
        MeowCounter counter = new MeowCounter(cat);

        System.out.println("Отправляем кота (в обертке) в метод meowsCare...");
        Funs.meowsCare(counter);

        System.out.println("\nКот мяукал " + counter.getCount() + " раз.");
    }

    private void demoTask3() {
        System.out.println("\n--- Задание 3: Удаление из списка ---");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 2, 5));
        System.out.println("Исходный список: " + list);
        
        System.out.print("Введите число для удаления: ");
        int toRemove = Integer.parseInt(scanner.nextLine());
        
        ListUtils.removeElements(list, toRemove);
        System.out.println("Результат: " + list);
    }

    private void demoTask4() {
        System.out.println("\n--- Задание 4: Генерация логинов (из students.txt) ---");
        MapUtils.generateLogins("Lab5/students.txt");
    }

    private void demoTask5() {
        System.out.println("\n--- Задание 5: Звонкие согласные (из text.txt) ---");
        SetUtils.printVoicedConsonants("Lab5/text.txt");
    }

    private void demoTask6() {
        System.out.println("\n--- Задание 6: Реверс очереди ---");
        Queue<String> q1 = new LinkedList<>(Arrays.asList("Первый", "Второй", "Третий"));
        Queue<String> q2 = new LinkedList<>();
        
        System.out.println("Очередь 1 (исходная): " + q1);
        System.out.println("Очередь 2 (пустая): " + q2);
        
        QueueUtils.reverseQueue(q1, q2);
        
        System.out.println("После реверса:");
        System.out.println("Очередь 1: " + q1);
        System.out.println("Очередь 2: " + q2);
    }

    private void demoTask7() {
        System.out.println("\n--- Задание 7: Стримы ---");
        
        System.out.println("7.1 Обработка точек:");
        List<Point> points = Arrays.asList(
            new Point(1, -2),
            new Point(1, -2), // Дубликат
            new Point(3, 4),
            new Point(1, 5),  // Одинаковый X с первым
            new Point(2, -3)
        );
        System.out.println("Исходные точки: " + points);
        Polyline polyline = StreamTasks.processPoints(points);
        System.out.println("Результат (Ломаная): " + polyline);

        System.out.println("\n7.2 Группировка людей (из people.txt):");
        try {
            Map<Integer, List<String>> grouped = StreamTasks.processPeople("Lab5/people.txt");
            System.out.println(grouped);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
