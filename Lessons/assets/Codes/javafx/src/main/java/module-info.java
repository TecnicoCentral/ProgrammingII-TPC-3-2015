module gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens gui to javafx.fxml;
    exports gui;
}
