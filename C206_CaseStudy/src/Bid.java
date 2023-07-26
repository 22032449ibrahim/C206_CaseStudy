import java.time.LocalDateTime;

public class Bid {

	private double bidamount;
	private LocalDateTime bidStartDateTime;
	private LocalDateTime bidStopDateTime;
	
	public Bid(double bidamount, LocalDateTime bidStartDateTime, LocalDateTime bidStopDateTime) {
		super();
		this.bidamount = bidamount;
		this.bidStartDateTime = bidStartDateTime;
		this.bidStopDateTime = bidStopDateTime;
	}

	public double getBidamount() {
		return bidamount;
	}

	public void setBidamount(double bidamount) {
		this.bidamount = bidamount;
	}

	public LocalDateTime getBidStartDateTime() {
		return bidStartDateTime;
	}

	public void setBidStartDateTime(LocalDateTime bidStartDateTime) {
		this.bidStartDateTime = bidStartDateTime;
	}

	public LocalDateTime getBidStopDateTime() {
		return bidStopDateTime;
	}

	public void setBidStopDateTime(LocalDateTime bidStopDateTime) {
		this.bidStopDateTime = bidStopDateTime;
	}
	
	
}
