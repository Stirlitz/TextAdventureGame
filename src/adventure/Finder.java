package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Finder {
	
	public Finder(int typeofitem){
		type = typeofitem;
		dictionary();
	}
	
	public static String findWord(String sentance){
		
		String oops = null;
		
		for(int count = 0; count < words.length; count++){
			if(sentance.contains(words[count][type])){
				foundWord = true;
				return words[count][type];
			}
			else
				foundWord = false;
		}
		
		return oops;
	}

	private static void dictionary(){
		
		
		File dic = new File("dictionary");
		int ex = 0;
		int why = 0;
		
		
		
		try {
			Scanner moo = new Scanner(dic);
			
			while(moo.hasNextLine() && why < 4){
				words[ex][why] = moo.nextLine();
				ex++;
				
				if (ex >= 10){
					why++;
					ex = 0;
				}
			} 
			moo.close();
		}
	    
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }	
		
	}
	
	private static String words[][] = new String[10][4];
	
	private static boolean foundWord;
	
	private static int type; //Types ae as follows: 1 = Noun; 2 = item; 3 = object; 4 = Person;
}
