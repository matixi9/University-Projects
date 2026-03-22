module org.example.psio_lab_10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.psio_lab_10 to javafx.fxml;
    exports org.example.psio_lab_10;
}