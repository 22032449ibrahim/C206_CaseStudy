import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bid {

	 

	private double bidamount;
	private LocalDateTime bidStartDateTime;
	private int BidId;

 

	public Bid(int BidId, double bidamount, LocalDateTime bidStartDateTime) {
		this.BidId = BidId;
		this.bidamount = bidamount;
		this.bidStartDateTime = bidStartDateTime;
	}

 

	public double getBidamount() {
		return bidamount;
	}

 

	public LocalDateTime getBidStartDateTime() {
		return bidStartDateTime;
	}

 

	public int getBidId() {
		return BidId;
	}

 

	public String toString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		String output = String.format("%-10s%-30s%-10.2f", BidId, bidStartDateTime.format(f), bidamount);
		return output;
	}

}