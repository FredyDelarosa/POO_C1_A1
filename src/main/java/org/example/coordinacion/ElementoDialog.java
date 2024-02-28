package org.example.coordinacion;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.example.coordinacion.models.Cajero;
import org.example.coordinacion.models.Corneta;
import org.example.coordinacion.models.Elemento;

import java.util.Optional;

public class ElementoDialog {
    public static Optional<Elemento> mostrarDialogoAgregarElemento() {

        Dialog<Elemento> dialog = new Dialog<>();
        dialog.setTitle("Agregar Nuevo Elemento");
        dialog.setHeaderText("Ingrese los detalles del nuevo elemento");

        ButtonType agregarButtonType = new ButtonType("Agregar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(agregarButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");
        TextField grado = new TextField();
        grado.setPromptText("Grado");
        ComboBox<String> tipoElemento = new ComboBox<>();
        tipoElemento.getItems().addAll("Cajero", "Corneta");
        tipoElemento.setPromptText("Tipo");

        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(nombre, 1, 0);
        grid.add(new Label("Grado:"), 0, 1);
        grid.add(grado, 1, 1);
        grid.add(new Label("Tipo:"), 0, 2);
        grid.add(tipoElemento, 1, 2);

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> nombre.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == agregarButtonType && tipoElemento.getValue() != null) {
                Elemento nuevoElemento = null;
                if (tipoElemento.getValue().equals("Cajero")) {
                    nuevoElemento = new Cajero();
                } else if (tipoElemento.getValue().equals("Corneta")) {
                    nuevoElemento = new Corneta();
                }

                if (nuevoElemento != null) {
                    nuevoElemento.setNombre(nombre.getText());
                    nuevoElemento.setGrado(grado.getText());
                    return nuevoElemento;
                }
            }
            return null;
        });

        Optional<Elemento> resultado = dialog.showAndWait();

        resultado.ifPresent(elemento -> {
            System.out.println("Nombre=" + elemento.getNombre() + ", Grado=" + elemento.getGrado());
        });

        return resultado;
    }
}
