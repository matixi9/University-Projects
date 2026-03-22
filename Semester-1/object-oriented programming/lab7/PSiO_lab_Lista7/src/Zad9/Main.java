package Zad9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        System.out.println("--- All numbers ---");
        numbers.stream().forEach(n -> System.out.print(n + " "));

        System.out.println("\n\n--- Even numbers ---");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        long count = numbers.stream().filter(n -> n > 50).count();
        System.out.println("\n\nCount > 50: " + count);

        double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average: " + avg);

        int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("Max: " + max);

        List<Integer> doubledNumbers = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println("\n--- Doubled List ---");
        System.out.println(doubledNumbers);
    }
}
