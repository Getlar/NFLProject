module org.ttbdlk {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.ttbdlk to javafx.fxml;
    exports org.ttbdlk;
}