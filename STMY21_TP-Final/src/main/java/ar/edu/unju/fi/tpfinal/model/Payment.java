package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "PAYMENTS")
@Component("paymentObj")
public class Payment {

	@Id
	@Column(name = "checkNumber")
	@NotEmpty(message="El campo checkNumber no debe estar vacio")
	private String checkNumber;
	
	@Autowired
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="customerNumber")
	@NotNull(message = "El campo no puede estar vacio")
	private Customer customer;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "El campo no puede estar vacio")
	private LocalDate paymentDate;
	
	@Min(value=0, message = "No puede ingresar valores negativos")
	@Column(name = "amount", columnDefinition = "DECIMAL(10,2)")
	@NotNull(message = "El campo amount no puede estar vacio")
	private Double amount;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [checkNumber=" + checkNumber + ", customer=" + customer + ", paymentDate=" + paymentDate
				+ ", amount=" + amount + "]";
	}
	
}