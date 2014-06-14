package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Finder {
	
	//Creates a finder with a specified word type (See type declaration below for more info)
	public Finder(int typeofitem){
		type = typeofitem;
		dictionary();
	}
	
	//This method will look through a sentence and return the first accepted word. This is to be used to find nouns, verbs and stuff in a command.
	public static String findWord(String sentance){
		
		//Set oops (returned if nothing is found) to null
		String oops = null;
		
		//Looks through each of the elements from the accepted word array, and sees if they are in the string
		for(int count = 0; count < words.length; count++){
			//if a word is found, return it, else return null (oops)
			if(sentance.contains(words[count][type]))
				return words[count][type];
		}
		return oops;
	}

	//This method reads through the accepted word dictionary list and sets up the array and such
	private static void dictionary(){
		
		//find the file
		File dic = new File("dictionary");
		int ex = 0;
		int why = 0;
		
		try {
			Scanner moo = new Scanner(dic);
			
			//While the scanner has a next line, place that in the respective array element
			while(moo.hasNextLine() && why < 4){
				words[ex][why] = moo.nextLine();
				ex++;
				
				//When you reach the end of type 0, move to type 1 and so on
				if (ex >= 10){
					why++;
					ex = 0;
				}
			}
			//Close the resource leaking scanner
			moo.close();
		}
	    //Eclipse wanting the error handling thing or something
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }	
		
	}
	
	private static String words[][] = new String[10][4];
	
	private static boolean foundWord;
	
	private static int type; //Types ae as follows: 1 = Noun; 2 = item; 3 = object; 4 = Person;
}
