import java.util.Scanner;
import java.util.Random;

public class App {
    
    public int sumLastNums(int x) {
        int lastDigit = x % 10;
        int secondLastDigit = (x / 10) % 10;
        return lastDigit + secondLastDigit;
    }
    
    public boolean isPositive(int x) {
        return x > 0;
    }
    
    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }
    
    public boolean isDivisor(int a, int b) {
        return a % b == 0 || b % a == 0;
    }
    
    public int lastNumSum(int a, int b) {
        int lastA = a % 10;
        int lastB = b % 10;
        return lastA + lastB;
    }
    
    public double safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        }
        return (double) x / y;
    }
    
    public String makeDecision(int x, int y) {
        if (x > y) {
            return x + ">" + y;
        } else if (x < y) {
            return x + "<" + y;
        } else {
            return x + "==" + y;
        }
    }
    
    public boolean sum3(int x, int y, int z) {
        return x + y == z || x + z == y || y + z == x;
    }
    
    public String age(int x) {
        int lastDigit = x % 10;
        int lastTwoDigits = x % 100;
        
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return x + " лет";
        } else if (lastDigit == 1) {
            return x + " год";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return x + " года";
        } else {
            return x + " лет";
        }
    }
    
    public void printDays(String x) {
        String[] days = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
        
        int startIndex = -1;
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(x)) {
                startIndex = i;
                break;
            }
        }
        
        if (startIndex == -1) {
            System.out.println("это не день недели");
            return;
        }
        
        for (int i = startIndex; i < days.length; i++) {
            System.out.println(days[i]);
        }
    }
    
    public String reverseListNums(int x) {
        String result = "";
        for (int i = x; i >= 0; i--) {
            result += i + " ";
        }
        return result.trim();
    }
    
    public int pow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }
    
    public boolean equalNum(int x) {
        if (x < 0) {
            x = -x;
        }
        int firstDigit = x % 10;
        while (x > 0) {
            if (x % 10 != firstDigit) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
    
    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public void guessGame(Scanner scanner) {
        Random random = new Random();
        int secretNumber = random.nextInt(10);
        int attempts = 0;
        
        while (true) {
            attempts++;
            int guess;
            if (attempts == 1) {
                guess = safeIntInput(scanner, "Введите число от 0 до 9: ");
            } else {
                guess = safeIntInput(scanner, "Вы не угадали, введите число от 0 до 9: ");
            }
            
            if (guess == secretNumber) {
                System.out.println("Вы угадали!");
                System.out.println("Вы отгадали число за " + attempts + " попытки");
                break;
            }
        }
    }
    
    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
    
    public int[] add(int[] arr, int x, int pos) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        newArr[pos] = x;
        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }
    
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
    
    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }
    
    public int[] deleteNegative(int[] arr) {
        int[] temp = new int[arr.length];
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[count] = arr[i];
                count++;
            }
        }
        
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }
    
    private int[] inputArray(Scanner scanner, String arrayName) {
        int size = safeIntInput(scanner, "Введите размер " + arrayName + ": ");
        int[] arr = new int[size];
        System.out.println("Введите элементы " + arrayName + ":");
        for (int i = 0; i < size; i++) {
            arr[i] = safeIntInput(scanner, "Элемент " + (i + 1) + ": ");
        }
        return arr;
    }
    
    private void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
    
    private int safeIntInput(Scanner scanner, String prompt) {
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
    
    private int safeMenuChoice(Scanner scanner) {
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
            
            int choice = app.safeMenuChoice(scanner);
            
            if (choice == 0) {
                break;
            }
            
            switch (choice) {
                case 1:
                    app.testTask1(scanner);
                    break;
                case 2:
                    app.testTask2(scanner);
                    break;
                case 3:
                    app.testTask3(scanner);
                    break;
                case 4:
                    app.testTask4(scanner);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
        
        scanner.close();
    }
    
    private void testTask1(Scanner scanner) {
        System.out.println("\n=== Задание 1: Методы ===");
        
        System.out.println("\n2. Сумма последних цифр");
        int num = safeIntInput(scanner, "Введите число: ");
        System.out.println("Результат: " + sumLastNums(num));
        
        System.out.println("\n4. Проверка на положительность");
        int num2 = safeIntInput(scanner, "Введите число: ");
        System.out.println("Результат: " + isPositive(num2));
        
        System.out.println("\n6. Проверка на большую букву");
        System.out.print("Введите символ: ");
        char ch = scanner.next().charAt(0);
        System.out.println("Результат: " + isUpperCase(ch));
        
        System.out.println("\n8. Проверка делимости");
        int a = safeIntInput(scanner, "Введите первое число: ");
        int b = safeIntInput(scanner, "Введите второе число: ");
        System.out.println("Результат: " + isDivisor(a, b));
        
        System.out.println("\n10. Последовательное сложение пяти чисел");
        int n1 = safeIntInput(scanner, "Введите первое число: ");
        int n2 = safeIntInput(scanner, "Введите второе число: ");
        int n3 = safeIntInput(scanner, "Введите третье число: ");
        int n4 = safeIntInput(scanner, "Введите четвертое число: ");
        int n5 = safeIntInput(scanner, "Введите пятое число: ");
        
        int result = lastNumSum(n1, n2);
        result = lastNumSum(result, n3);
        result = lastNumSum(result, n4);
        result = lastNumSum(result, n5);
        
        System.out.println("Итоговый результат: " + result);
    }
    
    private void testTask2(Scanner scanner) {
        System.out.println("\n=== Задание 2: Условия ===");
        
        System.out.println("\n2. Безопасное деление");
        int x1 = safeIntInput(scanner, "Введите делимое: ");
        int y1 = safeIntInput(scanner, "Введите делитель: ");
        System.out.println("Результат: " + safeDiv(x1, y1));
        
        System.out.println("\n4. Строка сравнения");
        int x2 = safeIntInput(scanner, "Введите первое число: ");
        int y2 = safeIntInput(scanner, "Введите второе число: ");
        System.out.println("Результат: " + makeDecision(x2, y2));
        
        System.out.println("\n6. Тройная сумма");
        int x3 = safeIntInput(scanner, "Введите первое число: ");
        int y3 = safeIntInput(scanner, "Введите второе число: ");
        int z3 = safeIntInput(scanner, "Введите третье число: ");
        System.out.println("Результат: " + sum3(x3, y3, z3));
        
        System.out.println("\n8. Возраст");
        int age1 = safeIntInput(scanner, "Введите возраст: ");
        System.out.println("Результат: " + age(age1));
        
        System.out.println("\n10. Вывод дней недели");
        System.out.print("Введите день недели: ");
        scanner.nextLine();
        String day = scanner.nextLine();
        printDays(day);
    }
    
    private void testTask3(Scanner scanner) {
        System.out.println("\n=== Задание 3: Циклы ===");
        
        System.out.println("\n2. Числа наоборот");
        int x1 = safeIntInput(scanner, "Введите число: ");
        System.out.println("Результат: " + reverseListNums(x1));
        
        System.out.println("\n4. Степень числа");
        int x2 = safeIntInput(scanner, "Введите основание: ");
        int y2 = safeIntInput(scanner, "Введите степень: ");
        System.out.println("Результат: " + pow(x2, y2));
        
        System.out.println("\n6. Одинаковость цифр");
        int x3 = safeIntInput(scanner, "Введите число: ");
        System.out.println("Результат: " + equalNum(x3));
        
        System.out.println("\n8. Левый треугольник");
        int x4 = safeIntInput(scanner, "Введите размер: ");
        leftTriangle(x4);
        
        System.out.println("\n10. Угадайка");
        guessGame(scanner);
    }
    
    private void testTask4(Scanner scanner) {
        System.out.println("\n=== Задание 4: Массивы ===");
        
        System.out.println("\n2. Поиск последнего значения");
        int[] arr1 = inputArray(scanner, "массива");
        int val1 = safeIntInput(scanner, "Введите искомое значение: ");
        System.out.println("Результат: " + findLast(arr1, val1));
        
        System.out.println("\n4. Добавление в массив");
        int[] arr2 = inputArray(scanner, "массива");
        int val2 = safeIntInput(scanner, "Введите значение для вставки: ");
        int pos2 = safeIntInput(scanner, "Введите позицию: ");
        int[] result2 = add(arr2, val2, pos2);
        System.out.print("Результат: ");
        printArray(result2);
        
        System.out.println("\n6. Реверс");
        int[] arr3 = inputArray(scanner, "массива");
        reverse(arr3);
        System.out.print("Результат: ");
        printArray(arr3);
        
        System.out.println("\n8. Объединение");
        int[] arr4a = inputArray(scanner, "первого массива");
        int[] arr4b = inputArray(scanner, "второго массива");
        int[] result4 = concat(arr4a, arr4b);
        System.out.print("Результат: ");
        printArray(result4);
        
        System.out.println("\n10. Удалить негатив");
        int[] arr5 = inputArray(scanner, "массива");
        int[] result5 = deleteNegative(arr5);
        System.out.print("Результат: ");
        printArray(result5);
    }
}
