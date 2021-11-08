package utility;

import mining.EmergingPattern;

import java.util.Comparator;

public class ComparatorGrowRate implements Comparator<EmergingPattern>{

    /**
     * override del metodo compare che permette di confrontare e1 ed e2
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param e1 oggetto di tipo EmergingPattern
     * @param e2 oggetto di tipo EmergingPattern
     */
    @Override
    public int compare(EmergingPattern e1, EmergingPattern e2) {

        if (e1.getGrowrate() > e2.getGrowrate()) {
            return 1;
        }

        else if (e1.getGrowrate() < e2.getGrowrate()) {
            return -1;
        }

        else return 0;
    }

}
