package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController5 {


    @FXML
    private Stage stage;
    private Scene scene;





    /**
     * metodo che viene eseguito quando si clicca sul bottone "Torna al menu" nell'interfaccia. Permette di tornare al menù iniziale.
     * @param actionEvent
     * @throws IOException
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public void tornaMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }





}

