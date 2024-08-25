package problem3;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        Random random = new Random();
        List<Character> list = IntStream.range(0,30)
                .mapToObj(number -> (char) ('a' + random.nextInt(26)))
                .collect(Collectors.toList());
        System.out.println(list);

        //a
        List<Character> sorted = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ascending order: " + sorted);

        //b
        sorted = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Descending order: " + sorted);

        //c
        sorted = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ascending order ? .... " + sorted);

        //d
        System.out.printf("%s\t%s\n",
                "Letter", "Frequency");
        list.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry-> System.out.printf("%c\t\t%d\n",
                        entry.getKey(), entry.getValue()));
    }
}
