module org.ttbdlk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;

    opens org.ttbdlk to javafx.fxml;
    exports org.ttbdlk;
}