package visitors;

import java.io.BufferedReader;
import dsForStrings.BST;
import dsForStrings.BSTNode;
import util.FileProcessor;

/**
 * First visitor to populate the data structure
 * 
 *
 */
public class PopulateVisitor implements DSProcessingVisitorI{
	private FileProcessor fp;
	private BufferedReader br;
	private String str=null;
	
	/**
	 * Constructor of PopulateVisitor
	 * @param fpIn
	 * @param brIn
	 */
	public PopulateVisitor(FileProcessor fpIn, BufferedReader brIn) {
		this.fp = fpIn;
		this.br = brIn;
	}
	
	
	/**
	 * Method which reads the input file
	 * and populates the data structure
	 */
	@Override
	public void visit(BST bst) {
		
		while((str = fp.readFile(br)) != null){
			
			str = str.trim().replaceAll("\\s+", " ");
			str = str.trim().replaceAll("\t", " ");
			if(!str.equals("")){	
				String[] input = str.split(" ");
				for(String word: input){
					BSTNode node = new BSTNode(word);
					bst.insert(bst.getRoot(), node);
				}
			
			}
		}
	}
	
}
