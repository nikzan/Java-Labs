package ru.nikzan.streams;

import ru.nikzan.geometry.Point;
import ru.nikzan.geometry.Polyline;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {

    public static Polyline processPoints(List<Point> points) {
        List<Point> processed = points.stream()
                .distinct() 
                .sorted(Comparator.comparingDouble(Point::getX)) 
                .map(p -> new Point(p.getX(), Math.abs(p.getY()))) 
                .distinct() 
                .collect(Collectors.toList());
        
        return new Polyline(processed);
    }

    public static Map<Integer, List<String>> processPeople(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .map(line -> line.split(":"))
                    .filter(parts -> parts.length == 2) 
                    .filter(parts -> !parts[1].trim().isEmpty()) 
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1].trim()), 
                            Collectors.mapping(
                                    parts -> capitalize(parts[0].trim()), 
                                    Collectors.toList()
                            )
                    ));
        }
    }

    private static String capitalize(String name) {
        if (name == null || name.isEmpty()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
