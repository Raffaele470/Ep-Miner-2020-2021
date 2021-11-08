package data;

import java.io.Serializable;


public abstract class Attribute implements Serializable {
    private String name;
    private int index;


    /**
     * Costruttore dell'attributo.
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     * @param name stringa indicante nome dell'attributo
     * @param index intero indicante l'indice
     */
    protected Attribute(String name, int index){
        this.name = name;
        this.index = index;
    }

    /**
     * Restituisce il nome
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     * @return name stringa indicante il nome
     *
     */
    public String getName() {
        return name;
    }


    /**
     * Restituisce l'indice
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     *
     */
    public int getIndex() {
        return index;
    }


    /**
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro Congedo
     */
    public String toString() {
        return name;
    }
}