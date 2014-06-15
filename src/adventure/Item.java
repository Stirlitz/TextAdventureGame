package adventure;

public class Item {
	
	public Item(String nameOfItem, String itemType/*, int itemID*/){
		name = nameOfItem;
		type = itemType;
		//id = itemID;
		
	}
	
	public String type(){
		return type;
	}
	
	public String name(){
		return name;
	}
	
	//public static int itemID(){
	//	return id;
	//}
	
	private String name;
	private String type;
	//private static int id;
	
}
