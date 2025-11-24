package ru.nikzan.main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import ru.nikzan.functional.ListUtils;
import ru.nikzan.generics.Box;
import ru.nikzan.generics.BoxUtils;

public class Main {
    private final Scanner scanner;

    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        System.out.println("Лабораторная работа №4");
        System.out.println("======================");

        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("1 - Задание 1.1: Обобщенная коробка");
            System.out.println("2 - Задание 2: Поиск максимума");
            System.out.println("3 - Задание 3.1: Функция (Map)");
            System.out.println("4 - Задание 3.2: Фильтр");
            System.out.println("5 - Задание 3.3: Сокращение (Reduce)");
            System.out.println("6 - Задание 3.4: Коллекционирование");
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

            switch (choice) {
                case 1: demoTask1_1(); break;
                case 2: demoTask2(); break;
                case 3: demoTask3_1(); break;
                case 4: demoTask3_2(); break;
                case 5: demoTask3_3(); break;
                case 6: demoTask3_4(); break;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private void demoTask1_1() {
        System.out.println("\n--- Задание 1.1: Обобщенная коробка ---");
        Box<Integer> box = new Box<>();
        System.out.println("Создана пустая коробка для Integer.");
        
        int value = getIntInput("Введите целое число для размещения в коробке (например, 3): ");
        
        try {
            box.put(value);
            System.out.println("Число " + value + " помещено в коробку.");
            System.out.println("Состояние коробки: " + box);
            
            System.out.println("Извлекаем значение...");
            Integer extracted = box.take();
            System.out.println("Извлечено: " + extracted);
            System.out.println("Состояние коробки после извлечения: " + box);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void demoTask2() {
        System.out.println("\n--- Задание 2: Поиск максимума в коробках ---");
        System.out.println("Создадим несколько коробок с числами.");
        
        int count = getIntInput("Введите количество коробок: ");
        if (count <= 0) {
            System.out.println("Количество должно быть больше 0.");
            return;
        }

        Box<Number>[] boxes = new Box[count];
        for (int i = 0; i < count; i++) {
            boxes[i] = new Box<>();
            System.out.println("Коробка #" + (i + 1));
            System.out.println("1 - Integer, 2 - Double, 3 - Float");
            int type = getIntInput("Выберите тип числа: ");
            
            try {
                switch (type) {
                    case 1:
                        int iVal = getIntInput("Введите int значение: ");
                        boxes[i].put(iVal);
                        break;
                    case 2:
                        double dVal = getDoubleInput("Введите double значение: ");
                        boxes[i].put(dVal);
                        break;
                    case 3:
                        float fVal = (float) getDoubleInput("Введите float значение: ");
                        boxes[i].put(fVal);
                        break;
                    default:
                        System.out.println("Неверный тип, пропускаем коробку.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при заполнении: " + e.getMessage());
            }
        }

        try {
            double max = BoxUtils.findMax(boxes);
            System.out.println("Максимальное значение среди коробок: " + max);
        } catch (IllegalArgumentException e) {
            System.out.println("Не удалось найти максимум: " + e.getMessage());
        }
    }

    private void demoTask3_1() {
        System.out.println("\n--- Задание 3.1: Функция (Map) ---");
        
        System.out.println("\n1. Преобразование строк в их длины.");
        List<String> strings = getStringListInput();
        List<Integer> lengths = ListUtils.map(strings, String::length);
        System.out.println("Длины строк: " + lengths);

        System.out.println("\n2. Преобразование отрицательных чисел в положительные.");
        List<Integer> numbers = getIntegerListInput();
        List<Integer> absNumbers = ListUtils.map(numbers, Math::abs);
        System.out.println("Абсолютные значения: " + absNumbers);

        System.out.println("\n3. Максимальные значения из массивов чисел.");
        List<int[]> arrays = getListOfIntArraysInput();
        List<Integer> maxValues = ListUtils.map(arrays, arr -> {
            if (arr == null || arr.length == 0) return Integer.MIN_VALUE;
            int max = arr[0];
            for (int i : arr) if (i > max) max = i;
            return max;
        });
        System.out.print("Максимумы массивов: ");
        System.out.println(maxValues);
    }

    private void demoTask3_2() {
        System.out.println("\n--- Задание 3.2: Фильтр ---");

        System.out.println("\n1. Фильтрация строк (оставить те, где < 3 символов).");
        List<String> strings = getStringListInput();
        List<String> shortStrings = ListUtils.filter(strings, s -> s.length() < 3);
        System.out.println("Короткие строки: " + shortStrings);

        System.out.println("\n2. Фильтрация чисел (оставить положительные).");
        List<Integer> numbers = getIntegerListInput();
        List<Integer> positiveNumbers = ListUtils.filter(numbers, n -> n > 0);
        System.out.println("Положительные числа: " + positiveNumbers);

        System.out.println("\n3. Фильтрация массивов (оставить те, где нет положительных элементов).");
        List<int[]> arrays = getListOfIntArraysInput();
        List<int[]> nonPositiveArrays = ListUtils.filter(arrays, arr -> {
            for (int i : arr) {
                if (i > 0) return false;
            }
            return true;
        });
        System.out.println("Массивы без положительных элементов (количество): " + nonPositiveArrays.size());
        for (int[] arr : nonPositiveArrays) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private void demoTask3_3() {
        System.out.println("\n--- Задание 3.3: Сокращение (Reduce) ---");

        
        System.out.println("\n1. Объединение строк в одну.");
        List<String> strings = getStringListInput();
        String concatenated = ListUtils.reduce(strings, (s1, s2) -> s1 + s2);
        System.out.println("Результат: " + concatenated);

      
        System.out.println("\n2. Сумма всех чисел.");
        List<Integer> numbers = getIntegerListInput();
        Integer sum = ListUtils.reduce(numbers, (n1, n2) -> n1 + n2);
        System.out.println("Сумма: " + sum);

        System.out.println("\n3. Общее количество элементов во всех списках.");
        System.out.println("Введите списки чисел (пустая строка для завершения ввода списков).\n");
        List<List<Integer>> listOfLists = new ArrayList<>();
        while (true) {
            System.out.println("Ввод списка #" + (listOfLists.size() + 1));
            List<Integer> list = getIntegerListInput();
            if (list.isEmpty()) {
                System.out.println("Список пуст, завершаем ввод списков списков.");
                break;
            }
            listOfLists.add(list);
            System.out.println("Добавить еще список? (1 - да, 0 - нет)");
            if (getIntInput("") == 0) break;
        }
        
        List<Integer> sizes = ListUtils.map(listOfLists, List::size);
        Integer totalElements = ListUtils.reduce(sizes, 0, (n1, n2) -> n1 + n2);
        System.out.println("Общее количество элементов: " + totalElements);
    }

    private void demoTask3_4() {
        System.out.println("\n--- Задание 3.4: Коллекционирование ---");

        System.out.println("\n1. Разделение чисел на положительные и отрицательные.");
        List<Integer> numbers = getIntegerListInput();
        Map<Boolean, List<Integer>> partitioned = ListUtils.collect(
            numbers,
            () -> new HashMap<Boolean, List<Integer>>() {{
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }},
            (map, num) -> {
                if (num > 0) map.get(true).add(num);
                else if (num < 0) map.get(false).add(num);
            }
        );
        System.out.println("Положительные: " + partitioned.get(true));
        System.out.println("Отрицательные: " + partitioned.get(false));

        System.out.println("\n2. Группировка строк по длине.");
        List<String> strings = getStringListInput();
        Map<Integer, List<String>> byLength = ListUtils.collect(
            strings,
            HashMap::new,
            (map, str) -> {
                map.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
            }
        );
        System.out.println("Группы по длине: " + byLength);

        System.out.println("\n3. Сбор уникальных строк.");
        List<String> stringsForSet = getStringListInput();
        Set<String> uniqueStrings = ListUtils.collect(
            stringsForSet,
            HashSet::new,
            Set::add
        );
        System.out.println("Уникальные строки: " + uniqueStrings);
    }

    

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine();
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }

    private List<String> getStringListInput() {
        System.out.println("Введите строки через запятую (или Enter для пустого списка):");
        String line = scanner.nextLine();
        if (line.trim().isEmpty()) return new ArrayList<>();
        return Arrays.asList(line.split("\s*,\s*"));
    }

    private List<Integer> getIntegerListInput() {
        System.out.println("Введите целые числа через пробел или запятую:");
        String line = scanner.nextLine();
        if (line.trim().isEmpty()) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        String[] parts = line.split("[,\\s]+");
        for (String part : parts) {
            if (!part.isEmpty()) {
                try {
                    list.add(Integer.parseInt(part));
                } catch (NumberFormatException e) {
                    System.out.println("Пропущено некорректное значение: " + part);
                }
            }
        }
        return list;
    }

    private List<int[]> getListOfIntArraysInput() {
        List<int[]> list = new ArrayList<>();
        System.out.println("Ввод списка массивов.");
        while (true) {
            System.out.println("Введите элементы массива через пробел (или 'end' для завершения ввода массивов):");
            String line = scanner.nextLine();
            if (line.trim().equalsIgnoreCase("end")) break;
            
            String[] parts = line.split("\s+");
            int[] arr = new int[parts.length];
            int idx = 0;
            for (String part : parts) {
                if (!part.isEmpty()) {
                    try {
                        arr[idx++] = Integer.parseInt(part);
                    } catch (NumberFormatException e) {
                        
                    }
                }
            }
            list.add(Arrays.copyOf(arr, idx));
        }
        return list;
    }
}
