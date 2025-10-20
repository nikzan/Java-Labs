package ru.nikzan.main;

import ru.nikzan.weapons.*;
import ru.nikzan.people.*;
import ru.nikzan.geometry.Point;
import ru.nikzan.phonebook.PhoneBook;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Задание 7.3 - Возведение в степень из аргументов командной строки
        if (args.length >= 2) {
            try {
                double result = power(args[0], args[1]);
                System.out.println(args[0] + " в степени " + args[1] + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат чисел в аргументах");
            }
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== ЛАБОРАТОРНАЯ РАБОТА 3 ===");
            System.out.println("1. Задание 1A - Перезарядка Пистолета");
            System.out.println("2. Задание 1B - Непустые Имена");
            System.out.println("3. Задание 2 - Телефонный Справочник");
            System.out.println("4. Задание 3 - Автомат");
            System.out.println("5. Задание 4-5 - Оружие и Стрелок");
            System.out.println("6. Задание 6 - Точка координат");
            System.out.println("7. Задание 8 - Gun с protected ammo");
            System.out.println("8. Возведение в степень (7.3)");
            System.out.println("0. Выход");
            System.out.print("Выберите задание: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    demoTask1A();
                    break;
                case 2:
                    demoTask1B();
                    break;
                case 3:
                    demoTask2();
                    break;
                case 4:
                    demoTask3();
                    break;
                case 5:
                    demoTask4and5();
                    break;
                case 6:
                    demoTask6();
                    break;
                case 7:
                    demoTask8();
                    break;
                case 8:
                    demoPower();
                    break;
                case 0:
                    exit = true;
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }

    /**
     * Задание 7.3 - Возведение в степень с использованием коротких имён
     */
    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }

    private static void demoTask1A() {
        System.out.println("\n--- Демонстрация Задания 1A ---");
        System.out.print("Введите максимальную вместимость пистолета: ");
        int maxAmmo = getIntInput();

        Gun gun = new Gun(maxAmmo);
        System.out.println("Создан: " + gun);

        boolean back = false;
        while (!back) {
            System.out.println("\n1. Зарядить");
            System.out.println("2. Выстрелить");
            System.out.println("3. Разрядить");
            System.out.println("4. Информация");
            System.out.println("0. Назад");
            System.out.print("Выбор: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    System.out.print("Сколько патронов зарядить? ");
                    int ammo = getIntInput();
                    try {
                        int extra = gun.reload(ammo);
                        if (extra > 0) {
                            System.out.println("Заряжено. Лишних патронов: " + extra);
                        } else {
                            System.out.println("Заряжено.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    gun.shoot();
                    break;
                case 3:
                    int unloaded = gun.unload();
                    System.out.println("Изъято патронов: " + unloaded);
                    break;
                case 4:
                    System.out.println(gun);
                    System.out.println("Текущих патронов: " + gun.getCurrentAmmo());
                    System.out.println("Максимум: " + gun.getMaxAmmo());
                    System.out.println("Заряжен: " + (gun.isLoaded() ? "Да" : "Нет"));
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoTask1B() {
        System.out.println("\n--- Демонстрация Задания 1B ---");
        System.out.print("Введите имя: ");
        String firstName = getStringInput();
        System.out.print("Введите отчество (или Enter для пропуска): ");
        String patronymic = scanner.nextLine();
        System.out.print("Введите фамилию (или Enter для пропуска): ");
        String lastName = scanner.nextLine();

        try {
            Name name = new Name(
                firstName.isEmpty() ? null : firstName,
                patronymic.isEmpty() ? null : patronymic,
                lastName.isEmpty() ? null : lastName
            );
            System.out.println("Создано имя: " + name);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void demoTask2() {
        System.out.println("\n--- Демонстрация Задания 2 ---");
        PhoneBook book = new PhoneBook();

        boolean back = false;
        while (!back) {
            System.out.println("\n1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Найти телефон");
            System.out.println("4. Показать все");
            System.out.println("5. Поиск по префиксу");
            System.out.println("0. Назад");
            System.out.print("Выбор: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = getStringInput();
                    System.out.print("Введите телефон: ");
                    String phone = getStringInput();
                    String oldPhone = book.add(phone, name);
                    if (oldPhone != null) {
                        System.out.println("Заменён старый телефон: " + oldPhone);
                    } else {
                        System.out.println("Контакт добавлен.");
                    }
                    break;
                case 2:
                    System.out.print("Введите имя для удаления: ");
                    String nameToRemove = getStringInput();
                    book.remove(nameToRemove);
                    System.out.println("Контакт удалён (если существовал).");
                    break;
                case 3:
                    System.out.print("Введите имя: ");
                    String nameToFind = getStringInput();
                    String foundPhone = book.get(nameToFind);
                    if (foundPhone != null) {
                        System.out.println("Телефон: " + foundPhone);
                    } else {
                        System.out.println("Контакт не найден.");
                    }
                    break;
                case 4:
                    System.out.println(book);
                    System.out.println("Всего контактов: " + book.size());
                    break;
                case 5:
                    System.out.print("Введите начало имени: ");
                    String prefix = getStringInput();
                    String[] names = book.getNamesByPrefix(prefix);
                    if (names.length == 0) {
                        System.out.println("Имена не найдены.");
                    } else {
                        System.out.println("Найденные имена:");
                        for (String n : names) {
                            System.out.println("  " + n + " - " + book.get(n));
                        }
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoTask3() {
        System.out.println("\n--- Демонстрация Задания 3 ---");
        System.out.print("Максимум патронов: ");
        int maxAmmo = getIntInput();
        System.out.print("Скорострельность (выстр/сек): ");
        int rate = getIntInput();

        MachineGun mg = new MachineGun(maxAmmo, rate);
        System.out.println("Создан: " + mg);

        System.out.print("Зарядить патронов: ");
        int ammo = getIntInput();
        mg.reload(ammo);

        System.out.println("Стрельба (1 раз):");
        mg.shoot();

        System.out.print("Стрелять N секунд (введите количество): ");
        int seconds = getIntInput();
        System.out.println("Стрельба " + seconds + " секунд:");
        mg.shootForSeconds(seconds);
    }

    private static void demoTask4and5() {
        System.out.println("\n--- Демонстрация Задания 4-5 ---");
        
        Shooter s1 = new Shooter("Иван (без оружия)");
        
        Gun pistol = new Gun(5);
        pistol.reload(3);
        Shooter s2 = new Shooter("Пётр (с пистолетом)", pistol);
        
        MachineGun mg = new MachineGun(10, 3);
        mg.reload(10);
        Shooter s3 = new Shooter("Сергей (с автоматом)", mg);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("\nКаждый стреляет:");
        s1.shoot();
        s2.shoot();
        s3.shoot();
    }

    private static void demoTask6() {
        System.out.println("\n--- Демонстрация Задания 6 ---");
        System.out.print("Точка 1 - X: ");
        double x1 = getDoubleInput();
        System.out.print("Точка 1 - Y: ");
        double y1 = getDoubleInput();

        System.out.print("Точка 2 - X: ");
        double x2 = getDoubleInput();
        System.out.print("Точка 2 - Y: ");
        double y2 = getDoubleInput();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
        System.out.println("Они равны? " + p1.equals(p2));
    }

    private static void demoTask8() {
        System.out.println("\n--- Демонстрация Задания 8 ---");
        System.out.print("Максимум патронов: ");
        int maxAmmo = getIntInput();

        Gun gun = new Gun(maxAmmo);
        System.out.println("Создан: " + gun);

        System.out.print("Зарядить патронов: ");
        int ammo = getIntInput();
        gun.reload(ammo);
        System.out.println(gun);

        System.out.print("Сколько раз выстрелить? ");
        int shots = getIntInput();
        for (int i = 0; i < shots; i++) {
            gun.shoot();
        }

        System.out.println("Разрядка...");
        int unloaded = gun.unload();
        System.out.println("Разряжено: " + unloaded);
        System.out.println(gun);
    }

    private static void demoPower() {
        System.out.println("\n--- Возведение в степень ---");
        System.out.print("Введите X: ");
        String x = scanner.nextLine();
        System.out.print("Введите Y: ");
        String y = scanner.nextLine();

        try {
            double result = power(x, y);
            System.out.println(x + " в степени " + y + " = " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введены некорректные числа");
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка: введите целое число: ");
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка: введите число: ");
            }
        }
    }

    private static String getStringInput() {
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Ошибка: строка не может быть пустой. Повторите ввод: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }
}
