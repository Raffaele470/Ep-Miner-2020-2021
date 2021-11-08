package mining;

import utility.*;
import data.*;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class FrequentPatternMiner implements Iterable<FrequentPattern>, Serializable{

    private List<FrequentPattern> outputFP = new LinkedList<FrequentPattern>();

    /**
     * costruttore del FrequentPatternMiner
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param data oggetto di tipo data
     * @param minSup valore reale indicante il minSup
     *
     */
    public FrequentPatternMiner(Data data, float minSup) throws EmptySetException{
        Queue<FrequentPattern> fpQueue = new Queue();

        boolean OK = false;

        for (int i = 0; i < data.getNumberOfAttributes(); i++) {

            Attribute currentAttribute = data.getAttribute(i);

            if (currentAttribute instanceof DiscreteAttribute) {

                for (int j = 0; j < ((DiscreteAttribute) currentAttribute).getNumberOfDistinctValues(); j++) {
                    DiscreteItem item = new DiscreteItem((DiscreteAttribute) currentAttribute, ((DiscreteAttribute) currentAttribute).getValue(j));
                    FrequentPattern fp = new FrequentPattern();
                    fp.addItem(item);

                    fp.setSupport(fp.computeSupport(data));

                    if (fp.getSupport() >= minSup) { // 1-FP CANDIDATE

                        fpQueue.enqueue(fp);
                        //System.out.println(fp);
                        outputFP.add(fp);
                        OK = true;
                    }

                }
            } else if (currentAttribute instanceof ContinuousAttribute) {

                ContinuousAttribute continuousAttribute = (ContinuousAttribute) currentAttribute;
                Iterator<Float> iter = continuousAttribute.iterator();
                float min = iter.next();
                while (iter.hasNext()) {
                    float next = iter.next();
                    ContinuousItem item = new ContinuousItem(continuousAttribute, new Interval(min, next));
                    FrequentPattern fp = new FrequentPattern();
                    fp.addItem(item);
                    fp.setSupport(fp.computeSupport(data));
                    if (fp.getSupport() >= minSup) { // 1-FP CANDIDATE

                        fpQueue.enqueue(fp);
                        //System.out.println(fp);
                        outputFP.add(fp);
                        OK = true;
                    }
                    min = next;
                }
            }
        }

        if (OK) {
            try {
               outputFP = expandFrequentPatterns(data, minSup, fpQueue, outputFP);
                outputFP.sort(FrequentPattern::compareTo);
            } catch (EmptyQueueException e){
                System.out.println("LISTA VUOTA");
            }
        } else throw new EmptySetException();
    }

    /**
     * restituisce una lista dopo aver espanso i frequent patterns
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param data oggetto di tipo data
     * @param minSup valore reale indicante il minSup
     * @param fpQueue coda di FrequentPattern
     * @param outputFP Lista
     *
     */
    private List expandFrequentPatterns(Data data, float minSup, Queue<FrequentPattern> fpQueue, List outputFP) throws EmptyQueueException {
        if (fpQueue.isEmpty()) {
            throw new EmptyQueueException();
        } else {
            while (!fpQueue.isEmpty()) {
                FrequentPattern fp = (FrequentPattern) fpQueue.first(); //fp to be refined
                fpQueue.dequeue();
                for (int i = 0; i < data.getNumberOfAttributes(); i++) {
                    boolean found = false;
                    for (int j = 0; j < fp.getPatternLength(); j++) //the new item should involve an attribute different form attributes already involved into the items of fp
                        if (fp.getItem(j).getAttribute().equals(data.getAttribute(i))) {
                            found = true;
                            break;
                        }
                    if (!found) //data.getAttribute(i) is not involve into an item of fp
                    {

                        if(data.getAttribute(i) instanceof DiscreteAttribute){
                            for (int j = 0; j < ((DiscreteAttribute) data.getAttribute(i)).getNumberOfDistinctValues(); j++) {
                                DiscreteItem item = new DiscreteItem((DiscreteAttribute) data.getAttribute(i), ((DiscreteAttribute) (data.getAttribute(i))).getValue(j));
                                FrequentPattern newFP = refineFrequentPattern(fp, item); //generate refinement
                                newFP.setSupport(newFP.computeSupport(data));
                                if (newFP.getSupport() >= minSup) {
                                    fpQueue.enqueue(newFP);
                                    //System.out.println(newFP);
                                    outputFP.add(newFP);
                                }
                            }
                        }

                        else if(data.getAttribute(i) instanceof ContinuousAttribute){

                            ContinuousAttribute continuousAttribute = (ContinuousAttribute) data.getAttribute(i);
                            Iterator<Float> iter = continuousAttribute.iterator();
                            float min = iter.next();
                            while (iter.hasNext()) {
                                float next = iter.next();
                                 ContinuousItem item = new ContinuousItem(continuousAttribute, new Interval(min, next));
                                FrequentPattern newFP = refineFrequentPattern(fp, item); //generate refinement
                                newFP.setSupport(newFP.computeSupport(data));
                                if (newFP.getSupport() >= minSup) {
                                    fpQueue.enqueue(newFP);
                                    //System.out.println(newFP);
                                    outputFP.add(newFP);
                                }
                                min = next;
                            }
                        }
                    }
                }
            }
            return outputFP;
        }
    }

    /**
     * restituisce un frequentPattern ridefinito
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param FP oggetto di tipo FrequentPattern
     * @param item oggetto di tipo Item
     *
     */
    protected FrequentPattern refineFrequentPattern(FrequentPattern FP,Item item){
        FrequentPattern temp = new FrequentPattern(FP);
        temp.addItem(item);
        return temp;
    }

    /**
     * restituisce l'outputFP
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @return outputFP;
     */
    public List getOutputFP() {
        return outputFP;
    }


    /**
     *
     */
    public String toString() {
        String output="";
        int i = 0;

        Iterator p = outputFP.iterator();

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
    public Iterator<FrequentPattern> iterator() {
        return null;
    }


    /**
     * permette di memorizzare su file l'oggetto di tipo FrequentPatternMiner così da permettere la serializzazione
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param nomeFile stringa indicante il nome del file
     *
     */
    public void salva(String nomeFile) throws FileNotFoundException, IOException {      // serializza l’oggetto riferito da this nel file il cui nome è passato come parametro
        FileOutputStream file = new FileOutputStream(nomeFile + ".dat");
        ObjectOutputStream outStream = new ObjectOutputStream(file);
        outStream.writeObject(this);

    }

    /**
     * permette di caricare da file l'oggetto FrequentPatternMiner
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param nomeFile stringa indicante il nome del file
     *
     */
    public static FrequentPatternMiner carica(String nomeFile) throws FileNotFoundException,IOException,ClassNotFoundException{    //si occupa di leggere e restituire l’oggetto come è memorizzato nel file il cui nome è passato come parametro.
        FileInputStream inFile = new FileInputStream(nomeFile + ".dat");
        ObjectInputStream inStream = new ObjectInputStream(inFile);
        FrequentPatternMiner fp = (FrequentPatternMiner) inStream.readObject();
        return fp;
    }


}
	


