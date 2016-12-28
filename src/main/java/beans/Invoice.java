package beans;

import java.sql.Timestamp;

public class Invoice {

	private int invoiceId;
	private double amount;
	private int apptId;
	private boolean isPaid;
	private String paymentMethod;
	private Timestamp paymentDate;
	
	public Invoice() {
		super();
	}
	public Invoice(int invoiceId, double amount, int apptId, boolean isPaid, String paymentMethod,
			Timestamp paymentDate) {
		super();
		this.invoiceId = invoiceId;
		this.amount = amount;
		this.apptId = apptId;
		this.isPaid = isPaid;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getApptId() {
		return apptId;
	}
	public void setApptId(int apptId) {
		this.apptId = apptId;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", amount=" + amount + ", apptId=" + apptId + ", isPaid=" + isPaid
				+ ", paymentMethod=" + paymentMethod + ", paymentDate=" + paymentDate + "]";
	}
}
