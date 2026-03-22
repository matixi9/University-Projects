package Zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath = (args.length > 0) ? args[0] : "data/input.txt";

        ensureTestFileExists(filePath);

        System.out.println("Wczytywanie pliku: " + filePath);
        int lineCount = 0;
        int displayIndex = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                System.out.println(displayIndex + ": " + line);
                displayIndex++;
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku: " + e.getMessage());
        }

        System.out.println("liczba linii: " + lineCount);
    }

    private static void ensureTestFileExists(String pathStr) {
        try {
            Path path = Paths.get(pathStr);
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.writeString(path, "treść linii 1\n  \n   \ntreść linii 2\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}