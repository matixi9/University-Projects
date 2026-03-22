package org.example.psio_lab_10;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ToDoController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<Priority> priorityComboBox;

    @FXML
    private ListView<Task> taskListView;

    @FXML
    private TextArea detailsArea;

    private TaskService taskService;

    @FXML
    public void initialize() {
        taskService = new TaskService();

        priorityComboBox.getItems().setAll(Priority.values());
        priorityComboBox.getSelectionModel().select(Priority.MEDIUM);

        taskListView.setItems(taskService.getTasks());

        taskListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTaskDetails(newValue)
        );
    }

    private void showTaskDetails(Task task) {
        if (task != null) {
            String details = "Title: " + task.getTitle() + "\n" +
                    "Status: " + (task.isDone() ? "Done" : "To Do") + "\n" +
                    "Priority: " + task.getPriority() + "\n" +
                    "Date: " + (task.getDate() != null ? task.getDate() : "None") + "\n\n" +
                    "Description:\n" + task.getDescription();
            detailsArea.setText(details);
        } else {
            detailsArea.setText("");
        }
    }

    @FXML
    public void onAddTaskClick() {
        try {
            String title = titleField.getText();
            String desc = descriptionArea.getText();
            var date = datePicker.getValue();
            Priority priority = priorityComboBox.getValue();

            Task newTask = new Task(title, desc, date, priority);
            taskService.addTask(newTask);
            clearForm();

        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.WARNING, "Błąd dodawania", "Tytuł zadania jest wymagany!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Błąd", "Wystąpił nieoczekiwany błąd: " + e.getMessage());
        }
    }

    @FXML
    public void onRemoveTaskClick() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskService.removeTask(selectedTask);
            detailsArea.clear();
        } else {
            showAlert(Alert.AlertType.WARNING, "Błąd usuwania", "Wybierz zadanie do usunięcia.");
        }
    }

    @FXML
    public void onMarkDoneClick() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();

        if (selectedTask != null) {
            taskService.toggleTaskStatus(selectedTask);
            taskListView.refresh();
            showTaskDetails(selectedTask);
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Informacja", "Wybierz zadanie z listy, aby zmienić jego status.");
        }
    }

    private void clearForm() {
        titleField.clear();
        descriptionArea.clear();
        datePicker.setValue(null);
        priorityComboBox.getSelectionModel().select(Priority.MEDIUM);
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}