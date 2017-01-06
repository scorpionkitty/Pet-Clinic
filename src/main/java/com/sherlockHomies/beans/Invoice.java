package com.sherlockHomies.beans;
import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

@Cacheable
@Entity
@Table(name = "INVOICE")
public class Invoice {

	@Id
	@Column(name = "INVOICE_ID", nullable=false)
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int invoiceId;
	
	@Column(name="AMOUNT", nullable=false)
	@NotNull
	private double amount;
	
	@OneToOne(cascade = CascadeType.REMOVE) //one invoice has one appointment
	@JoinColumn(name="APPT_ID", nullable=false)
	@ForeignKey(name="APPT_ID_FK")
	@NotNull
	private Appointment appt;
	
	@Column(name="IS_PAID", nullable=false)
	@NotNull
	private boolean isPaid;
	
	@Column(name="CARD_NUMBER", nullable=false)
	@NotNull
	private String cardNumber;
	
	@Column(name="PAYMENT_DATE")
	private Timestamp paymentDate;

	public Invoice() {
		super();
	}
    
	public Invoice(int invoiceId, double amount, Appointment appt, boolean isPaid, String cardNumber, Timestamp paymentDate) {
		super();
		this.invoiceId = invoiceId;
		this.amount = amount;
		this.appt = appt;
		this.isPaid = isPaid;
		this.cardNumber = cardNumber;
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

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
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
