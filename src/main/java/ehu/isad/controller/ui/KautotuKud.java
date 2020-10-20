package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class KautotuKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private ComboBox comboZerbitzua;

    @FXML
    private TextField txtErabiltzaile;

    @FXML
    private TextField txtPasahitza;

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {
        System.out.println(txtErabiltzaile.getText() + ":" + txtPasahitza.getText());
        System.out.println(comboZerbitzua.getValue());

        if ("Flickr".equals(comboZerbitzua.getValue()) &&
                "juanan".equals(txtErabiltzaile.getText()) &&
                "pereira".equals(txtPasahitza.getText())) {

            mainApp.mainErakutsi();
        }
    }

    @FXML
    public void onClickEzabatu(ActionEvent actionEvent){

        //ComboBox-etik ezabatzen
        String ezabatuBeharrekoa = (String) this.comboZerbitzua.getValue();
        this.comboZerbitzua.getItems().remove(ezabatuBeharrekoa);

        //Datu-basetik ezabatzen
        ZerbitzuKud.getInstance().ezabatuZerbitzua(ezabatuBeharrekoa);
    }

    @FXML
    public void onClickGehitu(ActionEvent actionEvent){

        //ComboBox-ean gehitzen
        String gehituBeharrekoa = (String) this.comboZerbitzua.getValue();
        this.comboZerbitzua.getItems().add(gehituBeharrekoa);

        //Datu-basean gehitzen
        ZerbitzuKud.getInstance().gehituZerbitzua(gehituBeharrekoa);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> herrialdeakList = ZerbitzuKud.getInstance().lortuZerbitzuak();
        ObservableList<String> herrialdeak = FXCollections.observableArrayList(herrialdeakList);

        comboZerbitzua.setItems( herrialdeak );
        comboZerbitzua.setEditable(true);

    }

}
