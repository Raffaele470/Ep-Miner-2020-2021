package data;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import java.util.List;
import database.*;
import database.TableData.TupleData;

public class Data {
	
	/**
	 * @uml.property  name="data" multiplicity="(0 -1)" dimension="2"
	 */
	private Object data [][];
	/**
	 * @uml.property  name="numberOfExamples"
	 */
	private int numberOfExamples;
	/**
	 * @uml.property  name="attributeSet"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private List<Attribute> attributeSet=new LinkedList<Attribute>();


	/**
	 * costruttore di data
	 * @param tableName stringa rappresentante il nome
	 *
	 */
	public Data (String tableName) throws DatabaseConnectionException, SQLException, NoValueException {
		// open db connection
	
			
			DbAccess db= new DbAccess();
			db.initConnection();
	
		
		
		
			TableSchema tSchema;
			try {
				tSchema = new TableSchema(tableName, db.getConnection());
				TableData tableData=new TableData(db.getConnection());
				List<TupleData> transSet=tableData.getTransazioni(tableName);
				
				data= new Object[transSet.size()][tSchema.getNumberOfAttributes()];
				for(int i=0;i<transSet.size();i++)
					for(int j=0;j<tSchema.getNumberOfAttributes();j++){
						data[i][j]=transSet.get(i).tuple.get(j);
				}
				
				numberOfExamples=transSet.size();
						
				for(int i=0;i<tSchema.getNumberOfAttributes();i++)
				{
					if(tSchema.getColumn(i).isNumber())
						attributeSet.add(
							new ContinuousAttribute(
									tSchema.getColumn(i).getColumnName(),
									i,
									((Float)(tableData.getAggregateColumnValue(tableName, tSchema.getColumn(i), QUERY_TYPE.MIN))).floatValue(),
									((Float)(tableData.getAggregateColumnValue(tableName, tSchema.getColumn(i), QUERY_TYPE.MAX))).floatValue()+0.606f
							)
							);
					else
					{
						// avvalora values con i valori distinti della colonna oridinati in maniera crescente
						List<Object> valueList=tableData.getDistinctColumnValues(tableName,tSchema.getColumn(i));
						String values[]=new String[valueList.size()];
						Iterator it= valueList.iterator();
						int ct=0;
						while(it.hasNext()){
							values[ct]=(String)it.next();
							ct++;
						}
						attributeSet.add(new DiscreteAttribute(tSchema.getColumn(i).getColumnName(),i,values));
					}
				}
			} 
			
			finally{
				db.closeConnection();
			}
			
		
	}
	
	
	/**
	 * restituisce il numberOfExamples
	 * @uml.property  name="numberOfExamples"
	 */
	public int getNumberOfExamples(){
		return numberOfExamples;
	}


	/**
	 * restituisce un intero indicante la dimenesione dell' attributeSet
	 */
	public int getNumberOfAttributes(){
		return attributeSet.size();
	}


	/**
	 * restituisce l'oggetto che si trova nella posizione [exampleIndex][attributeSet.get(attributeIndex).getIndex()]
	 * @param exampleIndex intero indicande l'exampleIndex
	 * @param attributeIndex intero indicante l'attributeIndex
	 *
	 */
	public Object getAttributeValue(int exampleIndex, int attributeIndex){
		return data[exampleIndex][attributeSet.get(attributeIndex).getIndex()];
	}


	/**
	 * restituisce l'attributo in posizione index di attributeSet
	 * @param index intero indicante l'indice
	 *
	 */
	public Attribute getAttribute(int index){
		return attributeSet.get(index);
	}


	/**
	 *
	 */
	public String toString(){
		String value="";
		for(int i=0;i<numberOfExamples;i++){
			value+=(i+1)+":";
			for(int j=0;j<attributeSet.size()-1;j++)
				value+=data[i][j]+",";
			
			value+=data[i][attributeSet.size()-1]+"\n";
		}
		return value;
		
		
	}


	
	


}
