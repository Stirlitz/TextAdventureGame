package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Eric Mikulin - Currently Unnamed Game

public class TextAdventure {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String command = "";
		
		//Use the method to make the game
		makeGame();
		
		//Set the current location of datatype Location to the current x,y value (Should be 1,1)
		currentLocation = location[x][y];
		
		//Print out some instruction text so that the players know what to do
		System.out.println("INSTRUCTIONAL TEXT: \n- Use the FULL NAME LOWERCASE of the cardianl directions (North, east etc.) to move.\n- Type in \"look\" to get a more detailed description.\n- Type in \"look at [noun]\" to get a description of [noun]\n- For other actions just try to uase english and common sense\nType in \"help\" for more info");
		
		//Pause code here, to give them time to read
		while (0 != 1){
			//Player has entered a room
			System.out.println(currentLocation.name());
				
			//Output the enter text (The text that describes the room that the player has entered)
			System.out.println(currentLocation.enterText());
			
			//Set the fact that they are in a room to be true
			inRoom = true;
			
			//This will run continuously while the user is still in the room
			while (inRoom){
				System.out.println("\nWhat would you like to do next?");
				command = input.nextLine();
				
				//Run through each of the commands, and test it for trueness
				testCommands(command);
			}
			//Majestic space for beautifulness during output
			System.out.println("");
		}
		//input.close();
	}

	//This method "Moves" the player
	public static void move(int xMovement, int yMovement){
		
		//Add the movement value to the X, Y Values
		x += xMovement;
		y += yMovement;
		
		//If there is no location where they want to go, reverse the changes and tell the player that they cannot go there
		if (x < 0 || y < 0 || location[x][y] == null){
			x -= xMovement;
			y -= yMovement;
			System.out.println("You can't go there!");
		}
		//Else, set the new room to current location, and set inRoom to false so that the user will get the enter room text
		else{
			currentLocation = location[x][y];
			inRoom = false;
		}
	}
	
	//This method screens through the list of acceptable commands and does what its supposed to do
	public static void testCommands(String command){
		
		//Movement Commands
		if (command.contains("north"))
			move(-1,0);
		else if(command.contains("east"))
			move(0,1);
		else if(command.contains("south"))
			move(1,0);
		else if(command.contains("west"))
			move(0,-1);
		
		//Action Commands
		else if(command.contains("look"))
			System.out.println(currentLocation.lookText());
		else if(command.contains("look") && command.contains("at"))
			System.out.println();
		else if(command.contains("where"))
			System.out.println(currentLocation.enterText());
		else if(command.contains("grab") || command.contains("take"))
			System.out.println();
		else if(command.contains("place") || command.contains("drop"))
			System.out.println();
		else if(command.contains("eat")){
			//Finder food = new Finder(2);
			//Item noms = food.findWord(command);
			
			//if(noms != null && noms.type().equals("food"))
				System.out.print("This is just here to make compilier hapy :P");
				//Item.effect();
			//else
				System.out.print("This is just here to make compilier hapy :P");
				//Death.Chokeing();
		}
		
		//Miscellaneous commands and Stuff like that
		else if (command.contains("inventory"))
			mainInv.reportInventory();
		else if(command.contains("help"))
			System.out.println("This is help, it will eventually include stuff that may actually be helpful\n Quicktips: 1.Don't use capitals, 2.Keep things too two word commands");
		else
			System.out.println("I don't know what you are saying? Try typing in help to get Help (DUH)");
	}
	
	//This method is used to "Pickup" an object
	public static void pickup(int itemID){
	}
	
	//This method is for "using" an item
	public static void use(int itemID){
	}
	
	//This method creates all the items in the game
	public static void makeGame(){
		//Creates the map, and fills it with the locations
		//Link some variables to their files, these files are where the text is stored
		File name = new File("name.txt");
		File enter = new File("enter.txt");
		File look = new File("look.txt");
		File shortLook = new File("shortLook.txt");
		
		//Dunno, eclipse wanted me to put this here, and it works so yah, I guess its just an error handling thing
		try {
			//Make scanners that are scanning through their respective text files
			Scanner scName = new Scanner(name);
			Scanner scEnter = new Scanner(enter);
			Scanner scLook = new Scanner(look);
			Scanner scShLook = new Scanner(shortLook);
			
			//Not the real X & Y values, just the ones used to create the game
			int ex = 0;
			int why = 0;
		
			//While their is actually a line and you are within the bounds of the playing area (Double protection)
			while(scName.hasNextLine() && why < 14){
				
				//Grab the text from the files and place it into their respective array slots
				location[ex][why] = new Location(scName.nextLine(), scEnter.nextLine(),  scLook.nextLine(),  scShLook.nextLine());
				
				//If I want the location to be null, make it null.
				if(location[ex][why].name().contains("-")){
					location[ex][why] = null;
				}
				
				//increase the x on the coordinate grid by one
				ex++;
				
				//When you reach the end of the coordinate grid, reset x to zero and increase y by one, to start looking through  the next column
				if (!(ex < 15)){
					why++;
					ex = 0;
				}
			}
			//Some sort of error handling that Eclipse wanted my to put here
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Create item Red Shirt
		Item shirt = new Item("Red Shirt", "clothing");
		mainInv.placeItem(shirt);
		
		Item sword = new Item("Crappy Knife", "Weapon");
		mainInv.placeItem(sword);
	}
	
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=THIS LINE IS JUST TO SEPERATE METHODS FROM VARIABLES AND SHOULD BE IGNORED =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=//
	
	//Location that is the current location
	private static Location currentLocation;
	
	//Array that the 2D grid of locations is one
	private static Location location[][] = new Location[15][14];
	
	//Self Explanitory
	private static boolean inRoom = true;
	
	//These are the x & y values of the users location, defaults to 5,0 (The bedroom)
	private static int x = 5;
	private static int y = 0;
	
	//Create Inventory
	private static Inventory mainInv = new Inventory(10);
}
