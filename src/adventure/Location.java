package adventure;

public class Location {
	
	//Constructor
	public Location(String locationName){
		name = locationName;
	}

	//Alt-Constructor that combines both the name and set texts methods
	public Location(String locationName, String enterText, String lookText, String shortLookText){
		name = locationName;
		this.enterText = enterText;
		this.lookText = lookText;
		lokTxt = shortLookText;
	}
	
	//used in conjunction with the first Constructor, can also be used to change texts at any time
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
	
	//Method variable seperator=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=//
	
	private String name;
	
	private String enterText;
	private String lookText;
	private String lokTxt;
	
	private boolean beenEntered = false;
	
}
