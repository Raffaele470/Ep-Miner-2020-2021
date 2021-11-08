package utility;

public class EmptyQueueException extends Exception{

    /**
     * costruttore dell'eccezione che richiama super
     * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
     */
    public EmptyQueueException(){
        super("La lista è vuota");
    }
}