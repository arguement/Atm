public class Card {
	private String serialNum;
	private String pin;
	
	
	public Card(String serialNum,String pin){
		this.serialNum = serialNum;
		this.pin = pin;
	}
	
	public String getSerialNum(){
		return this.serialNum;
	}
	
	public String getPin(){
		return this.pin;
		
	}
}