package beans;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "INVOICE") //rename Physical table even though the bean is different
public class Invoice {

	@Id
	@Column(name = "INVOICE_ID", nullable=false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invoiceId;
	
	@OneToOne
	@Column(name="AMOUNT", nullable=false)
	private double amount;
	
	@OneToOne
	@JoinColumn(name="APPT_ID", nullable=false)
	
	private Appointment appt;
	
	@OneToOne
	@Column(name="IS_PAID", nullable=false)
	private boolean isPaid;
	
	@OneToOne
	@Column(name="PAYMENT_METHOD", nullable=false)
	private String cardNumber;
	
	@OneToOne
	@Column(name="PAYMENT_DATE")
	private Timestamp paymentDate;
	
	public Invoice() {
		super();
	}
	public Invoice(int invoiceId, double amount, Appointment appt, boolean isPaid, String cardNumber) {
		super();
		this.invoiceId = invoiceId;
		this.amount = amount;
		this.appt = appt;
		this.isPaid = isPaid;
		this.cardNumber = cardNumber;
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
	public Appointment getApptId() {
		return appt;
	}
	public void setApptId(Appointment appt) {
		this.appt = appt;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public String getcardNumber() {
		return cardNumber;
	}
	public void setcardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", amount=" + amount + ", apptId=" + appt + ", isPaid=" + isPaid
				+ ", cardNumber=" + cardNumber + ", paymentDate=" + paymentDate + "]";
	}
}
