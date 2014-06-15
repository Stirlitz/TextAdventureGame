package adventure;

public class Inventory {
	
	public Inventory(int size){
		inv = new Item[size];
	}
	
	public boolean removeItem(Item removeItem){
		for(int count = 0; count < inv.length; count++){
			if(inv[count] == removeItem){
				inv[count] = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean placeItem(Item placeingItem){
		for(int count = 0; count < inv.length; count++){
			if(!(inv[count] != null)){
				inv[count] = placeingItem;
				return true;
			}
		}
		return false;
	}
	
	private static Item inv[];
}
