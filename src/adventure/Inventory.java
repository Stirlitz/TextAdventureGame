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
	
	public void reportInventory(){
		String list = "";
		for(int count = 0; count < inv.length; count++){
			if(inv[count] != null)
				list += "[" + inv[count].name() + "] ";
			else
				list += "[EMPTY] ";
		}
		System.out.println(list);
	}
	
	public void placeItem(Item placeingItem){
		boolean places = false;
		for(int count = 0; count < inv.length; count++){
			if((inv[count] == null) && (places == false)){
				inv[count] = placeingItem;
				places = true;
			}
		}
	}
	
	private Item inv[];
}
