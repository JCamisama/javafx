package ehu.isad;

import ehu.isad.controller.KautotuKud;
import ehu.isad.controller.LiburuKud;
import ehu.isad.controller.MainKud;
import ehu.isad.controller.XehetasunKud;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Liburuak extends Application {

    private Parent xehetasunakUI;
    private Parent liburuakUI;

    private Stage stage;

    private Scene eszenaLib;
    private Scene eszenaXeh;

    private LiburuKud liburuKud;
    private XehetasunKud xeheKud;


    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("OpenLibrary APIa aztertzen");
        eszenaLib = new Scene(liburuakUI, 700, 450);
        eszenaXeh = new Scene(xehetasunakUI, 700, 450);

        this.eszenaErakutsi(eszenaLib);
    }

    private void pantailakKargatu() throws IOException {

        FXMLLoader loaderLiburuak = new FXMLLoader(getClass().getResource("/Liburuak.fxml"));
        liburuakUI = (Parent) loaderLiburuak.load();
        liburuKud = loaderLiburuak.getController();
        liburuKud.liburuzBete();
        liburuKud.setMainApp(this);

        FXMLLoader loaderXehe = new FXMLLoader(getClass().getResource("/xehetasunak.fxml"));
        xehetasunakUI = (Parent) loaderXehe.load();
        xeheKud = loaderXehe.getController();
        xeheKud.setMainApp(this);
    }




    public static void main(String[] args) {
        launch(args);
    }

    public void liburuakErakutsi() {

        this.eszenaErakutsi(this.eszenaLib);
    }

    public void xehetasunakErakutsi(LiburuDetaileak pDetaileak){
        this.xeheKud.liburuarenDatuakPublikatu(pDetaileak);
        this.eszenaErakutsi(this.eszenaXeh);
    }



    private void eszenaErakutsi(Scene pEszena){
        stage.setScene(pEszena);
        stage.show();
    }
}
