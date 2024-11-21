module org.example.mediator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.mediator to javafx.fxml;
    exports org.example.mediator;
}