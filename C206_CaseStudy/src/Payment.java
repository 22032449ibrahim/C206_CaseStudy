import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment {

	private String cardNumber;
	private String cardHolder;
	private LocalDateTime paymentDate;
	private double amount;

	public Payment(String cardNumber, String cardHolder, LocalDateTime paymentDate, double amount) {
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public LocalDateTime getPaymentdate() {
		return paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public String toString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		String output = String.format("%-30s %-20s %-20s %-10.2f", cardNumber, cardHolder, paymentDate.format(f),
				amount);
		return output;
	}

}
