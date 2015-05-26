package utilities;

public class RentItem {

	private String gameTitle;
	private int quantity;
	public RentItem(){}
	
	public RentItem(String gameTitle, int quantity){
		this.gameTitle = gameTitle;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}	
	
}
