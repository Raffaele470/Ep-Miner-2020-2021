package mining;

import data.*;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import utility.ComparatorGrowRate;

public class EmergingPatternMiner implements Iterable<EmergingPattern>, Serializable{

    private List<EmergingPattern> epList=new LinkedList<EmergingPattern>();

    /**
     * costruttore dell'EmergingPatternMiner
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param dataBackground oggetto di tipo data
     * @param fpList oggetto di tipo FrequentPatternMiner
     * @param minG valore reale indicante il minG
     *
     */
    public EmergingPatternMiner(Data dataBackground,FrequentPatternMiner fpList, float minG) throws EmptySetException{

        boolean OK = false;

        List temp = fpList.getOutputFP();
        Iterator i = temp.listIterator();
        while (i.hasNext()){
            EmergingPattern var = null;
            try {
                var = computeEmergingPattern(dataBackground, (FrequentPattern) i.next(), minG);
            }catch(EmergingPatternException e){
                System.out.println("");
            }
            if (var != null){
                epList.add (var);
                OK = true;
            }
        }
        epList.sort(new ComparatorGrowRate());
        if(!OK) throw new EmptySetException();
    }


    /**
     * restituisce un valore float dopo aver computato il GrowRate
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param dataBackground oggetto di tipo data
     * @param fp oggetto di tipo FrequentPattern
     *
     */
    protected float computeGrowRate(Data dataBackground, FrequentPattern fp){
        return fp.getSupport() / fp.computeSupport(dataBackground);
    }


    /**
     * restituisce un nuovo EmergingPattern dopo aver richiamato computeGrowRate e verificato se superiore o uguale al minGR
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param dataBackground oggetto di tipo data
     * @param fp oggetto di tipo FrequentPattern
     * @param minGR valore reale indicante il minGR
     *
     */
    protected EmergingPattern computeEmergingPattern(Data dataBackground, FrequentPattern fp, float minGR) throws EmergingPatternException{
        float growRate = computeGrowRate(dataBackground, fp);
        if (growRate >= minGR)
            return new EmergingPattern (fp, growRate);
        else throw new EmergingPatternException();

    }


    /**
     *
     */
    public String toString() {
        String output ="";
        int i = 0;
        Iterator p = epList.listIterator();
        while (p.hasNext()) {
            output += Integer.toString(i + 1) + ":" + p.next() + "\n";
            i++;
        }
        return output;
    }

    /**
     * iteratore
     */
    @Override
    public Iterator<EmergingPattern> iterator() {
        return null;
    }


    /**
     * permette di salvare l'emerging pattern miner all'interno di un file cosi da permettere la serializzazione
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param nomeFile stringa indicante il nome del file
     *
     */
    public void salva(String nomeFile) throws FileNotFoundException, IOException {

        FileOutputStream file = new FileOutputStream(nomeFile + ".dat");

        ObjectOutputStream outStream = new ObjectOutputStream(file);

        outStream.writeObject(this);

    }

    /**
     * permette di caricare da file un emerging pattern miner
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param nomeFile stringa indicante il nome del file
     *
     */
    public static EmergingPatternMiner carica(String nomeFile) throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream inFile = new FileInputStream(nomeFile + ".dat");
        ObjectInputStream inStream = new ObjectInputStream(inFile);
        EmergingPatternMiner ep  = (EmergingPatternMiner) inStream.readObject();
        return ep;
    }


}