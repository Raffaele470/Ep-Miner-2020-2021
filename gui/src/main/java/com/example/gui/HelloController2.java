package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;



public class HelloController2 {


    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField campoMinSup;
    @FXML
    private TextField campoMinGrowRate;
    @FXML
    private TextField campoNomeTarget;
    @FXML
    private TextField campoNomeBackground;

    float minsup;
    float minGrowRate;
    String nomeTarget;
    String nomeBackground;

    int opzione;

    static String fpMiner;
    static String epMiner;

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
     * Metodo che viene eseguito quando si clicca sul bottone "conferma" nell'interfaccia. Permette di passare alla schermata successiva dopo aver acquisito i dati e avere contattato il server.
     * @param actionEvent
     * @throws IOException
     * @throws ClassNotFoundException
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public void conferma(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        HelloController controller = loader.getController();

        opzione = controller.scelta;

        try {
            minsup = Float.parseFloat(campoMinSup.getText());
            minGrowRate = Float.parseFloat(campoMinGrowRate.getText());
            nomeTarget = campoNomeTarget.getText();
            nomeBackground = campoNomeBackground.getText();

        } catch (Exception e) {
            System.out.println(e);
        }

        if (((minGrowRate > 0) && (minsup > 0 && minsup <= 1)) && campoMinSup.getText() != "" && campoMinGrowRate.getText() != "" && nomeTarget != "" && nomeBackground != "") {

            Socket socket;
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            final int PORT = 8080;
            System.out.println("addr = " + addr + "\nport=" + PORT);
            socket = new Socket(addr, PORT);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            String nameFile = nomeTarget + "_" + nomeBackground;

            try {
                out.writeObject(opzione);
                out.writeObject(minsup);
                out.writeObject(minGrowRate);
                out.writeObject(nomeTarget);
                out.writeObject(nomeBackground);

                fpMiner = (String) (in.readObject());
                epMiner = (String) (in.readObject());

                //System.out.println(fpMiner);

                //System.out.println(epMiner);

                if(fpMiner.equals("errore")){
                    fpMiner = "Errore!                                                                         \n\n\n\n\n\n\n\n\n\n\n\n\n\n";
                }

                if(epMiner.equals("errore")){
                    epMiner = "Errore!                                                                         \n\n\n\n\n\n\n\n\n\n\n\n\n\n";
                }

                root = FXMLLoader.load(getClass().getResource("sample3.fxml"));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

