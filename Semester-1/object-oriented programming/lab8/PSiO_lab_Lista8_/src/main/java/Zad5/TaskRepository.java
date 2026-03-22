package Zad5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static final String FILE_PATH = "data/tasks.json";
    private List<Task> tasks;
    private final ObjectMapper mapper;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public void loadData() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try {
                tasks = mapper.readValue(file, new TypeReference<List<Task>>() {});
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            tasks = new ArrayList<>();
        }
    }

    public void saveData() {
        try {
            Path path = Paths.get(FILE_PATH);
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            mapper.writeValue(new File(FILE_PATH), tasks);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}