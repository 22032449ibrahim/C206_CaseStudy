
public class Item {
	private String itemName;
	private String description;
	private double startBid;
	
	public Item(String itemName, String description, double startBid) {
		this.itemName = itemName;
		this.description = description;
		this.startBid = startBid;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getStartBid() {
		return startBid;
	}
	public void setStartBid(double startBid) {
		this.startBid = startBid;
	}	
}
