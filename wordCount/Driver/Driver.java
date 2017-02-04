package Driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import dsForStrings.BST;
import util.FileProcessor;
import visitors.CloneObserve;
import visitors.DSProcessingVisitorI;
import visitors.PopulateVisitor;
import visitors.Test;
import visitors.WordCountVisitor;


/**
 * Main driver class
 * @param - args
 *
 */
public class Driver {

	public static void main(String args[]) throws IOException, InterruptedException {

	/*Checking correct number of command line arguments */
		if(args.length < 3){
			System.out.println("Please enter all 3 arguments");
			System.exit(1);
		}else if(args.length > 3){
			System.out.println("Too many arguments!Please enter 3 arguments only");
			System.exit(1);
		}
	
		String inputFile = args[0];
		String outputFile = args[1];
		int NUM_ITERATIONS=0;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileInputStream is;
		InputStreamReader isr;
		
		
		if(isInteger(args[2])){
			NUM_ITERATIONS = Integer.parseInt(args[2]);
		}
		else{
			System.err.println("NUM_ITERATIONS should be an Integer");
			System.exit(1);
		}	
	
		
		long startTime = System.currentTimeMillis();
	
		BST bst = null;
		FileProcessor fpobj = null;
		
		/* Code for checking the performance */
		for(int i=0;i<NUM_ITERATIONS;i++){
			bst = new BST();
			
			try {
				is = new FileInputStream(inputFile);
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				
			} catch (FileNotFoundException e){
				System.err.println("Input file not present");
				System.exit(1);
			}
			
			 
			try{
				FileWriter fileWriter = new FileWriter(outputFile);
				bw = new BufferedWriter(fileWriter);
			}catch(IOException e){
				System.exit(1);
			}
			
			//create element
			
			fpobj = new FileProcessor();
			
			//create the two visitors
			DSProcessingVisitorI v1 = new PopulateVisitor(fpobj,br);
			DSProcessingVisitorI v2 = new WordCountVisitor(bw,fpobj);
			
			bst.accept(v1);
			bst.accept(v2);
			
			
		}
		long finishTime = System.currentTimeMillis();
		long total_time = (finishTime-startTime)/NUM_ITERATIONS;
		
		System.out.println("Total time taken in ms is:"+total_time);
		
		/* Object for the backup tree, currently empty*/
		BST backup = new BST();
		
		/*Visitor to make the backup of original tree*/
		
		DSProcessingVisitorI v3 = new CloneObserve(bst,backup);
		bst.accept(v3);

		System.out.println("--------------Before Update-----------\n");
		System.out.println("--------------Original tree----------");
		if(bst.getRoot()!=null){
			bst.printInorder(bst.getRoot());
		}
		else{
			System.out.println("Empty Tree");
		}
		
		System.out.println("--------------Backup tree-------------");
		
		if(backup.getRoot()!=null){
			bst.printInorder(backup.getRoot());
		}
		else{
			System.out.println("Empty Tree");
		}

		/* Visitor to check the observer pattern (updates in backup tree)*/
		
		DSProcessingVisitorI v4 = new Test(bst,backup);
		bst.accept(v4);
		
		System.out.println("\n--------------After Update-----------\n");
		
		System.out.println("--------------Original tree----------");
		
		if(bst.getRoot()!=null){
			bst.printInorder(bst.getRoot());
		}
		else{
			System.out.println("Empty Tree");
		}
		System.out.println("---------------Backup tree----------");
		
		if(backup.getRoot()!=null){
			bst.printInorder(backup.getRoot());
		}
		else{
			System.out.println("Empty Tree");
		}
}
	
	/*Method to check if the entered command line argument is a number or not */
	public static boolean isInteger(String s)
	{
		try{
			Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}

}
