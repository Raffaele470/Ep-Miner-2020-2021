package mining;

import data.*;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FrequentPattern implements Iterable<Item>, Comparable<FrequentPattern>, Serializable {

	/**
	 * @uml.property  name="fp"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private List<Item> fp;


	/**
	 * @uml.property  name="support"
	 */
	private float support;


	/**
	 * Costruttore del FrequentPattern
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 *
	 */
	public FrequentPattern(){
		fp = new LinkedList<Item>();
	}


	/**
	 * costruttore per copia del FrequentPattern
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 * @param FP FrequentPattern
	 *
	 */
	public FrequentPattern(FrequentPattern FP){
		fp = new LinkedList<Item>();

		Iterator<Item> iter = FP.fp.iterator();

		while (iter.hasNext()) {
			Item it = iter.next();
			fp.add(it);
		}
		support=FP.getSupport();
	}


	/**
	 * aggiungo nuovo item al pattern
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 * @param item oggetto di tipo item da aggiungere al FrequentPattern
	 *
	 */
	protected void addItem(Item item)
	{
		fp.add(item);
	}


	/**
	 * restituisce l'item in posizione index
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 * @param index intero indicante l'indice
	 *
	 */
	public Item getItem(int index){
		return fp.get(index);
	}


	/**
	 * restituisce il supporto del FrequentPattern
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 *
	 */
	public float getSupport(){
		 return support;
	 }


	/**
	 * restituisce la lunghezza del FrequentPattern
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 *
	 */
	 public int getPatternLength(){
		return fp.size();
	 }


	/**
	 *
	 */
	public String toString() {
		String value = "";

		Iterator<Item> iter2 = fp.iterator();
		Iterator<Item> iter = fp.iterator();

		iter2.next();
		while (iter2.hasNext()) {
			value += "(" + iter.next() + ") AND ";
			iter2.next();
		}
		if (fp.size() > 0) {
			value += "(" + fp.get(fp.size() - 1) + ")";
			value += "[" + support + "]";
		}

		return value;
	}


	/**
	 * restituisce un float che rappresenta il supporto aggiornato
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 * @param data oggetto di tipo data
	 *
	 */
		 protected float computeSupport(Data data){
			int suppCount=0;
			// indice esempio
			for(int i=0;i<data.getNumberOfExamples();i++){
				//indice item
				boolean isSupporting=true;
				for(int j=0;j<this.getPatternLength();j++)
				{

					if(this.getItem(j) instanceof DiscreteItem){
						DiscreteItem item=(DiscreteItem)this.getItem(j);
						DiscreteAttribute attribute=(DiscreteAttribute)item.getAttribute();
						//Extract the example value
						Object valueInExample=data.getAttributeValue(i, attribute.getIndex());
						if(!item.checkItemCondition(valueInExample)){
							isSupporting=false;
							break; //the ith example does not satisfy fp
						}
					}


					else if(this.getItem(j) instanceof ContinuousItem){												//parte messa da me
						ContinuousItem item=(ContinuousItem) this.getItem(j);
						ContinuousAttribute attribute=(ContinuousAttribute) item.getAttribute();
						//Extract the example value
						Object valueInExample=data.getAttributeValue(i, attribute.getIndex());
						if(!item.checkItemCondition(valueInExample)){
							isSupporting=false;
							break; //the ith example does not satisfy fp
						}
					}

				}
				if(isSupporting)
					suppCount++;
			}
			return((float)suppCount)/(data.getNumberOfExamples());
		}

	/**
	 * imposta il supporto del FrequentPattern con il valore support
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 * @param support valore reale indicante il supporto
	 *
	 */
	 protected void setSupport(float support) {
		 this.support = support;
	 }

	/**
	 * iteratore
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 *
	 */
	@Override
	public Iterator<Item> iterator() {
		return null;
	}

	/**
	 * Override della funzione compareTo che permette di comparare il supporto tra frequentPattern
	 * @author Raffaele Di Anna, Alessandro Carella, Alessandro congedo
	 * @param f oggetto di tipo FrequentPattern
	 *
	 */
	@Override
	public int compareTo(FrequentPattern f) {

		if (this.getSupport() > f.getSupport()) {
			return 1;
		} else if (this.getSupport() < f.getSupport()) {
			return -1;
		} else return 0;
	}

 }
