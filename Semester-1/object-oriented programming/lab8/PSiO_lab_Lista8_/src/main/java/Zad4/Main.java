package Zad4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Kupić mleko", "Łaciate 3.2%", false, LocalDate.now().plusDays(1)));
        tasks.add(new Task("Zrobić laborki", "Lista 8 z Javy", true, LocalDate.now()));

        File file = new File("data/tasks_lib.json");
        file.getParentFile().mkdirs();

        mapper.writeValue(file, tasks);
        System.out.println("Zapisano JSON do: " + file.getPath());

        List<Task> loadedTasks = mapper.readValue(file, new TypeReference<List<Task>>(){});

        System.out.println("Wczytane zadania:");
        for (Task t : loadedTasks) {
            System.out.println(t);
        }
    }
}
