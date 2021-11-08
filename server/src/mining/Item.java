package mining;

import data.*;

import java.io.Serializable;

public abstract class Item implements Serializable {

    private Attribute attribute;                    //attributo coinvolto nell'item
    private Object value;                           //valore assegnato all'attributo


    /**
     * costruttore di Item
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param attribute oggetto di tipo Attribute
     * @param value oggetto indicante il valore
     *
     */
    public Item(Attribute attribute, Object value){
     this.attribute=attribute;
     this.value=value;
    }

    /**
     * restituisce l'attributo di Item
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     *
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * restituisce il valore di Item
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     *
     */
    public Object getValue() {
        return value;
    }

    /**
     * metodo astratto per verificare che il valore rispetti una determinata condizione.
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param value oggetto indicante il valore
     *
     */
    public abstract boolean checkItemCondition(Object value);

    /**
     *
     */
    public String toString(){
            return attribute+"="+value;
    }

}
