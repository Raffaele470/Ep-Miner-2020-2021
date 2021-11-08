package mining;

import data.*;

import java.io.Serializable;

public class DiscreteItem extends Item implements Serializable {


    /**
     * costruttore richiamante il super
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param attribute DiscreteAttribute
     * @param value stringa indicante il valore
     *
     */
        protected DiscreteItem(DiscreteAttribute attribute, String value) {
            super(attribute,value);
        }


    /**
     * restituisce vero o falso se il valore coincide
     * @param value oggetto di cui effettuare il controllo
     *
     */
    public boolean checkItemCondition(Object value){
        return this.getValue().equals(value);
    }
}

