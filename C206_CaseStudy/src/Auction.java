
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Auction {
    private String title;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<String> itemsAvailable;

    public Auction(String title, String description, LocalTime startTime, LocalTime endTime, List<String> itemsAvailable) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.itemsAvailable = itemsAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public List<String> getItemsAvailable() {
        return itemsAvailable;
    }

    public String toString() {
        String output = String.format("%-15s %-20s %-15s %-10s %-20s", title, description, startTime, endTime, itemsAvailable);
        return output;
    }
}

