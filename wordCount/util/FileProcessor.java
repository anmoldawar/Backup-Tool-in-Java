package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Class for Reading and writing to a file
 * @author anmol
 *
 */
public class FileProcessor {

	private String str=null;	

	/**
	 * Method to read from a file
	 * @param br - Buffered Reader object
	 * @return string
	 */
	
	public String readFile(BufferedReader br){
		try {
			str = br.readLine();
		} catch (IOException e) {
			System.out.println("Error while reading file");
			System.exit(1);
		}
		return str;
	}
	
	

	/**
	 * Method to write to a file
	 * @param bw - Buffered Writer object
	 * @param data - string to be written
	 */
	public void writeFile(BufferedWriter bw,String data){
			
		try{
			bw.write(data);
		}catch(IOException e){
			e.printStackTrace();	
		}
		finally {
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}
	
	
}
