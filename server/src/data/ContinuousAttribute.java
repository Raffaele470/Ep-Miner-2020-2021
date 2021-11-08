package data;

import java.io.Serializable;
import java.util.Iterator;

public class ContinuousAttribute extends Attribute implements Iterable<Float>, Serializable {
    private float max;
    private float min;// rappresentano gli estremi di un intervallo


    /**
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     * @param name stringa indicante il nome
     * @param index intero indicante l'indice
     * @param min valore reale indicante il minimo
     * @param max valore reale indicante il massimo
     */
    protected ContinuousAttribute(String name, int index, float min, float max) {
        super(name, index);

        this.max = max;
        this.min = min;
    }


    /**
     * restituisce il minimo
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     * @return min
     *
     */
    public float getMin() {
        return this.min;
    }

    /**
     * restituisce il massimo
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     * @return max
     *
     */
    public float getMax() {
        return this.max;
    }

    /**
     * Costruttore dell'iteratore
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     *
     */
    public Iterator<Float> iterator(){
        return new ContinuousAttributeIterator(min, max, 5);
    }


}