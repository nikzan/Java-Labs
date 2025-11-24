package ru.nikzan.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapUtils {
    public static void generateLogins(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (!scanner.hasNextLine()) {
                System.out.println("Файл пуст.");
                return;
            }
            
            if (scanner.hasNextInt()) {
                scanner.nextLine(); 
            }

            Map<String, Integer> surnameCounts = new HashMap<>();

            System.out.println("Сгенерированные логины:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length < 1) continue;

                String surname = parts[0];
                

                int count = surnameCounts.getOrDefault(surname, 0) + 1;
                surnameCounts.put(surname, count);

                String login = surname;
                if (count > 1) {
                    login += count;
                }
                System.out.println(login);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        }
    }
}
