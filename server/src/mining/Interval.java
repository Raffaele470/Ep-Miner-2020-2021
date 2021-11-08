package mining;

import java.io.Serializable;

public class Interval implements Serializable {

    private float inf; //estremo inferiore
    private float sup; //estremo superiore


    /**
     * costruttore di Interval
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param inf valore reale indicante l'estremo inf
     * @param sup valore reale indicante l'estremo sup
     *
     */
    public Interval(float inf, float sup){
        this.inf=inf;
        this.sup=sup;
    }


    /**
     * permette di impostare il campo inf di Interval uguale ad inf
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param inf valore reale indicante l'estremo inf
     *
     */
    protected void setInf(float inf){
        this.inf=inf;
    }


    /**
     * permette di impostare il campo sup di Interval uguale a sup
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param sup valore reale indicante l'estremo sup
     *
     */
    protected void setSup(float sup){
        this.sup=sup;
    }

    /**
     * restituisce l'inf di Interval
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     *
     */
    public float getInf() {
        return inf;
    }

    /**
     * restituisce il sup di Interval
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     *
     */
    public float getSup() {
        return sup;
    }

    /**
     * restituisce TRUE se valore compreso tra inf e sup altrimenti FALSE
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     * @param value valore reale indicante il valore
     *
     */
    protected boolean checkValueInclusion(float value){
        return(value>=this.inf && value<this.sup);
    }

    /**
     *
     */
    public String toString(){
        String output ="";
        output += "[" + this.inf + "," + this.sup + "[" ;
        return output;
    }

}
