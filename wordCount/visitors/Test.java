package visitors;

import dsForStrings.BST;
import dsForStrings.BSTNode;


/**
 * Test class to check the observer pattern
 * 
 * @author anmol
 *
 */
public class Test implements DSProcessingVisitorI {

	private BST bst;
	private BST backup;
	
	public Test(BST bstIn , BST backupIn){
		this.bst = bstIn;
		this.backup = backupIn;
		
	}
	
	@Override
	public void visit(BST bst) {
		// TODO Auto-generated method stub
		PreOrderTraverse(bst.getRoot());
		
	}
	
	
	/**
	 * Traverses the original tree and
	 * updates the count of each node
	 * 
	 * @param root
	 */
	public void PreOrderTraverse(BSTNode root){
		//System.out.println(root.getValue());
		if(root!= null){		

			root.update(2);
			
			PreOrderTraverse(root.getLeft());
			PreOrderTraverse(root.getRight());

		}
	}

}
