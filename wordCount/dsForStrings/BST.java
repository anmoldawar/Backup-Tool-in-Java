package dsForStrings;

import dsForStrings.BSTNode;
import visitors.DSProcessingVisitorI;


/**
 * Class for Data Structure 
 * @author anmol
 *
 */
public class BST {
	
	private BSTNode root;
	
	public BST(){
		root = null;
	}
	
	//getter for root
	public BSTNode getRoot() {
		return root;
	}
	
	//setter for root
	public void setRoot(BSTNode root) {
		this.root = root;
	}

	
	/**
	 * Method to insert a node in the Tree
	 * @param root
	 * @param node
	 */
	public void insert(BSTNode root, BSTNode node){
		BSTNode searchNode;
		
		searchNode = treeSearch(root, node.data);
		
		if(searchNode!=null){
			searchNode.setCount();
		}
		
		else{
			if((root == null)){
				this.root = node;
				node.setCount();
			}
			
			else if((root.getValue().compareTo(node.getValue()) > 0)){
				if(root.getLeft()==null){
					root.setLeft(node);
					node.setCount();
				}
				else
					insert(root.getLeft(),node);
			}
			else if((root.getValue().compareTo(node.getValue())) < 0){
				if(root.getRight()==null){
					root.setRight(node);
					node.setCount();
				}
				else
					insert(root.getRight(),node);
			}
		}
		
	}
	
	/**
	 * method to insert a node
	 * in the backup tree
	 * @param root
	 * @param node
	 */
	public void insertToBackup(BSTNode root, BSTNode node){
	
			if((root == null)){
				this.root = node;
				//node.setCount();
			}
			
			else if((root.getValue().compareTo(node.getValue()) > 0)){
				if(root.getLeft()==null){
					root.setLeft(node);
				}
				else
					insertToBackup(root.getLeft(),node);
			}
			else if((root.getValue().compareTo(node.getValue())) < 0){
				if(root.getRight()==null){
					root.setRight(node);
				}
				else
					insertToBackup(root.getRight(),node);
			}
		}
	
	/**
	 * Method to print each node
	 * by inorder traversal
	 * @param root
	 */
	public void printInorder(BSTNode root){
		if(root != null){
			printInorder(root.getLeft());
			System.out.println(root.getValue()+" "+root.getCount());
			printInorder(root.getRight());
		}
		
	}

	/**
	 * Method to check if a node is present
	 * in the tree already or not
	 * @param root
	 * @param item
	 * @return node
	 */
	public BSTNode treeSearch( BSTNode root, String item ) {
		   if ( root == null ) {
		          // Tree is empty, so it certainly doesn't contain item.
			   return root;
		   }
		   
		   else if ( item.equals(root.getValue()) ) {
		          // Yes, the item has been found in the root node.
		      return root;
		   }
		   else if ( item.compareTo(root.getValue()) < 0 ) {
		          // If the item occurs, it must be in the left subtree.
		      return treeSearch( root.getLeft(), item );
		   }
		   else {
		          // If the item occurs, it must be in the right subtree.
		      return treeSearch( root.getRight(), item );
		   }
		} 

	/**
	 * Accept method 
	 * @param visitor
	 */

	public void accept(DSProcessingVisitorI visitor){
		visitor.visit(this);
	}
	

}
