package data;

import java.io.Serializable;
import java.util.Iterator;

public class ContinuousAttributeIterator implements Iterator<Float>, Serializable {

	private float min;
	private float max;
	private int j=0;
	private int numValues;

	/**
	 * avvalora i membri attributo della classe con i parametri del costruttore
	 * @param min valore reale indicante il minimo
	 * @param max valore reale indicante il massimo
	 * @param numValues intero che indica il numero di valori
	 *
	 */
	ContinuousAttributeIterator(float min,float max,int numValues){
		this.min=min;
		this.max=max;
		this.numValues=numValues;
	}

	/**
	 * restituisce true se j<=numValues, false altrimenti
	 */
	@Override
	public boolean hasNext() {
		
		return (j<=numValues);
	}


	/**
	 * incrementa j, restituisce il cut point in posizione j-1(min + (j-1)*(max-min)/numValues)
	 */
	public Float next() {

		j++;
		return min+((max-min)/numValues)*(j-1);
	}


	/**
	 *
	 */
	public void remove() {}

}
