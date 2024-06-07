module com.example.pathfindercharactercreator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.pathfindercharactercreator to javafx.fxml;
    exports com.example.pathfindercharactercreator;
}