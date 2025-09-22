import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        App app = new App();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Лабораторная работа #1");
        System.out.println("======================");
        
        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("1 - Задание 1: Методы");
            System.out.println("2 - Задание 2: Условия"); 
            System.out.println("3 - Задание 3: Циклы");
            System.out.println("4 - Задание 4: Массивы");
            System.out.println("0 - Выход");
            
            int choice = safeMenuChoice(scanner);
            
            if (choice == 0) {
                break;
            }
            
            switch (choice) {
                case 1:
                    testTask1(scanner, app);
                    break;
                case 2:
                    testTask2(scanner, app);
                    break;
                case 3:
                    testTask3(scanner, app);
                    break;
                case 4:
                    testTask4(scanner, app);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
        
        scanner.close();
    }
    
    private static void testTask1(Scanner scanner, App app) {
        System.out.println("\n=== Задание 1: Методы ===");
        
        System.out.println("\n2. Сумма последних цифр");
        int num = safeIntInput(scanner, "Введите число: ");
        System.out.println("Результат: " + app.sumLastNums(num));
        
        System.out.println("\n4. Проверка на положительность");
        int num2 = safeIntInput(scanner, "Введите число: ");
        System.out.println("Результат: " + app.isPositive(num2));
        
        System.out.println("\n6. Проверка на большую букву");
        System.out.print("Введите символ: ");
        char ch = scanner.next().charAt(0);
        System.out.println("Результат: " + app.isUpperCase(ch));
        
        System.out.println("\n8. Проверка делимости");
        int a = safeIntInput(scanner, "Введите первое число: ");
        int b = safeIntInput(scanner, "Введите второе число: ");
        System.out.println("Результат: " + app.isDivisor(a, b));
        
        System.out.println("\n10. Последовательное сложение пяти чисел");
        int n1 = safeIntInput(scanner, "Введите первое число: ");
        int n2 = safeIntInput(scanner, "Введите второе число: ");
        int n3 = safeIntInput(scanner, "Введите третье число: ");
        int n4 = safeIntInput(scanner, "Введите четвертое число: ");
        int n5 = safeIntInput(scanner, "Введите пятое число: ");
        
        int result = app.lastNumSum(n1, n2);
        result = app.lastNumSum(result, n3);
        result = app.lastNumSum(result, n4);
        result = app.lastNumSum(result, n5);
        
        System.out.println("Итоговый результат: " + result);
    }
    
    private static void testTask2(Scanner scanner, App app) {
        System.out.println("\n=== Задание 2: Условия ===");
        
        System.out.println("\n2. Безопасное деление");
        int x1 = safeIntInput(scanner, "Введите делимое: ");
        int y1 = safeIntInput(scanner, "Введите делитель: ");
        System.out.println("Результат: " + app.safeDiv(x1, y1));
        
        System.out.println("\n4. Строка сравнения");
        int x2 = safeIntInput(scanner, "Введите первое число: ");
        int y2 = safeIntInput(scanner, "Введите второе число: ");
        System.out.println("Результат: " + app.makeDecision(x2, y2));
        
        System.out.println("\n6. Тройная сумма");
        int x3 = safeIntInput(scanner, "Введите первое число: ");
        int y3 = safeIntInput(scanner, "Введите второе число: ");
        int z3 = safeIntInput(scanner, "Введите третье число: ");
        System.out.println("Результат: " + app.sum3(x3, y3, z3));
        
        System.out.println("\n8. Возраст");
        int age1 = safeIntInput(scanner, "Введите возраст: ");
        System.out.println("Результат: " + app.age(age1));
        
        System.out.println("\n10. Вывод дней недели");
        System.out.print("Введите день недели: ");
        scanner.nextLine();
        String day = scanner.nextLine();
        app.printDays(day);
    }
    
    private static void testTask3(Scanner scanner, App app) {
        System.out.println("\n=== Задание 3: Циклы ===");
        
        System.out.println("\n2. Числа наоборот");
        int x1 = safeIntInput(scanner, "Введите число: ");
        System.out.println("Результат: " + app.reverseListNums(x1));
        
        System.out.println("\n4. Степень числа");
        int x2 = safeIntInput(scanner, "Введите основание: ");
        int y2 = safeIntInput(scanner, "Введите степень: ");
        System.out.println("Результат: " + app.pow(x2, y2));
        
        System.out.println("\n6. Одинаковость цифр");
        int x3 = safeIntInput(scanner, "Введите число: ");
        System.out.println("Результат: " + app.equalNum(x3));
        
        System.out.println("\n8. Левый треугольник");
        int x4 = safeIntInput(scanner, "Введите размер: ");
        app.leftTriangle(x4);
        
        System.out.println("\n10. Угадайка");
        app.guessGame(scanner);
    }
    
    private static void testTask4(Scanner scanner, App app) {
        System.out.println("\n=== Задание 4: Массивы ===");
        
        System.out.println("\n2. Поиск последнего значения");
        int[] arr1 = inputArray(scanner, "массива");
        int val1 = safeIntInput(scanner, "Введите искомое значение: ");
        System.out.println("Результат: " + app.findLast(arr1, val1));
        
        System.out.println("\n4. Добавление в массив");
        int[] arr2 = inputArray(scanner, "массива");
        int val2 = safeIntInput(scanner, "Введите значение для вставки: ");
        int pos2 = safeIntInput(scanner, "Введите позицию: ");
        int[] result2 = app.add(arr2, val2, pos2);
        System.out.print("Результат: ");
        printArray(result2);
        
        System.out.println("\n6. Реверс");
        int[] arr3 = inputArray(scanner, "массива");
        app.reverse(arr3);
        System.out.print("Результат: ");
        printArray(arr3);
        
        System.out.println("\n8. Объединение");
        int[] arr4a = inputArray(scanner, "первого массива");
        int[] arr4b = inputArray(scanner, "второго массива");
        int[] result4 = app.concat(arr4a, arr4b);
        System.out.print("Результат: ");
        printArray(result4);
        
        System.out.println("\n10. Удалить негатив");
        int[] arr5 = inputArray(scanner, "массива");
        int[] result5 = app.deleteNegative(arr5);
        System.out.print("Результат: ");
        printArray(result5);
    }
    
    private static int[] inputArray(Scanner scanner, String arrayName) {
        int size = safeIntInput(scanner, "Введите размер " + arrayName + ": ");
        int[] arr = new int[size];
        System.out.println("Введите элементы " + arrayName + ":");
        for (int i = 0; i < size; i++) {
            arr[i] = safeIntInput(scanner, "Элемент " + (i + 1) + ": ");
        }
        return arr;
    }
    
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
    
    private static int safeIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Введите целое число.");
                scanner.nextLine();
            }
        }
    }
    
    private static int safeMenuChoice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Выберите число от 0 до 4!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Введите число от 0 до 4.");
                scanner.nextLine();
            }
        }
    }
}
