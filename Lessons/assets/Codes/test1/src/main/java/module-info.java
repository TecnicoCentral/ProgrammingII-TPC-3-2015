module test1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens test1 to javafx.fxml;
    exports test1;
}
