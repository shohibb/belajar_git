module com.example.ellipsedrawing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ellipsedrawing to javafx.fxml;
    exports com.example.ellipsedrawing;
}