package visitors;

import java.io.BufferedWriter;

import dsForStrings.BST;
import dsForStrings.BSTNode;
import util.FileProcessor;

/**
 * Second visitor to count words
 * 
 *
 */
public class WordCountVisitor implements DSProcessingVisitorI{

	private int count_distinct = 0;
	private int count_total = 0;
	private int count_char = 0;
	private BufferedWriter bw;
	private FileProcessor fpobj;
	String outputFile;
	String ret = null;
	
	/**
	 * Constructor of WordCount Visitor
	 * @param bwIn
	 * @param fpobjIn
	 */
	public WordCountVisitor(BufferedWriter bwIn, FileProcessor fpobjIn) {
		// TODO Auto-generated constructor stub
		this.bw = bwIn;
		this.fpobj = fpobjIn;
		
	}

	/**
	 * Method to do the word count from the data structure
	 */
	@Override
	public void visit(BST bst) {
		
		ret = count(bst.getRoot());
		writeToFile(bw,fpobj);
		
	}
	
	/**
	 * Method to write to a file
	 * @param bw
	 * @param fp
	 */
	public void writeToFile(BufferedWriter bw ,FileProcessor fp) {
		// TODO Auto-generated method stub
		fp.writeFile(bw, ret);
		
	}

	/**
	 * 
	 * @param root
	 * @return count
	 */
	public String count(BSTNode root){
		String count = null;
		
		if(root != null){
			
			count(root.getLeft());
			
			count_distinct++;
			count_total = count_total + root.getCount();
			count_char = count_char+ (root.getCount() * root.getValue().length());
			
			count(root.getRight());
			
			count = ""+"Total distinct words:"+count_distinct + "\n" + "Total words:"+count_total + "\n"+ "Total characters:"+count_char;
		}
		else {
			count = ""+"Total distinct words:"+count_distinct + "\n" + "Total words:"+count_total + "\n"+ "Total characters:"+count_char;;
		}
		
		return count;
		
	}
}
