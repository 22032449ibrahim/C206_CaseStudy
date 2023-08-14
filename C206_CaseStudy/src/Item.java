import java.time.format.DateTimeFormatter;

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

	public String getDescription() {
		return description;
	}

	public double getStartBid() {
		return startBid;
	}

	public void setStartBid(double startBid) {
		this.startBid = startBid;
	}

	public String toString() {
		String output = String.format("%-30s %-20s %-20.2f", itemName, description, startBid);
		return output;
	}
}
