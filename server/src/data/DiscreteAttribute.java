package data;

import java.io.Serializable;

public class DiscreteAttribute extends Attribute implements Serializable {
    String values[];


    /**
     * costruttore di DiscreteAttribute che richiama il super.
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param name stringa indicante il nome
     * @param index intero indicante l'indice
     * @param values array di stringhe di valori
     *
     */
    protected DiscreteAttribute(String name, int index, String values[]) {
        super(name, index);

        int dimensione = values.length;
        this.values = new String[dimensione];
        for (int i = 0; i < dimensione; i++) {
            this.values[i] = values[i];
        }
    }


    /**
     * restituisce la dimensione dell'array values
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     *
     */
    public int getNumberOfDistinctValues() {
        return values.length;
    }

    /**
     * restituisce la stringa indicante il valore in posizione indexV
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param index intero indicante l'indice
     *
     */
    public String getValue(int index) {
        return values[index];
    }

}