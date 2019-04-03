module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.windhc to javafx.fxml;
    exports com.windhc;
}
