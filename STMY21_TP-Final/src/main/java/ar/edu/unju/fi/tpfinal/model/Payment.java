package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "PAYMENTS")
@Component("paymentObj")
public class Payment {

	//private static final long serialVersionUID = 1L;
	
	//@EmbeddedId
	//private PaymentId id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checkNumber")
	private Long checkNumber;
	
	@NotNull
	@Column(name = "paymentDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@Min( value = 1 )
	@Column(name = "amount", columnDefinition = "DECIMAL(10,2)")
	private double amount;
	
	@Valid
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name = "cust_id")
	private Customer customer;
	
	public Payment() {
		// TODO Auto-generated constructor stub
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


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Long getCheckNumber() {
		return checkNumber;
	}


	public void setCheckNumber(Long checkNumber) {
		this.checkNumber = checkNumber;
	}


	@Override
	public String toString() {
		return "Payment [checkNumber=" + checkNumber + ", paymentDate=" + paymentDate + ", amount=" + amount
				+ ", customer=" + customer + "]";
	}

	
	
	
	
}
