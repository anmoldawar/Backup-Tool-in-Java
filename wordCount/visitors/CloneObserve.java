package visitors;

import dsForStrings.BST;
import dsForStrings.BSTNode;

/**
 * 
 * Third Visitor to clone
 * and set up the observer pattern
 *
 */
public class CloneObserve implements DSProcessingVisitorI{

	private BSTNode backupNode = null;
	private BST bst;
	private BST backup;
	
	public CloneObserve(BST bstIn , BST backupIn){
		this.bst = bstIn;
		this.backup = backupIn;
		
	}

	/**
	 * Method which makes the backup of the 
	 * original tree by cloning each node
	 */
	
	@Override
	public void visit(BST bst) {		
		
		PreOrderTraverse(bst.getRoot());
	
	}

	/**
	 * Method to traverse the original tree
	 * and cloning the node
	 * @param root
	 */
	public void PreOrderTraverse(BSTNode root){
		if(root!= null){		
			
			try {
				backupNode = (BSTNode)root.clone();
				backup.insertToBackup(backup.getRoot(),backupNode);
				root.addListener(backupNode);
				
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
			PreOrderTraverse(root.getLeft());
			PreOrderTraverse(root.getRight());

		}
	}
	
}
