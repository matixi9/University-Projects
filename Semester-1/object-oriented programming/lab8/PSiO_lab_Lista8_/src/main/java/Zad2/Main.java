package Zad2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String inputPath = "app.log";
        String outputPath = "logs/errors.log";

        prepareLogFile(inputPath);

        int errorCount = 0;

        try {
            Files.createDirectories(Paths.get("logs"));

            try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("ERROR")) {
                        writer.write(line);
                        writer.newLine();
                        errorCount++;
                    }
                }
            }

            System.out.println("Liczba błędów: " + errorCount);
            System.out.println("Plik błędów zapisano do: " + outputPath);

        } catch (IOException e) {
            System.err.println("Błąd operacji na plikach: " + e.getMessage());
        }
    }

    private static void prepareLogFile(String path) {
        String content = """
                2025-11-01 10:15:32 INFO User logged in
                2025-11-01 10:16:01 ERROR Cannot connect to DB
                2025-11-01 10:16:10 WARN Slow response
                2025-11-01 10:17:45 ERROR Timeout while reading
                """;
        try { Files.writeString(Paths.get(path), content); } catch (IOException e) {}
    }
}
