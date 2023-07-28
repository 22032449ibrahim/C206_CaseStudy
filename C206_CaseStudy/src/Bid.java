import java.time.LocalDateTime;

public class Bid {

	private double bidamount;
	private LocalDateTime bidStartDateTime;
	private LocalDateTime bidStopDateTime;
	
	public Bid(double bidamount, LocalDateTime bidStartDateTime) {
		this.bidamount = bidamount;
		this.bidStartDateTime = bidStartDateTime;
		this.bidStopDateTime = null;
	}

	public double getBidamount() {
		return bidamount;
	}

	public LocalDateTime getBidStartDateTime() {
		return bidStartDateTime;
	}

	public LocalDateTime getBidStopDateTime() {
		return bidStopDateTime;
	}

	public void setBidStopDateTime(LocalDateTime bidStopDateTime) {
		this.bidStopDateTime = bidStopDateTime;
	}
	
	
}
