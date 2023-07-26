import java.time.LocalDateTime;

public class Auction {
	private String title;
	private String description;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	public Auction(String title, String description, LocalDateTime startTime, LocalDateTime endTime) {
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}
}

