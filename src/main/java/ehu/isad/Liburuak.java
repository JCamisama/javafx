package ehu.isad;

import ehu.isad.controller.LiburuKud;
import ehu.isad.controller.XehetasunKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Liburuak extends Application {

    //Atributuak
    private Parent xehetasunakUI;
    private Parent liburuakUI;

    private Stage stage;

    private Scene eszenaLib;
    private Scene eszenaXeh;

    private LiburuKud liburuKud;
    private XehetasunKud xeheKud;

    private String liburuenLeihoa       = "/Liburuak.fxml";
    private String xehetasunenLeihoa    = "/xehetasunak.fxml";


    //Metodoak
    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("OpenLibrary APIa aztertzen");
        eszenaLib = new Scene(liburuakUI, 450, 200);
        eszenaXeh = new Scene(xehetasunakUI, 900, 500);

        this.eszenaErakutsi(eszenaLib);
    }


    private void pantailakKargatu() throws IOException {

        FXMLLoader loaderLiburuak = new FXMLLoader(getClass().getResource(liburuenLeihoa));
        liburuakUI = (Parent) loaderLiburuak.load();
        liburuKud = loaderLiburuak.getController();
        liburuKud.liburuzBete();
        liburuKud.setMainApp(this);

        FXMLLoader loaderXehe = new FXMLLoader(getClass().getResource(xehetasunenLeihoa));
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
