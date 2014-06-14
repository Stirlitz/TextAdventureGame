package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Sandbox {

	public static void main(String[] args){

		File file = new File("test.txt");

		    try {

		        Scanner sc = new Scanner(file);

		        while (sc.hasNextLine()) {
		            String i = sc.nextLine();
		            System.out.println(i);
		        }
		        sc.close();
		    } 
		    
		    catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
	}

}
