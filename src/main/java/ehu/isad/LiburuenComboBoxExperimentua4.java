package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;

public class LiburuenComboBoxExperimentua4 extends Application {

    private Text label;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Liburuen ComboBoxExperimentua");

        ComboBox comboBox = new ComboBox();

        ObservableList<LiburuDetaileak> liburuList = FXCollections.observableArrayList();
        liburuList.addAll(
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("9781491920497"),
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("1491910399"),
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("1491946008"),
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("1491978236"),
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("9781491906187")
        );

        comboBox.setItems(liburuList);
        comboBox.setEditable(false);

        comboBox.setOnAction(e -> {
            LiburuDetaileak libHau = (LiburuDetaileak)comboBox.getValue();
            String textuEguneratua = libHau.getIzena() + "\n" +
                    libHau.getOrriKop() + "\n" +
                    libHau.getArgitaletxeak()[0];
            this.label.setText(textuEguneratua);

        });


        comboBox.setConverter(new StringConverter<LiburuDetaileak>() {

            @Override
            public String toString(LiburuDetaileak detaileak) {
                if (detaileak == null) {
                    return "";
                } else {
                    return detaileak.getIzena();
                }
            }

            @Override
            public LiburuDetaileak fromString(String izena) {
                return null;
            }
        });

        comboBox.valueProperty().addListener((obs, oldval, newval) -> {
            System.out.println(oldval);
            System.out.println(newval);
        });

        this.label  = new Text();
        this.label.wrappingWidthProperty().set(400);

        VBox vbox = new VBox(comboBox, this.label);
        vbox.setPadding(new Insets(0, 0, 0, 20));
        vbox.setAlignment(Pos.BASELINE_CENTER);

        Scene scene = new Scene(vbox, 400, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
