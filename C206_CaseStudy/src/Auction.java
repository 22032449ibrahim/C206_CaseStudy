
public class Auction {
	private String title;
	private String description;
	private String startTime;
	private String endTime;
	
	public Auction(String title, String description, String startTime, String endTime) {
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}
}

