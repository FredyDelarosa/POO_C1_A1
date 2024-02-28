module org.example.coordinacion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.coordinacion to javafx.fxml;
    exports org.example.coordinacion;
}