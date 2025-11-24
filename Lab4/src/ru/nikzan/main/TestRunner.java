package ru.nikzan.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.nikzan.functional.ListUtils;
import ru.nikzan.generics.Box;
import ru.nikzan.generics.BoxUtils;

public class TestRunner {

	public static void main(String[] args) {
		System.out.println("=== АВТОМАТИЧЕСКОЕ ТЕСТИРОВАНИЕ LAB4 ===\n");

		testTask1_1();
		testTask2();
		testTask3_1();
		testTask3_2();
		testTask3_3();
		testTask3_4();

		System.out.println("\n=== ВСЕ ТЕСТЫ ЗАВЕРШЕНЫ ===");
	}

	private static void testTask1_1() {
		System.out.println("--- Тест 1.1: Обобщенная коробка ---");
        
		
		Box<Integer> intBox = new Box<>();
		System.out.println("Создана пустая коробка: " + intBox);
        
		try {
			intBox.put(3);
			System.out.println("Положили 3: " + intBox);
		} catch (IllegalStateException e) {
			System.out.println("Ошибка: " + e.getMessage());
		}

		try {
			intBox.put(5); 
		} catch (IllegalStateException e) {
			System.out.println("Попытка положить в полную коробку: " + e.getMessage());
		}

		
		extractAndPrint(intBox);
        
		
		Box<String> strBox = new Box<>();
		strBox.put("Hello");
		System.out.println("Коробка со строкой: " + strBox);
	}

	private static void testTask2() {
		System.out.println("\n--- Тест 2: Поиск максимума ---");
        
		Box<Integer> b1 = new Box<>();
		b1.put(10);
        
		Box<Double> b2 = new Box<>();
		b2.put(20.5);
        
		Box<Float> b3 = new Box<>();
		b3.put(15.7f);
        
		Box<Integer> b4 = new Box<>(); 

		System.out.println("Коробки: " + b1 + ", " + b2 + ", " + b3 + ", " + b4);
        
		try {
			double max = BoxUtils.findMax(b1, b2, b3, b4);
			System.out.println("Максимум: " + max + " (Ожидается 20.5)");
		} catch (Exception e) {
			System.out.println("Ошибка: " + e.getMessage());
		}
	}

	private static void testTask3_1() {
		System.out.println("\n--- Тест 3.1: Функция (Map) ---");
        
		
		List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
		List<Integer> lengths = ListUtils.map(strings, String::length);
		System.out.println("Строки: " + strings);
		System.out.println("Длины: " + lengths + " (Ожидается [6, 5, 2])");

		
		List<Integer> numbers = Arrays.asList(1, -3, 7);
		List<Integer> abs = ListUtils.map(numbers, Math::abs);
		System.out.println("Числа: " + numbers);
		System.out.println("Модули: " + abs + " (Ожидается [1, 3, 7])");

		
		List<int[]> arrays = Arrays.asList(
			new int[]{1, 2, 3},
			new int[]{-5, -1, -10},
			new int[]{100}
		);
		List<Integer> maxs = ListUtils.map(arrays, arr -> {
			int m = Integer.MIN_VALUE;
			for(int i : arr) if(i > m) m = i;
			return m;
		});
		System.out.println("Максимумы массивов: " + maxs + " (Ожидается [3, -1, 100])");
	}

	private static void testTask3_2() {
		System.out.println("\n--- Тест 3.2: Фильтр ---");
        
		
		List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
		List<String> shortStr = ListUtils.filter(strings, s -> s.length() < 3);
		System.out.println("Строки < 3 символов: " + shortStr + " (Ожидается [zx])");

		List<Integer> numbers = Arrays.asList(1, -3, 7);
		List<Integer> positive = ListUtils.filter(numbers, n -> n > 0);
		System.out.println("Положительные: " + positive + " (Ожидается [1, 7])");

		
		List<int[]> arrays = Arrays.asList(
			new int[]{1, 2, 3},    
			new int[]{-1, -2, -3},  
			new int[]{0, -5}       
		);
		List<int[]> noPositive = ListUtils.filter(arrays, arr -> {
			for(int i : arr) if(i > 0) return false;
			return true;
		});
		System.out.println("Массивы без положительных: " + noPositive.size() + " шт. (Ожидается 2)");
	}

	private static void testTask3_3() {
		System.out.println("\n--- Тест 3.3: Сокращение (Reduce) ---");
        
		
		List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
		String concat = ListUtils.reduce(strings, (s1, s2) -> s1 + s2);
		System.out.println("Склейка: " + concat + " (Ожидается qwertyasdfgzx)");

		
		List<Integer> numbers = Arrays.asList(1, -3, 7);
		Integer sum = ListUtils.reduce(numbers, (n1, n2) -> n1 + n2);
		System.out.println("Сумма: " + sum + " (Ожидается 5)");

		
		List<List<Integer>> lists = Arrays.asList(
			Arrays.asList(1, 2),
			Arrays.asList(3, 4, 5),
			Arrays.asList(6)
		);
		List<Integer> sizes = ListUtils.map(lists, List::size);
		Integer total = ListUtils.reduce(sizes, 0, (a, b) -> a + b);
		System.out.println("Всего элементов: " + total + " (Ожидается 6)");
	}

	private static void testTask3_4() {
		System.out.println("\n--- Тест 3.4: Коллекционирование ---");
        
		List<Integer> numbers = Arrays.asList(1, -3, 7, -2, 0);
		Map<Boolean, List<Integer>> split = ListUtils.collect(
			numbers,
			() -> {
				Map<Boolean, List<Integer>> m = new HashMap<>();
				m.put(true, new ArrayList<>());
				m.put(false, new ArrayList<>());
				return m;
			},
			(map, n) -> {
				if (n > 0) map.get(true).add(n);
				else if (n < 0) map.get(false).add(n);
			}
		);
		System.out.println("Разбиение +/-: " + split);

		List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");
		Map<Integer, List<String>> byLen = ListUtils.collect(
			strings,
			HashMap::new,
			(map, s) -> map.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s)
		);
		System.out.println("По длине: " + byLen);

		List<String> dups = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
		Set<String> unique = ListUtils.collect(dups, HashSet::new, Set::add);
		System.out.println("Уникальные: " + unique);
	}

	
	private static void extractAndPrint(Box<Integer> box) {
		Integer v = box.take();
		System.out.println("Извлекли через метод: " + v);
		System.out.println("Коробка после извлечения: " + box);
	}

}

