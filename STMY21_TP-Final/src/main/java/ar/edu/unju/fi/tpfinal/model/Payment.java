package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "PAYMETS")
@Component("paymentObj")
public class Payment {

	@Id
	@NotNull(message = "Este campo no puede estar vacio")
	@Column (name = "customerNumber")
	private Customer customerNumber;
	
	@NotNull(message = "Este campo no puede estar vacio")
	@Column (name = "checkNumber")
	private String checkNumber;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "checkNumber")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@NotNull(message = "Este campo no puede estar vacio")
	@Column (name = "checkNumber")
	private double amount;

	public Customer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [checkNumber=" + checkNumber + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}
	
}