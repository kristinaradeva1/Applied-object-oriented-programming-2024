package problem4;
import java.util.Collections;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Roll {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.printf("%-6s%s\n", "Face", "Frequency");
        IntStream.rangeClosed(1, 6_000_000)
                .mapToObj(number -> random.nextInt(1, 7))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .forEach((face, frequency) -> System.out.printf("%-6d%d\n", face, frequency));
    }
}