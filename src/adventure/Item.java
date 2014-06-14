package adventure;

public class Item {
	
	public Item(String nameOfItem, String itemType, int itemID){
		name = nameOfItem;
		type = itemType;
		id = itemID;
		
	}
	
	public static String type(){
		return type;
	}
	
	public static String name(){
		return name;
	}
	
	public static int itemID(){
		return id;
	}
	private static String name;
	private static String type;
	private static int id;
	
}
