package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController3 {


    @FXML
    private Stage stage;
    private Scene scene;
    @FXML
    public Label label1;
    @FXML
    public Label label2;




    private String fpMiner;
    private String epMiner;


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


    /**
     * override del metodo initialize. Eseguito quando viene caricata la 3 schermata. Viene stampato il risultato nei rispettivi label.
     * @throws IOException
     * @throws ClassNotFoundException
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public void initialize() throws IOException, ClassNotFoundException {

       FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"));
       Parent root = loader.load();
       HelloController2 controller = loader.getController();


        fpMiner = controller.fpMiner;
        epMiner = controller.epMiner;

        label1.setText(fpMiner);
        label2.setText(epMiner);

    }


}

