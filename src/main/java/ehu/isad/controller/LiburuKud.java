package ehu.isad.controller;


import ehu.isad.LiburuDetaileak;
import ehu.isad.LiburuKudeatzailea;
import ehu.isad.Liburuak;
import ehu.isad.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    //Atributuak
    private Liburuak        liburuApp;
    private LiburuDetaileak unekoLiburua;

    @FXML
    private ComboBox    comboZerbitzua;
    @FXML
    private Button      ikusiBotoia;


    //Metodoak
    public void liburuzBete() throws IOException {

        ObservableList<LiburuDetaileak> liburuList = FXCollections.observableArrayList();
        liburuList.addAll(
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("9781491920497"),
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("1491910399"),
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("1491946008"),
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("1491978236"),
                LiburuKudeatzailea.bilatuLiburuaIsbnrekin("9781491906187")
        );

        comboZerbitzua.setItems(liburuList);
        comboZerbitzua.setEditable(false);
        this.comboBoxekoEtiketaEguneratu();
    }

    @FXML
    public void onClickComboBoxen(ActionEvent actionEvent) {

        this.comboBoxekoEtiketaEguneratu();
        this.unekoLiburuaEguneratu();
    }

    @FXML
    public void onClickBotoian(){
        this.liburuApp.xehetasunakErakutsi(this.unekoLiburua);
    }


    private void comboBoxekoEtiketaEguneratu(){

        this.comboZerbitzua.setConverter(new StringConverter<LiburuDetaileak>() {

            @Override
            public String toString(LiburuDetaileak pDetaileak) {
                if (pDetaileak == null) {
                    return "";
                } else {
                    return pDetaileak.getIzena();
                }
            }
            @Override
            public LiburuDetaileak fromString(String izena) {
                return null;
            }
        });
    }

    private void unekoLiburuaEguneratu(){

       // this.comboZerbitzua.setOnAction(e -> {
            this.unekoLiburua = (LiburuDetaileak)this.comboZerbitzua.getValue();
       // });

    }

    public void setMainApp(Liburuak liburuak) {
        this.liburuApp = liburuak;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



}
