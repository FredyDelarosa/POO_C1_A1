package org.example.coordinacion;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.coordinacion.models.*;

import java.util.Optional;

public class HelloController {

    @FXML
    private AnchorPane Principal;

    @FXML
    private Button btn_Aelemento;

    @FXML
    private Button btn_Agregar;

    @FXML
    private Button btn_MostrarBDG;

    @FXML
    private Button btn_eliminarBDG;

    @FXML
    private Button btn_eliminar_elememto;

    @FXML
    private Button btn_mostrarElementos;

    @FXML
    private ImageView img_back;

    @FXML
    private Label lbl_Title;

    private CoordinadorBDG coordinadorBDG = new CoordinadorBDG();

    @FXML
    void agregarBanda(MouseEvent event) {
        BDG nuevaBanda = new BDG();
        nuevaBanda.setNombreBanda(showDialog("Ingrese el nombre de la banda de guerra:"));
        nuevaBanda.setNombreSubzona(showDialog("Ingrese el nombre de la subzona:"));
        nuevaBanda.setCategoria(showDialog("Ingrese la categoría:"));
        nuevaBanda.setNombreComandante(showDialog("Ingrese el nombre del comandante:"));
        nuevaBanda.setGradoComandante(showDialog("Ingrese el grado del comandante:"));
        coordinadorBDG.agregarBDG(nuevaBanda);

    }

    private String showDialog(String contentText) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Bandas de guerra");
        dialog.setHeaderText("Ingrese los datos de la BDG");
        dialog.setContentText(contentText);

        Optional<String> result = dialog.showAndWait();
        return result.orElse("");
    }

    @FXML
    void agregarElemento(MouseEvent event) {
        Optional<Elemento> nuevoElemento = ElementoDialog.mostrarDialogoAgregarElemento();
        nuevoElemento.ifPresent(elemento -> {
            coordinadorBDG.agregarElemento(elemento);
        });
    }

    @FXML
    void eliminarBDG(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eliminar BDG");
        dialog.setHeaderText("Eliminar BDG");
        dialog.setContentText("Por favor, ingresa el nombre de la BDG a eliminar:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(nombreBanda -> {
            boolean eliminado = coordinadorBDG.eliminarBDG(nombreBanda);
            if (eliminado) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("BDG Eliminada");
                alert.setHeaderText(null);
                alert.setContentText("La BDG ha sido eliminado exitosamente.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No se encontró la BDG.");
                alert.showAndWait();
            }
        });
    }

    @FXML
    void eliminarElemento(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eliminar Elemento");
        dialog.setHeaderText("Eliminar Elemento");
        dialog.setContentText("Por favor, ingresa el nombre del elemento a eliminar:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(nombreElemento -> {
            boolean eliminado = coordinadorBDG.eliminarElemento(nombreElemento);
            if (eliminado) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Elemento Eliminado");
                alert.setHeaderText(null);
                alert.setContentText("El elemento ha sido eliminado exitosamente.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No se encontró el elemento.");
                alert.showAndWait();
            }
        });
    }

    @FXML
    void mostrarBanda(MouseEvent event) {
        //CoordinadorBDG coordinadorBDG = new CoordinadorBDG();
        String infoBandas = coordinadorBDG.mostrarBandasDeGuerra();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bandas de Guerra");
        alert.setHeaderText("Información de Bandas de Guerra");
        alert.setContentText(infoBandas);
        alert.getDialogPane().setPrefSize(480, 320);
        alert.showAndWait();
    }

    @FXML
    void mostrarElementos(MouseEvent event) {

        String elementosPorCategoria = coordinadorBDG.mostrarElementosPorCategoria();
        System.out.println("Elementos por Categoría: " + elementosPorCategoria);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Elementos por Categoría");
        alert.setHeaderText(null);
        alert.setContentText(elementosPorCategoria);
        alert.showAndWait();
    }


}
