package dsForStrings;

import java.util.ArrayList;

import dsForStrings.BSTNode;
import util.ListenerInterface;
import util.SubjectInterface;


/**
 * Class of Node Structure
 * @author anmol
 *
 */
public class BSTNode implements Cloneable,SubjectInterface,ListenerInterface{

	public String data = null;
	public BSTNode left,right;
	private int count=0;
	ArrayList<ListenerInterface> listeners = new ArrayList<ListenerInterface>();
	
	
	
	/**
	 * Constructor for Node
	 * 
	 * @param dataIn- String value
	 */
	public BSTNode(String dataIn){
		this.data = dataIn;
		this.left = null;
		this.right = null;
	}
	

	/**
	 * Constructor for Node
	 * 
	 * @param dataIn- String value
	 * @param countIn - count of that string
	 */
	
	public BSTNode(String dataIn, int countIn){
		this.data = dataIn;
		this.left = null;
		this.right = null;
		this.count= countIn;
	}
	
	//getter for string data
	public String getValue() {
		return data;
	}

	//setter for string data
	public void setValue(String dataIn) {
		this.data = dataIn;
	}

	//setter for left pointer
	public void setLeft(BSTNode left) {
		this.left = left;
	}

	//setter for right pointer
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	//getter of left pointer
	public BSTNode getLeft(){
		return left;
	}
	
	//getter of left pointer
	public BSTNode getRight(){
		return right;
	}
	
	//setter of count
	public void setCount() {
		count++;
	}
	
	//setter of count
	public void setCount(int value) {
		count = count+value;
	}
	
	//getter of count
	public int getCount(){
		return count;
	}
	
	
	/**
	 * Clone method which clones each node
	 * @return cloned node
	 */
	public Object clone() throws CloneNotSupportedException{
        
		BSTNode newNode = new BSTNode(this.data,this.count);
        
		return newNode;
    }

	/**
	 * Method to add an observer
	 */
	@Override
	public void addListener(ListenerInterface lobj) {
		listeners.add(lobj);
		
	}


	/**
	 * Method to remove an observer
	 */
	@Override
	public void deleteListener(ListenerInterface lobj) {
		listeners.remove(lobj);
		
	}

	/**
	 * Method to notify the observer
	 */
	@Override
	public void notifyListenener(int val) {
		
		for(ListenerInterface lobj: listeners){	
			lobj.update(val);
		}
		
	}
	
	/**
	 * Method to update the subject
	 */
	@Override
	public void update(int val) {
		count  = count + val;
		notifyListenener(val);
	}
	
}
