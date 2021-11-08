package utility;

import java.io.Serializable;

public class Queue<T> implements Serializable {

		private T e;

		private Record begin = null;

		private Record end = null;
		
		private class Record {

	 		 T e;

	 		 Record next;

			 Record(T e) {
				this.e = e;
				this.next = null;
			}
		}


	/**
	 * verifica se la coda è vuota e restituisce true. Altrimenti FALSE.
	 */
		 public boolean isEmpty() {
			return this.begin == null;
		}

		 public void enqueue(T e) {
			if (this.isEmpty())
				this.begin = this.end = new Record(e);
			else {
				this.end.next = new Record(e);
				this.end = this.end.next;
			}
		}


	/**
	 * restituisce il primo oggetto
	 */
	public Object first(){
			return this.begin.e;
		}


	/**
	 *
	 */
	public void dequeue(){
			if(this.begin==this.end){
				if(this.begin==null)
				System.out.println("The queue is empty!");
				else
					this.begin=this.end=null;
			}
			else{
				begin=begin.next;
			}
			
		}

	}