import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getIntInput("Выберите пункт: ", 0, 7);
            
            if (choice == 0) {
                System.out.println("До свидания!");
                break;
            }
            
            System.out.println();
            switch (choice) {
                case 1:
                    task1A();
                    break;
                case 2:
                    task1B();
                    break;
                case 3:
                    task2();
                    break;
                case 4:
                    task3();
                    break;
                case 5:
                    task4();
                    break;
                case 6:
                    task5();
                    break;
                case 7:
                    runTests();
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Лабораторная работа 2 - Меню");
        System.out.println("=".repeat(50));
        System.out.println("1. Задача 1A - Имена");
        System.out.println("2. Задача 1B - Человек");
        System.out.println("3. Задача 2 - Сотрудники и отделы");
        System.out.println("4. Задача 3 - Список сотрудников отдела");
        System.out.println("5. Задача 4 - Создаем имена (перегрузка)");
        System.out.println("6. Задача 5 - Пистолет стреляет");
        System.out.println("7. Запустить все тесты");
        System.out.println("0. Выход");
        System.out.println("=".repeat(50));
    }

    private static void task1A() {
        System.out.println("=== Задача 1A - Имена ===");
        System.out.println("Создайте имена в формате: Фамилия Имя Отчество");
        System.out.println("(Для пропуска параметра оставьте поле пустым)\n");
        
        for (int i = 1; i <= 3; i++) {
            System.out.println("Имя " + i + ":");
            
            String lastName = getStringInput("  Фамилия: ", true);
            if (lastName.isEmpty()) lastName = null;
            
            String firstName = getStringInput("  Имя: ", true);
            if (firstName.isEmpty()) firstName = null;
            
            String patronymic = getStringInput("  Отчество: ", true);
            if (patronymic.isEmpty()) patronymic = null;
            
            Name name = new Name(lastName, firstName, patronymic);
            System.out.println("  Результат: " + name);
            System.out.println();
        }
    }

    private static void task1B() {
        System.out.println("=== Задача 1B - Человек ===");
        System.out.println("Создайте людей с указанием имени и роста\n");
        
        for (int i = 1; i <= 3; i++) {
            System.out.println("Человек " + i + ":");
            
            String name = getStringInput("  Имя: ", false);
            int height = getIntInput("  Рост (100-250 см): ", 100, 250);
            
            Person person = new Person(name, height);
            System.out.println("  Результат: " + person);
            System.out.println();
        }
    }

    private static void task2() {
        System.out.println("=== Задача 2 - Сотрудники и отделы ===");
        
        String deptName = getStringInput("Название отдела: ", false);
        Department dept = new Department(deptName);
        
        System.out.println("\nВведите имена 3 сотрудников:");
        Employee[] employees = new Employee[3];
        
        for (int i = 0; i < 3; i++) {
            String empName = getStringInput("Сотрудник " + (i + 1) + ": ", false);
            employees[i] = new Employee(empName, dept);
        }
        
        int bossIndex = getIntInput("\nКто будет начальником? (1-3): ", 1, 3) - 1;
        dept.setBoss(employees[bossIndex]);
        
        System.out.println("\nИнформация о сотрудниках:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void task3() {
        System.out.println("=== Задача 3 - Список сотрудников отдела ===");
        
        String deptName = getStringInput("Название отдела: ", false);
        Department dept = new Department(deptName);
        
        int empCount = getIntInput("Сколько сотрудников добавить? (1-10): ", 1, 10);
        
        Employee[] employees = new Employee[empCount];
        System.out.println("\nВведите имена сотрудников:");
        
        for (int i = 0; i < empCount; i++) {
            String empName = getStringInput("Сотрудник " + (i + 1) + ": ", false);
            employees[i] = new Employee(empName, dept);
        }
        
        if (empCount > 0) {
            int bossIndex = getIntInput("\nКто будет начальником? (1-" + empCount + "): ", 1, empCount) - 1;
            dept.setBoss(employees[bossIndex]);
        }
        
        System.out.println("\nСотрудники отдела " + dept.getName() + ":");
        for (Employee emp : employees[0].getDepartment().getEmployees()) {
            System.out.println("- " + emp.getName());
        }
    }

    private static void task4() {
        System.out.println("=== Задача 4 - Создаем имена (перегрузка конструкторов) ===");
        System.out.println("Формат вывода: Имя Отчество Фамилия");
        System.out.println("Выберите вариант создания имени:");
        System.out.println("1. Только имя");
        System.out.println("2. Имя и фамилия");
        System.out.println("3. Имя, отчество и фамилия");
        
        int variant = getIntInput("Ваш выбор (1-3): ", 1, 3);
        
        String firstName = getStringInput("\nВведите имя: ", false);
        
        Name2 name;
        
        if (variant == 1) {
            name = new Name2(firstName);
        } else if (variant == 2) {
            String lastName = getStringInput("Введите фамилию: ", false);
            name = new Name2(firstName, lastName);
        } else {
            String patronymic = getStringInput("Введите отчество: ", false);
            String lastName = getStringInput("Введите фамилию: ", false);
            name = new Name2(firstName, patronymic, lastName);
        }
        
        System.out.println("\nРезультат: " + name);
    }

    private static void task5() {
        System.out.println("=== Задача 5 - Пистолет стреляет ===");
        
        System.out.println("Создание пистолета:");
        System.out.println("1. С заданным количеством патронов");
        System.out.println("2. С количеством патронов по умолчанию (5)");
        
        int choice = getIntInput("Ваш выбор (1-2): ", 1, 2);
        
        Gun gun;
        if (choice == 1) {
            int bullets = getIntInput("Введите количество патронов (0-100): ", 0, 100);
            gun = new Gun(bullets);
            System.out.println("Создан пистолет с " + bullets + " патронами");
        } else {
            gun = new Gun();
            System.out.println("Создан пистолет с 5 патронами по умолчанию");
        }
        
        int shots = getIntInput("\nСколько раз выстрелить? (1-20): ", 1, 20);
        
        System.out.println("\nСтреляем " + shots + " раз:");
        for (int i = 0; i < shots; i++) {
            System.out.print((i + 1) + ". ");
            gun.shoot();
        }
        
        System.out.println("\nОсталось патронов: " + gun.getBullets());
    }

    private static void runTests() {
        System.out.println("=== Запуск автоматических тестов ===");
        TestRunner.main(new String[0]);
    }

    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            if (!prompt.isEmpty()) {
                System.out.print(prompt);
            }
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                System.out.println("Ошибка: ввод не может быть пустым. Попробуйте еще раз.");
                continue;
            }
            
            try {
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("Ошибка: число должно быть от " + min + " до " + max + ". Попробуйте еще раз.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ожидается целое число. Попробуйте еще раз.");
            }
        }
    }
    
    private static String getStringInput(String prompt, boolean allowEmpty) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            
            if (!allowEmpty && input.isEmpty()) {
                System.out.println("Ошибка: поле не может быть пустым. Попробуйте еще раз.");
                continue;
            }
            
            if (!input.isEmpty() && input.matches(".*\\d.*")) {
                System.out.println("Ошибка: имя не должно содержать цифры. Попробуйте еще раз.");
                continue;
            }
            
            return input;
        }
    }
}
