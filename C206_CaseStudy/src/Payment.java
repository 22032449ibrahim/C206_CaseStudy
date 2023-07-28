import java.time.LocalDateTime;

public class Payment {
	
	private String cardNumber;
	private String cardHolder;
	private LocalDateTime paymentdate;
	private double amount;
	
	public Payment(String cardNumber, String cardHolder, LocalDateTime paymentdate, double amount) {
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.paymentdate = paymentdate;
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public LocalDateTime getPaymentdate() {
		return paymentdate;
	}

	public double getAmount() {
		return amount;
	}


	
}
