package server;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

import data.*;
import database.DatabaseConnectionException;
import database.NoValueException;
import mining.*;

public class ServerOneClient extends Thread {

    private Socket socket;                      //Terminale lato server del canale tramite cui avviene lo scambio di oggetti client-server
    private ObjectInputStream in;                //flusso di oggetti in input al server.
    private ObjectOutputStream out;             //flusso di oggetti in output dal server al client.


    /**
     * costruttore. Inizia il membro this.socket con il parametro in input al costruttore. Inizializza in e out, avvia
     * il thread invocando il metodo start() (ereditato da Thread)
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param s oggetto di tipo socket
     */
    protected ServerOneClient(Socket s) throws IOException {
        socket = s;
        in = new ObjectInputStream((socket.getInputStream()));
        out = new ObjectOutputStream(socket.getOutputStream());
        start();
    }


    /**
     * Ridefinisce il metodo run della classe Thread (variazione funzionale). Gestisce le richieste del client
     * (apprendere pattern/regole e popolare con queste archive; salvare archive in un file, avvalorare archive con
     * oggetto serializzato nel file)
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     */
    public void run() {

        try {
            while (true) {

                try {
                    int opzione = (int) in.readObject();
                    float minsup = (float) in.readObject();
                    float minGr = (float) in.readObject();
                    String targetName = (String) in.readObject();
                    String backgroundName = (String) in.readObject();
                    String archive = null ;

                    Data dataTarget = null;
                    Data dataBackground = null;
                    FrequentPatternMiner fpMiner = null;

                    String s = null;
                    if (opzione == 1) {

                        try {
                            dataTarget = new Data(targetName);

                            try {
                                fpMiner = new FrequentPatternMiner(dataTarget, minsup);

                                try {
                                    archive = ("FP_" + targetName + "_minSup" + minsup);
                                    fpMiner.salva(archive);

                                   // fpMiner.salva("FP_playtennis_minSup" + minsup);

                                } catch (IOException e) {
                                    s = "Errore";
                                    out.writeObject(s);
                                }

                                s=fpMiner.toString();

                            } catch (EmptySetException e) {
                                s = "errore";
                            }

                        } catch (SQLException e) {
                            s = "errore";
                        }

                        out.writeObject(s);

                    try{
                        dataBackground = new Data(backgroundName);

                        try {

                            EmergingPatternMiner epMiner = new EmergingPatternMiner(dataBackground, fpMiner, minGr);

                            try {

                                archive = "EP_" + targetName + "_minSup" + minsup + "_minGr" + minGr;
                                epMiner.salva(archive);

                                //epMiner.salva("EP_playtennis_minSup" + minsup + "_minGr" + minGr);

                            } catch (IOException e) {
                                s = "Errore";
                                out.writeObject(s);
                            }

                           s = epMiner.toString();

                        } catch (EmptySetException e) {
                            s = "errore";
                        }

                    }
                    catch (SQLException e) {
                        s = "errore";
                    }
                        out.writeObject(s);
                    }



                    if (opzione == 2) {
                        try {

                            archive = "FP_" + targetName + "_minSup" + minsup;
                            fpMiner = FrequentPatternMiner.carica(archive);

                            //fpMiner = FrequentPatternMiner.carica("FP_playtennis_minSup" + minsup);

                            s = fpMiner.toString();
                        } catch (ClassNotFoundException | IOException e) {
                            s = "errore";
                        }
                            out.writeObject(s);


                        try{

                            archive = "EP_" + targetName + "_minSup" + minsup + "_minGr" + minGr;
                            EmergingPatternMiner epMiner = EmergingPatternMiner.carica(archive);

                            //EmergingPatternMiner epMiner = EmergingPatternMiner.carica("EP_playtennis_minSup" + minsup + "_minGr" + minGr);

                            s = epMiner.toString();
                        } catch (ClassNotFoundException | IOException e) {
                            s = "errore";
                        }
                        out.writeObject(s);
                    }


                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch(IOException | NoValueException | DatabaseConnectionException e) {

            System.out.println("client disconnesso");

        } finally {
            try{
                socket.close();
            }
            catch(IOException e){
                System.out.println("Socket not closed");
            }
        }
    }
}
