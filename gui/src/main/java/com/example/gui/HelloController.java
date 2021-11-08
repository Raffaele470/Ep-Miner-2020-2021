package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URISyntaxException;


public class HelloController {


    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    static int scelta;


    /**
     * metodo eseguito una volta premuto il tasto Nuova Scoperta nell'interfaccia. Carica la nuova schermata.
     * @param actionEvent
     * @throws IOException
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public void nuovaRicerca(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scelta = 1;
    }


    /**
     * metodo eseguito una volta premuto il tasto di Ricerca In Archivio nell'interfaccia. Carica la nuova schermata.
     * @param actionEvent
     * @throws IOException
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public void ricercaArchivio(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scelta = 2;
    }

    /**
     * metodo eseguito una volta premuto il tasto Crediti nell'interfaccia. Carica la nuova schermata.
     * @param actionEvent
     * @throws IOException
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public void crediti(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample4.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * metodo eseguito una volta premuto il tasto di Segnala Un Problema nell'interfaccia. Carica la nuova schermata.
     * @param actionEvent
     * @throws IOException
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public void segnalaProblema(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample5.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * metodo eseguito una volta premuto il tasto GitHub nell'interfaccia. Apre la pagina web della repository del progetto.
     * @param actionEvent
     * @throws URISyntaxException
     * @throws IOException
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public void linkgit(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Runtime.getRuntime().exec("cmd.exe /c start iexplore " + "https://github.com/AleCongi/Metodi_Avanzati_di_Programmazione");

    }
}

