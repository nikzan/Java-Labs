package ru.nikzan.main;

import ru.nikzan.weapons.*;
import ru.nikzan.people.*;
import ru.nikzan.geometry.Point;
import ru.nikzan.phonebook.PhoneBook;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("=== АВТОМАТИЧЕСКОЕ ТЕСТИРОВАНИЕ LAB3 ===\n");

        test1A();
        test1B();
        test2();
        test3();
        test4();
        test5();
        test6();
        test8();

        System.out.println("\n=== ВСЕ ТЕСТЫ ЗАВЕРШЕНЫ ===");
    }

    private static void test1A() {
        System.out.println("--- Тест 1A: Gun с перезарядкой ---");
        Gun gun = new Gun(5);
        System.out.println(gun);

        // Стрельба с полным магазином
        gun.reload(5);
        gun.shoot();
        gun.shoot();
        gun.shoot();

        // Стрельба без патронов
        gun.shoot();
        gun.shoot();

        // Перезарядка
        gun.reload(2);
        gun.shoot();
        gun.shoot();

        // Стрельба пустым пистолетом
        gun.shoot();

        // Разрядка
        gun.reload(3);
        int unloaded = gun.unload();
        System.out.println("Разряжено патронов: " + unloaded);
        gun.shoot();

        System.out.println();
    }

    private static void test1B() {
        System.out.println("--- Тест 1B: Name с валидацией ---");
        
        Name n1 = new Name("Клеопатра");
        System.out.println(n1);

        Name n2 = new Name("Александр", "Сергеевич", "Пушкин");
        System.out.println(n2);

        Name n3 = new Name(null, null, "Маяковский");
        System.out.println(n3);

        Name n4 = new Name("Владимир", null, null);
        System.out.println(n4);

        try {
            new Name(null, null, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валид��ции: " + e.getMessage());
        }

        try {
            new Name("", "", "");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }

        System.out.println();
    }

    private static void test2() {
        System.out.println("--- Тест 2: PhoneBook ---");
        PhoneBook book = new PhoneBook();

        book.add("555-1234", "Иван");
        book.add("555-5678", "Мария");
        book.add("555-9012", "Пётр");
        book.add("555-3456", "Анна");
        book.add("123-4567", "Алексей");

        System.out.println(book);

        System.out.println("Телефон Ивана: " + book.get("Иван"));

        System.out.println("Имена на 'А': ");
        String[] aNames = book.getNamesByPrefix("А");
        for (String name : aNames) {
            System.out.println("  " + name + " - " + book.get(name));
        }

        System.out.println("Имена на 'М': ");
        String[] mNames = book.getNamesByPrefix("М");
        for (String name : mNames) {
            System.out.println("  " + name + " - " + book.get(name));
        }

        System.out.println();
    }

    private static void test3() {
        System.out.println("--- Тест 3: MachineGun ---");
        MachineGun mg = new MachineGun(30, 3);
        System.out.println(mg);

        mg.reload(30);
        System.out.println("Одиночная стрельба:");
        mg.shoot();

        System.out.println("Стрельба 2 секунды:");
        mg.shootForSeconds(2);

        System.out.println("Патронов осталось: " + mg.getCurrentAmmo());
        System.out.println();
    }

    private static void test4() {
        System.out.println("--- Тест 4: Weapon иерархия ---");
        Weapon w1 = new Gun(5);
        w1.load(3);
        System.out.println(w1);
        w1.shoot();
        w1.shoot();
        w1.shoot();
        w1.shoot();

        Weapon w2 = new MachineGun(10, 2);
        w2.load(8);
        System.out.println(w2);
        w2.shoot();

        System.out.println();
    }

    private static void test5() {
        System.out.println("--- Тест 5: Shooter ---");
        
        Shooter s1 = new Shooter("Безоружный Боб");
        System.out.println(s1);
        s1.shoot();

        Gun pistol = new Gun(5);
        pistol.load(3);
        Shooter s2 = new Shooter("Стрелок Сэм", pistol);
        System.out.println(s2);
        s2.shoot();

        MachineGun mg = new MachineGun(20, 5);
        mg.load(20);
        Shooter s3 = new Shooter("Пулемётчик Макс", mg);
        System.out.println(s3);
        s3.shoot();

        System.out.println();
    }

    private static void test6() {
        System.out.println("--- Тест 6: Point ---");
        Point p1 = new Point(3, 5);
        Point p2 = new Point(3, 5);
        Point p3 = new Point(3, 6);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);

        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));

        System.out.println();
    }

    private static void test8() {
        System.out.println("--- Тест 8: Gun с protected ammo ---");
        Gun gun = new Gun(10);
        System.out.println(gun);

        gun.reload(7);
        System.out.println("После зарядки: " + gun);

        gun.shoot();
        gun.shoot();
        System.out.println("После 2 выстрелов: " + gun);

        int unloaded = gun.unload();
        System.out.println("Разряжено патронов: " + unloaded);
        System.out.println("После разрядки: " + gun);

        System.out.println();
    }
}
