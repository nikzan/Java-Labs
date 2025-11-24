package ru.nikzan.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.HashSet;

public class SetUtils {
    private static final Set<Character> CONSTANT = new HashSet<>(Arrays.asList(
        'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
    ));

    public static void printVoicedConsonants(String filePath) {
        Set<Character> foundConsonants = new TreeSet<>(); // TreeSet для сортировки

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                for (char c : word.toCharArray()) {
                    if (CONSTANT.contains(c)) {
                        foundConsonants.add(c);
                    }
                }
            }
            System.out.println("Звонкие согласные в алфавитном порядке: " + foundConsonants);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        }
    }
}
