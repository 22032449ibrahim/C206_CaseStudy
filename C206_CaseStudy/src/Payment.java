public class Payment {
	
	private String cardNumber;
	private String cardHolder;
	private String paymentdate;
	private double amount;
	
	public Payment(String cardNumber, String cardHolder, String paymentdate, double amount) {
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.paymentdate = paymentdate;
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
}
