# Лабораторная работа №1

## Содержание
1. [Структура проекта](#структура-проекта)
2. [Как работает основной код](#как-работает-основной-код)
3. [Класс App](#класс-app)
   - [Задание 1: Методы](#задание-1-методы)
   - [Задание 2: Условия](#задание-2-условия)
   - [Задание 3: Циклы](#задание-3-циклы)
   - [Задание 4: Массивы](#задание-4-массивы)
4. [Вспомогательные методы](#вспомогательные-методы)
5. [Как использовать](#как-использовать)

## Структура проекта
Проект состоит из единственного класса:
- `App` - основной класс, содержащий все методы решения задач и интерфейс пользователя

## Как работает основной код
```java
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
        case 1: app.testTask1(scanner); break;
        case 2: app.testTask2(scanner); break;
        case 3: app.testTask3(scanner); break;
        case 4: app.testTask4(scanner); break;
    }
}
```

Программа работает в цикле, предлагая пользователю выбрать блок заданий. После выбора запускается соответствующий метод тестирования, который последовательно выполняет все четные задания из блока.

## Класс App
Содержит методы для решения 20 задач лабораторной работы

### Задание 1: Методы
(задачи 2, 4, 6, 8, 10)

#### 1. `sumLastNums(int x)` - Сумма двух последних цифр
```java
public int sumLastNums(int x) {
    int lastDigit = x % 10;
    int secondLastDigit = (x / 10) % 10;
    return lastDigit + secondLastDigit;
}
```
**Логика работы:** Извлекает две последние цифры числа с помощью операций остатка от деления и целочисленного деления, затем возвращает их сумму.

#### 2. `isPositive(int x)` - Проверка на положительность
```java
public boolean isPositive(int x) {
    return x > 0;
}
```
**Логика работы:** Простая проверка, является ли число строго положительным.

#### 3. `isUpperCase(char x)` - Проверка на заглавную букву
```java
public boolean isUpperCase(char x) {
    return x >= 'A' && x <= 'Z';
}
```
**Логика работы:** Проверяет, находится ли символ в диапазоне заглавных букв латинского алфавита.

#### 4. `isDivisor(int a, int b)` - Проверка делимости
```java
public boolean isDivisor(int a, int b) {
    return a % b == 0 || b % a == 0;
}
```
**Логика работы:** Проверяет, делится ли одно число на другое без остатка в любом направлении.

#### 5. `lastNumSum(int a, int b)` - Сумма последних цифр двух чисел
```java
public int lastNumSum(int a, int b) {
    int lastA = a % 10;
    int lastB = b % 10;
    return lastA + lastB;
}
```
**Логика работы:** Находит последние цифры двух чисел и возвращает их сумму.

### Задание 2: Условия
(задачи 2, 4, 6, 8, 10)

#### 6. `safeDiv(int x, int y)` - Безопасное деление
```java
public double safeDiv(int x, int y) {
    if (y == 0) {
        return 0;
    }
    return (double) x / y;
}
```
**Логика работы:** Выполняет деление с проверкой деления на ноль, возвращая 0 в случае деления на ноль.

#### 7. `makeDecision(int x, int y)` - Сравнение чисел
```java
public String makeDecision(int x, int y) {
    if (x > y) {
        return x + ">" + y;
    } else if (x < y) {
        return x + "<" + y;
    } else {
        return x + "==" + y;
    }
}
```
**Логика работы:** Сравнивает два числа и формирует строку с результатом сравнения.

#### 8. `sum3(int x, int y, int z)` - Проверка тройной суммы
```java
public boolean sum3(int x, int y, int z) {
    return x + y == z || x + z == y || y + z == x;
}
```
**Логика работы:** Проверяет все три возможные комбинации: можно ли получить одно число как сумму двух других.

#### 9. `age(int x)` - Склонение возраста
```java
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
```
**Логика работы:** Определяет правильную форму слова "год" в зависимости от числа с учетом особых случаев для чисел 11-14.

#### 10. `printDays(String x)` - Вывод дней недели
```java
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
```
**Логика работы:** Использует массив дней недели, находит индекс заданного дня и выводит все последующие дни до воскресенья.

### Задание 3: Циклы
(задачи 2, 4, 6, 8, 10)

#### 11. `reverseListNums(int x)` - Числа в обратном порядке
```java
public String reverseListNums(int x) {
    String result = "";
    for (int i = x; i >= 0; i--) {
        result += i + " ";
    }
    return result.trim();
}
```
**Логика работы:** Формирует строку чисел от x до 0 в убывающем порядке с помощью обратного цикла.

#### 12. `pow(int x, int y)` - Возведение в степень
```java
public int pow(int x, int y) {
    int result = 1;
    for (int i = 0; i < y; i++) {
        result *= x;
    }
    return result;
}
```
**Логика работы:** Вычисляет x в степени y через циклическое умножение.

#### 13. `equalNum(int x)` - Проверка одинаковых цифр
```java
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
```
**Логика работы:** Проверяет, состоит ли число из одинаковых цифр, сравнивая каждую цифру с первой.

#### 14. `leftTriangle(int x)` - Левый треугольник
```java
public void leftTriangle(int x) {
    for (int i = 1; i <= x; i++) {
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
```
**Логика работы:** Выводит треугольник из звездочек с помощью вложенных циклов.

#### 15. `guessGame(Scanner scanner)` - Игра "Угадай число"
```java
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
```
**Логика работы:** Генерирует случайное число от 0 до 9, предлагает пользователю угадать его и подсчитывает количество попыток.

### Задание 4: Массивы
(задачи 2, 4, 6, 8, 10)

#### 16. `findLast(int[] arr, int x)` - Поиск последнего вхождения
```java
public int findLast(int[] arr, int x) {
    for (int i = arr.length - 1; i >= 0; i--) {
        if (arr[i] == x) {
            return i;
        }
    }
    return -1;
}
```
**Логика работы:** Ищет элемент в массиве с конца к началу, возвращая индекс первого найденного элемента (который является последним вхождением).

#### 17. `add(int[] arr, int x, int pos)` - Добавление элемента
```java
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
```
**Логика работы:** Создает новый массив размером на 1 больше, копирует элементы до позиции вставки, вставляет новый элемент, затем копирует оставшиеся элементы.

#### 18. `reverse(int[] arr)` - Реверс массива
```java
public void reverse(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
    }
}
```
**Логика работы:** Переворачивает массив на месте, меняя местами элементы с противоположных концов.

#### 19. `concat(int[] arr1, int[] arr2)` - Объединение массивов
```java
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
```
**Логика работы:** Создает новый массив размером равным сумме размеров исходных массивов и копирует в него все элементы поочередно.

#### 20. `deleteNegative(int[] arr)` - Удаление отрицательных элементов
```java
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
```
**Логика работы:** За один проход собирает неотрицательные элементы во временный массив, затем создает результирующий массив нужного размера.

## Вспомогательные методы

#### `safeIntInput(Scanner scanner, String prompt)` - Безопасный ввод
```java
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
```
**Логика работы:** Обеспечивает безопасный ввод целых чисел с обработкой исключений.

#### `inputArray(Scanner scanner, String arrayName)` - Ввод массива
```java
private int[] inputArray(Scanner scanner, String arrayName) {
    int size = safeIntInput(scanner, "Введите размер " + arrayName + ": ");
    int[] arr = new int[size];
    System.out.println("Введите элементы " + arrayName + ":");
    for (int i = 0; i < size; i++) {
        arr[i] = safeIntInput(scanner, "Элемент " + (i + 1) + ": ");
    }
    return arr;
}
```
**Логика работы:** Унифицированный метод для ввода массивов любого размера с проверкой корректности ввода.

#### `printArray(int[] arr)` - Вывод массива
```java
private void printArray(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]);
        if (i < arr.length - 1) System.out.print(",");
    }
    System.out.println("]");
}
```
**Логика работы:** Выводит массив в стандартном формате [1,2,3].

## Как использовать
1. Скомпилируйте программу: `javac App.java`
2. Запустите: `java App`
3. Выберите нужный блок заданий (1-4)
4. Следуйте инструкциям программы для ввода данных