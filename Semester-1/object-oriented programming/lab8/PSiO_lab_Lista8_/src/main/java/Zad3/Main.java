package Zad3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String csvPath = "products.csv";
        String reportPath = "data/report.txt";

        prepareCsvFile(csvPath);

        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String category = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim().replace(",", "."));

                    products.add(new Product(id, name, category, price));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        double totalPrice = products.stream().mapToDouble(Product::getPrice).sum();

        Map<String, Double> averageByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));

        try {
            Files.createDirectories(Paths.get("data"));
            try (PrintWriter pw = new PrintWriter(new FileWriter(reportPath))) {
                pw.println("Liczba produktów: " + products.size());
                pw.printf(Locale.US, "Suma cen: %.2f%n", totalPrice);
                pw.println("Średnia cena wg kategorii:");

                averageByCategory.forEach((cat, avg) ->
                        pw.printf(Locale.US, "%s -> %.2f%n", cat, avg)
                );

                System.out.println("Raport zapisano w: " + reportPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void prepareCsvFile(String path) {
        String content = """
                id; name;category; price
                1; Klawiatura mechaniczna; peryferie; 399.99
                2;Mysz bezprzewodowa; peryferie; 129.90
                3; Monitor 24"; monitory; 799.00
                """;
        try { Files.writeString(Paths.get(path), content); } catch (IOException e) {}
    }
}