package adventure;

public class Location {
	
	public Location(String locationName){
		name = locationName;
	}

	public Location(String locationName, String enterText, String lookText, String shortLookText){
		name = locationName;
		this.enterText = enterText;
		this.lookText = lookText;
		lokTxt = shortLookText;
	}
	
	public void setTexts(String enterText, String lookText, String shortLookText){
		this.enterText = enterText;
		this.lookText = lookText;
		lokTxt = shortLookText;
	}
	
	//Everything below this is "Get" methods
	public String name(){
		return name;
	}
	
	//Texts
	public String enterText(){
		if (beenEntered == false){
			beenEntered = true;
			return enterText;
		}
		else
			return lokTxt;
	}
	
	public String lookText(){
		return lookText;
	}
	
	public String shortLookText(){
		return lokTxt;
	}
	
	private String name;
	
	private String enterText;
	private String lookText;
	private String lokTxt;
	
	private boolean beenEntered = false;
	
}
