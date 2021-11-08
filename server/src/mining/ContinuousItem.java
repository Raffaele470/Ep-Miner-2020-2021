package mining;

import data.ContinuousAttribute;

import java.io.Serializable;

public class ContinuousItem extends Item implements Serializable {

    /**
     * Costruttore del ContinuousItem richiamante il super
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param attribute ContinuousAttribute
     * @param value intervallo
     *
     */
    protected ContinuousItem(ContinuousAttribute attribute, Interval value) {
        super(attribute, value);
    }


    /**
     * restituisce true or false dopo aver richiamato la funzione checkValueInclusion
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param value oggetto di cui effettuare il controllo
     *
     */
    public boolean checkItemCondition(Object value){
        return ((Interval) (this.getValue())).checkValueInclusion((float) value);
    }

    /**
     *
     */
    public String toString(){
        String output = "";
        output += getAttribute() + " in " + (Interval) this.getValue();
        return output;
    }

}
